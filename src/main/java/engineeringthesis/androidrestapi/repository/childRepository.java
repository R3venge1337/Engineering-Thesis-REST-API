package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.ChildEntity;

@Repository
public interface ChildRepository extends JpaRepository<ChildEntity,Integer> {
	
	@Query("SELECT c FROM ChildEntity c INNER JOIN AccountEntity acc ON c.accountChildId = acc.accountId WHERE acc.accountName = :accountName ")
	ChildEntity getChildWithAccount(@Param("accountName") String accountName);

}
