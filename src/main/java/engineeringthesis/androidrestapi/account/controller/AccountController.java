package engineeringthesis.androidrestapi.account.controller;

import java.util.List;

import engineeringthesis.androidrestapi.account.AccountFacade;
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

import engineeringthesis.androidrestapi.account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/accounts")
@RequiredArgsConstructor
class AccountController {
	
	private final AccountFacade accountFacade;
	private static final int MAX_SIZE = 20;
	
	@GetMapping
    List<AccountDTO> getAllAccounts(@RequestParam(required=false) Integer page,Sort.Direction sort)
    {
		return accountFacade.getAllAccounts(page,MAX_SIZE,sort);
    }
    
	
    @GetMapping(value = "/{accountId}")
   AccountDTO getAccountById(@PathVariable Integer accountId )
    {
		  return accountFacade.getOneById(accountId);
    }
    
    
    @GetMapping(params="accountExpiredAge")
    List<AccountDTO> getExpiredAccounts(@RequestParam(required=false) Integer accountExpiredAge)
     {
 		  return accountFacade.getExpiredAccounts(accountExpiredAge);
     }
    
    @GetMapping(params="accountName")
    AccountDTO getAccountByName(@RequestParam("accountName") String accountName )
    {
		return accountFacade.getOneByName(accountName);
    }
    
    @PostMapping
    AccountDTO saveAccount(@RequestBody AccountDTO accountObj)
    {
    	return accountFacade.saveAccount(accountObj);
    }
    
    @PutMapping(value = "/{accountId}")
    AccountDTO updateAccount(@PathVariable Integer accountId,
    						@RequestBody AccountDTO accountObj)
    {
    	return accountFacade.updateAccount(accountId,accountObj);
    }
    
    @DeleteMapping(value = "/{accountId}")
    void deleteAccountById(@PathVariable Integer accountId)
    {
    	accountFacade.deleteAccount(accountId);
    }
    
}
