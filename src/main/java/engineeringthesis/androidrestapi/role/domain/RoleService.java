package engineeringthesis.androidrestapi.role.domain;

import java.util.List;

import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.RoleDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class RoleService implements RoleFacade {

	private final RoleRepository roleRepository;
	private final RoleMapper roleMapper;
	private String role_prefix = "ROLE_";
	@Override
	public List<RoleDTO> getAllRoles() {
		
		return roleMapper.mapOfCollection(roleRepository.findAll());
	}

	@Override
	public RoleDTO getOneRoleByName(String roleName) {
	
		return roleMapper.mapOfEntity(roleRepository.findByRoleName(role_prefix + roleName)) ;
	}
	
	@Override
	public RoleDTO getOneRoleById(Integer roleId) {
		
		return roleMapper.mapOfEntity(roleRepository.findById(roleId).get());
	}

	@Override
	public RoleDTO saveRole(RoleDTO role) {
		
		Role roleEntity = roleMapper.mapOfDTO(role);
		Role savedEntity = roleRepository.save(roleEntity);
		return  roleMapper.mapOfEntity(savedEntity);
	}

	@Override
	public void deleteRole(Integer roleId) {
		
		roleRepository.deleteById(roleId);
	}



}
