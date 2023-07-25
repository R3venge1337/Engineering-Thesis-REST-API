package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

import java.util.Optional;

interface AccountRoleRepository extends UUIDAwareJpaRepository<AccountRole, Long> {

    Optional<AccountRole> findByName(final String name);
}
