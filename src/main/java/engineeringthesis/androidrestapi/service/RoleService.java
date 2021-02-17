package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.RoleDTO;

public interface RoleService {

	List<RoleDTO> getAllRoles();
	
	RoleDTO getOneRoleByName(String roleName);
	
	RoleDTO getOneRoleById(Integer roleId);
	
	RoleDTO saveRole(RoleDTO role);
	
	void deleteRole(Integer roleId);
}
