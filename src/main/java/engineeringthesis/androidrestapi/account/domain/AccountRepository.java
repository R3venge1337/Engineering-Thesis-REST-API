package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface AccountRepository extends UUIDAwareJpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    Boolean existsByName(final String name);

    Optional<Account> findByName(final String name);

    @Query("SELECT a FROM Account a WHERE YEAR(current_date) - YEAR(a.createdDate) > :expiredAge")
    List<Account> findExpiredAccounts(final Integer expiredAge);
}
