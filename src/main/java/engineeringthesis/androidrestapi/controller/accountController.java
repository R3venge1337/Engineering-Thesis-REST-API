package engineeringthesis.androidrestapi.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.AccountDTO;
import engineeringthesis.androidrestapi.serviceImpl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/accounts")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountServiceImpl accountServiceImpl;
	private static final int MAX_SIZE = 20;
	
	@GetMapping
    List<AccountDTO> getAllAccounts(@RequestParam(required=false) Integer page,Sort.Direction sort)
    {
		return accountServiceImpl.getAllAccounts(page,MAX_SIZE,sort);
    }
    
	
    @GetMapping(value = "/{accountId}")
   AccountDTO getAccountById(@PathVariable Integer accountId )
    {
		  return accountServiceImpl.getOneById(accountId);
    }
    
    
    @GetMapping(params="accountExpiredAge")
    List<AccountDTO> getExpiredAccounts(@RequestParam(required=false) Integer accountExpiredAge)
     {
 		  return accountServiceImpl.getExpiredAccounts(accountExpiredAge);
     }
    
    @GetMapping(params="accountName")
    AccountDTO getAccountByName(@RequestParam("accountName") String accountName )
    {
		return accountServiceImpl.getOneByName(accountName);
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
