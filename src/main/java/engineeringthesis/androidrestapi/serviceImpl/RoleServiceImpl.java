package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import engineeringthesis.androidrestapi.dto.RoleDTO;
import engineeringthesis.androidrestapi.entity.RoleEntity;
import engineeringthesis.androidrestapi.mapper.RoleMapper;
import engineeringthesis.androidrestapi.repository.RoleRepository;
import engineeringthesis.androidrestapi.service.RoleService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

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
		
		RoleEntity roleEntity = roleMapper.mapOfDTO(role);
		RoleEntity savedEntity = roleRepository.save(roleEntity);
		return  roleMapper.mapOfEntity(savedEntity);
	}

	@Override
	public void deleteRole(Integer roleId) {
		
		roleRepository.deleteById(roleId);
	}



}
