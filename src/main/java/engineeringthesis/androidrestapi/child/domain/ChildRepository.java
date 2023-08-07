package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

interface ChildRepository extends UUIDAwareJpaRepository<Child, Long>, JpaSpecificationExecutor<Child> {

    @Query("SELECT c FROM Child c INNER JOIN c.accountChild acc  WHERE acc.nickname = :accountName")
    Optional<Child> findChildWithAccount(final String accountName);

}
