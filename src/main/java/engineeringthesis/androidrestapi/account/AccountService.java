package engineeringthesis.androidrestapi.account;


import java.util.List;

import org.springframework.data.domain.Sort;

public interface AccountService  {
		
	List<AccountDTO> getAllAccounts(Integer page, Integer size,Sort.Direction sort);
	
	AccountDTO saveAccount(AccountDTO account);
	
	AccountDTO getOneByName(String name);
	
	AccountDTO getOneById(Integer accountId);
	
	AccountDTO updateAccount(Integer accountId,AccountDTO account);
	
	List<AccountDTO> getExpiredAccounts(Integer  accountExpiredAge);
	
	void deleteAccount(Integer accountId);
}