package engineeringthesis.androidrestapi.child.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface ChildRepository extends JpaRepository<Child,Integer> {
	
	@Query("SELECT c FROM ChildEntity c INNER JOIN AccountEntity acc ON c.accountChildId = acc.accountId WHERE acc.accountName = :accountName ")
	Child getChildWithAccount(@Param("accountName") String accountName);

}
