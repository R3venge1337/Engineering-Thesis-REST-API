package engineeringthesis.androidrestapi.account.domain;


import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountForm;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.account.domain.AccountService.ErrorMessages.ACCOUNT_NOT_EXIST;


@RequiredArgsConstructor
class AccountService implements AccountFacade {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    static final class ErrorMessages {
        static final String ACCOUNT_NOT_EXIST = "Account not exist";

    }

    @Override
    public List<AccountDto> getAllAccounts(final Integer page, final Integer size, final Sort.Direction sort) {
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return accountRepository.findAll(PageRequest.of(pageNumber, size, Sort.by(sortDirection, "accountId")))
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public AccountDto saveAccount(final AccountForm accountForm) {
        DtoValidator.validate(accountForm);

        final Account account = new Account();
        account.setName(accountForm.accountName());
        account.setEmail(accountForm.accountEmail());
        account.setIsActive(accountForm.active());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setCreatedDate(LocalDateTime.now());

        return mapToDto(accountRepository.save(account));
    }

    @Override
    public AccountDto findAccount(final String name) {

        return mapToDto(accountRepository.findByAccountName(name));
    }

    @Override
    @Transactional
    public void updateAccount(final UUID uuid, final AccountForm accountForm) {
        DtoValidator.validate(accountForm);
        final Account accountEntity = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(ACCOUNT_NOT_EXIST));

        accountEntity.setName(accountForm.accountName());
        accountEntity.setPassword(passwordEncoder.encode(accountForm.accountPassword()));
        accountEntity.setEmail(accountForm.accountEmail());
    }

    @Override
    @Transactional
    public void deleteAccount(final UUID uuid) {
        accountRepository.deleteByUuid(uuid);
    }

    @Override
    public List<AccountDto> getExpiredAccounts(final Integer accountExpiredAge) {
        return accountRepository.findExpiredAccounts(accountExpiredAge).stream()
                .map(this::mapToDto)
                .toList();
    }

    AccountDto mapToDto(final Account account) {
        return new AccountDto(account.getUuid(), account.getName(), account.getPassword(), account.getEmail(), account.getIsActive(), account.getCreatedDate(), account.getRole().getName());
    }

}
