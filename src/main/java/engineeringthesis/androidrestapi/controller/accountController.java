package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.model.account;
import engineeringthesis.androidrestapi.serviceImpl.accountServiceImpl;

@RestController
public class accountController {
	
	@Autowired
	accountServiceImpl accountServiceImpl;
	
	//@GetMapping
    @RequestMapping(value = {"/accounts"}, method = RequestMethod.GET)
    List<account> getAllAccounts()
    {
		return accountServiceImpl.getAllAccounts();
    }
    
    //@GetMapping
    @RequestMapping(value="/account/{accountId}",method=RequestMethod.GET)
    Optional<account> getAccountById(@PathVariable Integer accountId )
    {
		return accountServiceImpl.getOneById(accountId);
    }
    //@PostMapping
    @RequestMapping(value="/account",method = RequestMethod.POST)
    account saveAccount(@ModelAttribute account accountObj)
    {
    	return accountServiceImpl.saveAccount(accountObj);
    }
    @PutMapping
    @RequestMapping(value="/account",method = RequestMethod.PUT)
    account updateAccount(@ModelAttribute account accountObj)
    {
    	return accountServiceImpl.saveAccount(accountObj);
    }
    @DeleteMapping
    @RequestMapping(value="/account/{accountId}",method= RequestMethod.DELETE)
    void deleteAccountById(@PathVariable Integer accountId)
    {
    	accountServiceImpl.deleteAccount(accountId);
    }
	
	
}
