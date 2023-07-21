package engineeringthesis.androidrestapi.account;


import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.account.dto.AccountForm;
import org.springframework.data.domain.Sort;

import engineeringthesis.androidrestapi.account.dto.AccountDto;

public interface AccountFacade {
		
	List<AccountDto> getAllAccounts(final Integer page, final Integer size, final Sort.Direction sort);
	
	AccountDto saveAccount(final AccountForm account);
	
	AccountDto findAccount(final String name);

	void updateAccount(final UUID uuid, final AccountForm accountForm);
	
	List<AccountDto> getExpiredAccounts(final Integer  accountExpiredAge);
	
	void deleteAccount(final UUID uuid);
}
