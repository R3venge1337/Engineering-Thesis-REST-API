package engineeringthesis.androidrestapi.role.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.RoleFilterForm;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.role.controller.RoleController.Routes.ROOT;
import static engineeringthesis.androidrestapi.role.controller.RoleController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class RoleController {

    private final RoleFacade roleFacade;

    static final class Routes {
        static final String ROOT = "/roles";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<RoleDto> findAllRoles(@RequestBody final RoleFilterForm filterForm, final PageableRequest pageableRequest) {
        return roleFacade.findAllRoles(filterForm, pageableRequest);
    }

    @GetMapping(value = ROOT_UUID)
    RoleDto findRole(@PathVariable final UUID uuid) {
        return roleFacade.findRole(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveRole(@RequestBody final CreateRoleForm roleForm) {
        return roleFacade.saveRole(roleForm);
    }

    @PutMapping(ROOT_UUID)
    void updateRole(@PathVariable final UUID uuid, @RequestBody final UpdateRoleForm roleForm) {
        roleFacade.updateRole(uuid, roleForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRole(@PathVariable final UUID uuid) {
        roleFacade.deleteRole(uuid);
    }

}
