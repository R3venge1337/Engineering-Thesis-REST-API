package engineeringthesis.androidrestapi.role;

import engineeringthesis.androidrestapi.role.dto.RoleDTO;

import java.util.List;

public interface RoleFacade {

	List<RoleDTO> getAllRoles();
	
	RoleDTO getOneRoleByName(String roleName);
	
	RoleDTO getOneRoleById(Integer roleId);
	
	RoleDTO saveRole(RoleDTO role);
	
	void deleteRole(Integer roleId);
}
