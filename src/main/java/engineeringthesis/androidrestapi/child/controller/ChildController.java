package engineeringthesis.androidrestapi.child.controller;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.*;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static engineeringthesis.androidrestapi.child.controller.ChildController.Routes.*;

@RestController
@RequiredArgsConstructor
class ChildController {

    private final ChildFacade childFacade;

    static final class Routes {
        static final String ROOT = "/children";

        static final String ROOT_UUID = ROOT + "/{uuid}";

        static final String ROOT_ACCOUNTS = ROOT_UUID + "/accounts";
    }

    @GetMapping(ROOT)
    PageDto<ChildDto> findChildren(@RequestBody final ChildFilterForm filterForm, final PageableRequest pageableRequest) {
        return childFacade.findChildren(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    ChildDto findChild(@PathVariable final UUID uuid) {
        return childFacade.findChild(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveChild(@RequestBody final CreateChildForm createForm) {
        return childFacade.saveChild(createForm);
    }

    @PutMapping(ROOT_UUID)
    void updateChild(@PathVariable final UUID uuid, @RequestBody final UpdateChildForm updateForm) {
        childFacade.updateChild(uuid, updateForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteChild(@PathVariable final UUID uuid) {
        childFacade.deleteChild(uuid);
    }

    @GetMapping(ROOT_ACCOUNTS)
    ChildWithAccountDto findChildWithAccount(@PathVariable final UUID uuid, @RequestParam final String accountName) {
        return childFacade.findChildWithAccount(uuid, accountName);
    }
}
