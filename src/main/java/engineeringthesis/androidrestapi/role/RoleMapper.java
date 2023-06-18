package engineeringthesis.androidrestapi.role;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class RoleMapper implements Mapper<RoleDTO,RoleEntity> {

	@Override
	public RoleDTO mapOfEntity(RoleEntity entity) {
		RoleDTO roleDTO = RoleDTO.builder()
				.roleId(entity.getRoleId())
				.roleName(entity.getRoleName())
				.roleCreatedDate(entity.getRoleCreatedDate())
				.build();
		return roleDTO;
	}

	@Override
	public RoleEntity mapOfDTO(RoleDTO dto) {
		RoleEntity roleEntity = RoleEntity.builder()
				.roleId(dto.getRoleId())
				.roleName(dto.getRoleName())
				.roleCreatedDate(dto.getRoleCreatedDate())
				.build();
		return roleEntity;
	}


}
