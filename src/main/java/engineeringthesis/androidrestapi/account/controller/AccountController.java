package engineeringthesis.androidrestapi.account.controller;

import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountFilterForm;
import engineeringthesis.androidrestapi.account.dto.CreateAccountForm;
import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.account.controller.AccountController.Routes.ROOT;
import static engineeringthesis.androidrestapi.account.controller.AccountController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class AccountController {

    private final AccountFacade accountFacade;

    static final class Routes {
        static final String ROOT = "/accounts";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<AccountDto> findAccounts(@RequestBody final AccountFilterForm filterForm, final PageableRequest pageableRequest) {
        return accountFacade.findAllAccounts(filterForm, pageableRequest);
    }

    @GetMapping(value = ROOT, params = "expiredAge")
    List<AccountDto> findExpiredAccounts(@RequestParam final Integer expiredAge) {
        return accountFacade.findExpiredAccounts(expiredAge);
    }

    @GetMapping(value = ROOT_UUID)
    AccountDto findAccount(@PathVariable final UUID uuid) {
        return accountFacade.findAccount(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveAccount(@RequestBody final CreateAccountForm createForm) {
        return accountFacade.saveAccount(createForm);
    }

    @PutMapping(value = ROOT_UUID)
    void updateAccount(@PathVariable final UUID uuid,
                       @RequestBody final UpdateAccountForm updateForm) {
        accountFacade.updateAccount(uuid, updateForm);
    }

    @DeleteMapping(value = ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAccount(@PathVariable final UUID uuid) {
        accountFacade.deleteAccount(uuid);
    }
}
