package engineeringthesis.androidrestapi.role.controller;

import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/api/roles")
@RequiredArgsConstructor
class RoleController {

    private final RoleFacade roleServiceImpl;

    @GetMapping
    List<RoleDto> getAllRoles() {
        return roleServiceImpl.getAllRoles();
    }

    @GetMapping(value = "/{uuid}")
    RoleDto findRole(@PathVariable final UUID uuid) {
        return roleServiceImpl.findRole(uuid);
    }

    @GetMapping(params = "name")
    RoleDto getRoleByName(@RequestParam("name") final String roleName) {
        return roleServiceImpl.getOneRoleByName(roleName);
    }

    @PostMapping
    RoleDto saveRole(@RequestBody final CreateRoleForm roleForm) {
        return roleServiceImpl.saveRole(roleForm);
    }

    @PutMapping("/{uuid}")
    void updateRole(@PathVariable final UUID uuid, @RequestBody final UpdateRoleForm roleForm) {
        roleServiceImpl.updateRole(uuid, roleForm);
    }

    @DeleteMapping
    void deleteRole(@PathVariable final UUID uuid) {
        roleServiceImpl.deleteRole(uuid);
    }

}
