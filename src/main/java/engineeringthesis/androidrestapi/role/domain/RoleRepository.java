package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.repository.query.Param;

interface RoleRepository extends UUIDAwareJpaRepository<Role, Integer> {

    Role findByRoleName(final String roleName);
}
