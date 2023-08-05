package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

interface ChildAccountRepository extends UUIDAwareJpaRepository<ChildAccount, Long> {
    Boolean existsByName(final String name);
}
