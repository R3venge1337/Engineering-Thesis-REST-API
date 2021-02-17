package engineeringthesis.androidrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.RoleDTO;
import engineeringthesis.androidrestapi.serviceImpl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/roles")
@RequiredArgsConstructor
public class RoleController {
	
	
	private final  RoleServiceImpl roleServiceImpl;
	
	@GetMapping
    List<RoleDTO> getAllRoles()
    {
		return roleServiceImpl.getAllRoles();
    }
	
	
	@GetMapping(value = "/{roleId}" )
	RoleDTO getRoleById(@PathVariable Integer roleId )
	{
		return roleServiceImpl.getOneRoleById(roleId);
	}
	
	@GetMapping(params="name")
	RoleDTO getRoleByName(@RequestParam("name") String roleName )
	{
		return roleServiceImpl.getOneRoleByName(roleName);
	}
	
	@PostMapping
	RoleDTO saveRole(@RequestBody RoleDTO roleDTO)
	{
	   return roleServiceImpl.saveRole(roleDTO);
	}
	
	@DeleteMapping
	void deleteRoleById(@PathVariable Integer roleId)
	 {
		roleServiceImpl.deleteRole(roleId);
	 }
	 
}
