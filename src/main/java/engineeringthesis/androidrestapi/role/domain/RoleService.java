package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class RoleService implements RoleFacade {

    private final RoleRepository roleRepository;
    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public List<RoleDto> getAllRoles() {

        return roleRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public RoleDto getOneRoleByName(final String roleName) {
        return mapToDto(roleRepository.findByName(ROLE_PREFIX + roleName));
    }

    @Override
    public RoleDto findRole(final UUID uuid) {
        return roleRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public RoleDto saveRole(final CreateRoleForm roleForm) {
        Role role = new Role();


        return mapToDto(roleRepository.save(role));
    }

    @Override
    @Transactional
    public void updateRole(final UUID uuid, final UpdateRoleForm roleForm) {
        Role role = roleRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

    }

    @Override
    @Transactional
    public void deleteRole(final UUID uuid) {
        roleRepository.deleteByUuid(uuid);
    }

    RoleDto mapToDto(final Role role) {
        return new RoleDto(role.getName(), role.getCreatedDate());
    }

}
