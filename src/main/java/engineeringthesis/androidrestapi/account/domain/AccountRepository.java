package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface AccountRepository extends UUIDAwareJpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.name = :accountName")
    Account findByAccountName(final String accountName);

    @Query("SELECT a FROM Account a WHERE YEAR(current_date) - YEAR(a.accountCreatedDate) > :accountExpiredAge")
    List<Account> findExpiredAccounts(final Integer accountExpiredAge);
}
