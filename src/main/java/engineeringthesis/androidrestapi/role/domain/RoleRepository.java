package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface RoleRepository extends UUIDAwareJpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    Boolean existsByName(final String name);
}
