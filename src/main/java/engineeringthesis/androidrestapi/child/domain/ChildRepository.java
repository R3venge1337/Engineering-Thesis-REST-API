package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ChildRepository extends UUIDAwareJpaRepository<Child, Integer> {

    @Query("SELECT c FROM Child c INNER JOIN c.accountChild acc  WHERE acc.name = :accountName")
    Child getChildWithAccount(final String accountName);

}
