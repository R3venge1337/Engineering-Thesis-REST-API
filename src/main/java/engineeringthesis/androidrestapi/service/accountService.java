package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.AccountDTO;

public interface AccountService  {
		
	List<AccountDTO> getAllAccounts();
	
	AccountDTO saveAccount(AccountDTO account);
	
	AccountDTO getOneByName(String name);
	
	AccountDTO getOneById(Integer accountId);
	
	AccountDTO updateAccount(Integer accountId,AccountDTO account);
	
	void deleteAccount(Integer accountId);
}
