package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

interface RoleRepository extends UUIDAwareJpaRepository<Role, Integer> {

    Role findByRoleName(final String roleName);
}
