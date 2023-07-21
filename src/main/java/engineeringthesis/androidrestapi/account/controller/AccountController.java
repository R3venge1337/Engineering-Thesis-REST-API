package engineeringthesis.androidrestapi.account.controller;

import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountForm;
import lombok.RequiredArgsConstructor;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/accounts")
@RequiredArgsConstructor
class AccountController {

    private final AccountFacade accountFacade;
    private static final int MAX_SIZE = 20;

    @GetMapping
    List<AccountDto> getAllAccounts(@RequestParam(required = false) final Integer page, final Sort.Direction sort) {
        return accountFacade.getAllAccounts(page, MAX_SIZE, sort);
    }

    @GetMapping(params = "accountExpiredAge")
    List<AccountDto> getExpiredAccounts(@RequestParam(required = false) final Integer accountExpiredAge) {
        return accountFacade.getExpiredAccounts(accountExpiredAge);
    }

    @GetMapping(params = "accountName")
    AccountDto getAccountByName(@RequestParam("accountName") final String accountName) {
        return accountFacade.findAccount(accountName);
    }

    @PostMapping
    AccountDto saveAccount(@RequestBody final AccountForm accountObj) {
        return accountFacade.saveAccount(accountObj);
    }

    @PutMapping(value = "/{uuid}")
    void updateAccount(@PathVariable final UUID uuid,
                       @RequestBody final AccountForm accountForm) {
        accountFacade.updateAccount(uuid, accountForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteAccount(@PathVariable final UUID uuid) {
        accountFacade.deleteAccount(uuid);
    }

}
