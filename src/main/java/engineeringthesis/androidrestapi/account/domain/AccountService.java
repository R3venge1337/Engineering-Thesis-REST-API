package engineeringthesis.androidrestapi.account.domain;


import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountFilterForm;
import engineeringthesis.androidrestapi.account.dto.CreateAccountForm;
import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.account.domain.AccountService.ErrorMessages.ACCOUNT_FOUND_BY_LOGIN;
import static engineeringthesis.androidrestapi.account.domain.AccountService.ErrorMessages.ACCOUNT_NOT_EXIST;
import static engineeringthesis.androidrestapi.account.domain.AccountService.ErrorMessages.ACCOUNT_ROLE_NOT_EXIST;


@RequiredArgsConstructor
class AccountService implements AccountFacade {

    private final AccountRepository accountRepository;

    private final AccountRoleRepository accountRoleRepository;

    private final PasswordEncoder passwordEncoder;

    static final class ErrorMessages {
        static final String ACCOUNT_NOT_EXIST = "Account not exist";
        static final String ACCOUNT_ROLE_NOT_EXIST = "Account role not exist";
        static final String ACCOUNT_FOUND_BY_LOGIN = "Account was found";
    }

    @Override
    public PageDto<AccountDto> findAllAccounts(final AccountFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final AccountSpecification specification = new AccountSpecification(filterForm);
        final Page<AccountDto> accounts = accountRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(accounts);
    }

    @Override
    @Transactional
    public AccountDto saveAccount(final CreateAccountForm accountForm) {
        DtoValidator.validate(accountForm);
        checkUnique(accountForm.name());

        final AccountRole accountRole = accountRoleRepository.findByName(accountForm.role().name())
                .orElseThrow(() -> new NotFoundException(ACCOUNT_ROLE_NOT_EXIST, accountForm.role().name()));

        final Account account = new Account();
        account.setName(accountForm.name());
        account.setEmail(accountForm.email());
        account.setIsActive(accountForm.active());
        account.setPassword(passwordEncoder.encode(accountForm.password()));
        account.setCreatedDate(LocalDateTime.now());

        accountRole.addRole(account);

        return mapToDto(accountRepository.save(account));
    }

    @Override
    public AccountDto findAccount(final String name) {
        return accountRepository.findByName(name)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(ACCOUNT_NOT_EXIST));
    }

    @Override
    @Transactional
    public void updateAccount(final UUID uuid, final UpdateAccountForm accountForm) {
        DtoValidator.validate(accountForm);

        final Account account = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(ACCOUNT_NOT_EXIST));

        final AccountRole accountRole = accountRoleRepository.findByName(accountForm.role().name())
                .orElseThrow(() -> new NotFoundException(ACCOUNT_ROLE_NOT_EXIST, accountForm.role().name()));

        checkUnique(accountForm.name(), account.getName());

        account.setName(accountForm.name());
        account.setPassword(passwordEncoder.encode(accountForm.password()));
        account.setEmail(accountForm.email());
        account.setIsActive(accountForm.active());

    }

    @Override
    @Transactional
    public void deleteAccount(final UUID uuid) {
        accountRepository.deleteByUuid(uuid);
    }

    @Override
    public List<AccountDto> findExpiredAccounts(final Integer accountExpiredAge) {
        return accountRepository.findExpiredAccounts(accountExpiredAge).stream()
                .map(this::mapToDto)
                .toList();
    }

    AccountDto mapToDto(final Account account) {
        return new AccountDto(account.getUuid(), account.getName(), account.getPassword(), account.getEmail(), account.getIsActive(), account.getCreatedDate(), account.getRole().getName());
    }

    private void checkUnique(final String formLogin, final String entityLogin) {
        if (!formLogin.equals(entityLogin)) {
            checkUnique(formLogin);
        }
    }

    void checkUnique(final String login) {
        if (accountRepository.existsByName(login)) {
            throw new NotUniqueException(Account.Fields.name, ACCOUNT_FOUND_BY_LOGIN);
        }
    }

}
