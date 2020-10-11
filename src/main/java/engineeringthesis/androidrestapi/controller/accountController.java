package engineeringthesis.androidrestapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.AccountDTO;
import engineeringthesis.androidrestapi.serviceImpl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/accounts")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountServiceImpl accountServiceImpl;
	
	@GetMapping
    List<AccountDTO> getAllAccounts()
    {
		return accountServiceImpl.getAllAccounts();
    }
    
    @GetMapping(value = "/{accountId}")
    AccountDTO getAccountById(@PathVariable Integer accountId )
    {
		return accountServiceImpl.getOneById(accountId);
    }
    @PostMapping
    AccountDTO saveAccount(@RequestBody AccountDTO accountObj)
    {
    	return accountServiceImpl.saveAccount(accountObj);
    }
    
    @PutMapping(value = "/{accountId}")
    AccountDTO updateAccount(@PathVariable Integer accountId,
    						@RequestBody AccountDTO accountObj)
    {
    	return accountServiceImpl.updateAccount(accountId,accountObj);
    }
    @DeleteMapping(value = "/{accountId}")
    void deleteAccountById(@PathVariable Integer accountId)
    {
    	accountServiceImpl.deleteAccount(accountId);
    }
	
	
}
