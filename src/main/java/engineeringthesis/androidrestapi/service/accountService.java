package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.account;

public interface accountService  {
		
	List<account> getAllAccounts();
	
	account saveAccount(account acc);
	
	account getOneByName(String name);
	
	Optional<account> getOneById(Integer accountId);
	
	void deleteAccount(Integer accountId);
}
