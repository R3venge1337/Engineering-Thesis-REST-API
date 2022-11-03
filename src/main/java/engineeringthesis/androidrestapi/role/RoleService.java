package engineeringthesis.androidrestapi.role;

import java.util.List;

public interface RoleService {

	List<RoleDTO> getAllRoles();
	
	RoleDTO getOneRoleByName(String roleName);
	
	RoleDTO getOneRoleById(Integer roleId);
	
	RoleDTO saveRole(RoleDTO role);
	
	void deleteRole(Integer roleId);
}
