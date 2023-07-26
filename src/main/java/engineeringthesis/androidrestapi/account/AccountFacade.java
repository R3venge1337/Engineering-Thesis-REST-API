package engineeringthesis.androidrestapi.account;


import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountFilterForm;
import engineeringthesis.androidrestapi.account.dto.CreateAccountForm;
import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;

import java.util.List;
import java.util.UUID;

public interface AccountFacade {

    PageDto<AccountDto> findAllAccounts(final AccountFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveAccount(final CreateAccountForm createForm);

    AccountDto findAccountByName(final String name);

    AccountDto findAccount(final UUID uuid);

    void updateAccount(final UUID uuid, final UpdateAccountForm updateForm);

    List<AccountDto> findExpiredAccounts(final Integer accountExpiredAge);

    void deleteAccount(final UUID uuid);
}
