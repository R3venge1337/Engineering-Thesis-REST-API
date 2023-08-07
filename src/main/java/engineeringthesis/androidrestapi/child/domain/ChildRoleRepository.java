package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

import java.util.Optional;

interface ChildRoleRepository extends UUIDAwareJpaRepository<ChildRole, Long> {
    Optional<ChildRole> findChildRoleByName(final String name);
}

