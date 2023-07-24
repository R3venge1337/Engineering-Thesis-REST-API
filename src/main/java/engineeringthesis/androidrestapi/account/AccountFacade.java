package engineeringthesis.androidrestapi.account;


import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.account.dto.CreateAccountForm;
import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.account.dto.AccountFilterForm;

import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;

public interface AccountFacade {

    PageDto<AccountDto> findAllAccounts(final AccountFilterForm filterForm, final PageableRequest pageableRequest);

    AccountDto saveAccount(final CreateAccountForm createForm);

    AccountDto findAccount(final String name);

    void updateAccount(final UUID uuid, final UpdateAccountForm updateForm);

    List<AccountDto> findExpiredAccounts(final Integer accountExpiredAge);

    void deleteAccount(final UUID uuid);
}
