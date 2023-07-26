package engineeringthesis.androidrestapi.role;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.RoleFilterForm;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;

import java.util.UUID;

public interface RoleFacade {

    PageDto<RoleDto> findAllRoles(final RoleFilterForm filterForm, final PageableRequest pageableRequest);

    RoleDto findRole(final UUID uuid);

    UuidDto saveRole(final CreateRoleForm createForm);

    void updateRole(final UUID uuid, final UpdateRoleForm updateForm);

    void deleteRole(final UUID uuid);
}
