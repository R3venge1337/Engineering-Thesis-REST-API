package engineeringthesis.androidrestapi.role;

import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;

import java.util.List;
import java.util.UUID;

public interface RoleFacade {

    List<RoleDto> getAllRoles();

    RoleDto getOneRoleByName(final String roleName);

    RoleDto findRole(final UUID uuid);

    RoleDto saveRole(final CreateRoleForm roleForm);

    void updateRole(final UUID uuid, final UpdateRoleForm roleForm);

    void deleteRole(final UUID uuid);
}
