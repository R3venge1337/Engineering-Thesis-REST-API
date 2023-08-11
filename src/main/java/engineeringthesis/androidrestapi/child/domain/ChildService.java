package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.*;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static engineeringthesis.androidrestapi.child.domain.ChildService.ErrorMessages.*;

@RequiredArgsConstructor
class ChildService implements ChildFacade {


    private final ChildRepository childRepository;

    private final ChildAccountRepository accountRepository;

    private final ChildRoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    static final class ErrorMessages {

        static final String CHILD_NOT_EXIST = "Child not exist";

        static final String CHILD_EXIST = "Child exist";
        static final String CHILD_ROLE_NOT_EXIST = "role not exist";
    }

    @Override
    public PageDto<ChildDto> findChildren(final ChildFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final ChildSpecification childSpecification = new ChildSpecification(filterForm);

        final Page<ChildDto> children = childRepository.findAll(childSpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(children);
    }

    @Override
    public ChildDto findChild(final UUID uuid) {
        return childRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(CHILD_NOT_EXIST));
    }

    @Override
    @Transactional
    public UuidDto saveChild(final CreateChildForm createForm) {
        DtoValidator.validate(createForm);
        checkUnique(createForm.account().name());

        final ChildRole role = roleRepository.findChildRoleByName(createForm.account().role())
                .orElseThrow(() -> new NotFoundException(CHILD_ROLE_NOT_EXIST));

        final ChildAccount account = new ChildAccount();
        account.setNickname(createForm.account().name());
        account.setPassword(passwordEncoder.encode(createForm.account().password()));
        account.setEmail(createForm.account().email());
        account.setIsActive(createForm.account().isActive());
        account.setRole(role);

        final Child child = new Child();
        child.setName(createForm.name());
        child.setSurname(createForm.surname());
        child.setYearOfBirth(createForm.childYearBirth());
        child.setCity(createForm.city());

        return new UuidDto(childRepository.save(child).getUuid());
    }

    @Override
    @Transactional
    public void updateChild(final UUID uuid, final UpdateChildForm updateForm) {
        DtoValidator.validate(updateForm);
        checkUnique(updateForm.account().name());

        final Child child = childRepository.findByUuid(uuid).orElseThrow(() -> new NotFoundException(CHILD_NOT_EXIST));

        final ChildRole role = roleRepository.findChildRoleByName(updateForm.account().role())
                .orElseThrow(() -> new NotFoundException(CHILD_ROLE_NOT_EXIST));

        final ChildAccount account = new ChildAccount();
        account.setNickname(updateForm.account().name());
        account.setPassword(passwordEncoder.encode(updateForm.account().password()));
        account.setEmail(updateForm.account().email());
        account.setIsActive(updateForm.account().isActive());
        account.setRole(role);

        child.setName(updateForm.name());
        child.setSurname(updateForm.surname());
        child.setCity(updateForm.city());
        child.setYearOfBirth(updateForm.yearOfBirth());
        child.setAccountChild(account);
    }

    @Override
    @Transactional
    public void deleteChild(final UUID uuid) {
        childRepository.deleteByUuid(uuid);
    }

    @Override
    public ChildWithAccountDto findChildWithAccount(final UUID uuid, final String accountName) {
        return childRepository.findChildWithAccount(accountName)
                .map(this::mapToChildWithAccountDto)
                .orElseThrow(() -> new NotFoundException(CHILD_NOT_EXIST));
    }

    private ChildDto mapToDto(final Child child) {
        return new ChildDto(child.getUuid(), child.getName(), child.getSurname(), child.getYearOfBirth(), child.getCity());
    }

    private ChildWithAccountDto mapToChildWithAccountDto(final Child child) {
        return new ChildWithAccountDto(child.getUuid(), child.getName(), child.getSurname(), child.getYearOfBirth(), child.getCity(), createAccountDto(child));
    }

    private ChildAccountDto createAccountDto(final Child child) {
        return new ChildAccountDto(child.getAccountChild().getUuid(), child.accountChild.getNickname(), child.accountChild.getPassword(), child.accountChild.getEmail(), child.accountChild.getIsActive(), child.getAccountChild().getRole().getName());
    }

    private void checkUnique(final String formLogin, final String entityLogin) {
        if (!formLogin.equals(entityLogin)) {
            checkUnique(formLogin);
        }
    }

    void checkUnique(final String login) {
        if (accountRepository.existsByNickname(login)) {
            throw new NotUniqueException(ChildAccount.Fields.nickname, CHILD_EXIST);
        }
    }
}
