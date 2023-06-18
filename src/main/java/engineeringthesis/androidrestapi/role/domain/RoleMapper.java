package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.role.dto.RoleDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class RoleMapper implements Mapper<RoleDTO, Role> {

	@Override
	public RoleDTO mapOfEntity(Role entity) {
		RoleDTO roleDTO = RoleDTO.builder()
				.roleId(entity.getRoleId())
				.roleName(entity.getRoleName())
				.roleCreatedDate(entity.getRoleCreatedDate())
				.build();
		return roleDTO;
	}

	@Override
	public Role mapOfDTO(RoleDTO dto) {
		Role roleEntity = Role.builder()
				.roleId(dto.getRoleId())
				.roleName(dto.getRoleName())
				.roleCreatedDate(dto.getRoleCreatedDate())
				.build();
		return roleEntity;
	}


}
