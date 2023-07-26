package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.RoleFilterForm;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

import static engineeringthesis.androidrestapi.role.domain.RoleService.ErrorMessages.ROLE_FOUND;
import static engineeringthesis.androidrestapi.role.domain.RoleService.ErrorMessages.ROLE_NOT_EXIST;

@RequiredArgsConstructor
class RoleService implements RoleFacade {

    private final RoleRepository roleRepository;

    static final class ErrorMessages {
        static final String ROLE_NOT_EXIST = "Role not exist";
        static final String ROLE_FOUND = "Role was found";
    }

    @Override
    public PageDto<RoleDto> findAllRoles(final RoleFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final RoleSpecification specification = new RoleSpecification(filterForm);
        final Page<RoleDto> accounts = roleRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(accounts);
    }

    @Override
    public RoleDto findRole(final UUID uuid) {
        return roleRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(ROLE_NOT_EXIST));
    }

    @Override
    @Transactional
    public UuidDto saveRole(final CreateRoleForm createForm) {
        DtoValidator.validate(createForm);
        checkUnique(createForm.name());

        final Role role = new Role();
        role.setName(createForm.name());
        role.setCreatedDate(LocalDateTime.now());

        return new UuidDto(roleRepository.save(role).getUuid());
    }

    @Override
    @Transactional
    public void updateRole(final UUID uuid, final UpdateRoleForm updateForm) {
        DtoValidator.validate(updateForm);

        final Role role = roleRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(ROLE_NOT_EXIST, updateForm.name()));

        checkUnique(updateForm.name(), role.getName());

        role.setName(updateForm.name());
    }

    @Override
    @Transactional
    public void deleteRole(final UUID uuid) {
        roleRepository.deleteByUuid(uuid);
    }

    private RoleDto mapToDto(final Role role) {
        return new RoleDto(role.getUuid(), role.getName(), role.getCreatedDate());
    }

    private void checkUnique(final String formName, final String entityName) {
        if (!formName.equals(entityName)) {
            checkUnique(formName);
        }
    }

    void checkUnique(final String name) {
        if (roleRepository.existsByName(name)) {
            throw new NotUniqueException(Role.Fields.name, ROLE_FOUND);
        }
    }

}
