package engineeringthesis.androidrestapi.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<AccountEntity,Integer>{
	
	@Query("SELECT a FROM AccountEntity a WHERE a.accountName = :accountName")
	AccountEntity findByAccountName(@Param("accountName") String accountName);
	
	@Query("SELECT a FROM AccountEntity a WHERE YEAR(GETDATE()) - YEAR(a.accountCreatedDate) > :accountExpiredAge")
	List<AccountEntity> findExpiredAccounts(@Param("accountExpiredAge") Integer  accountExpiredAge);
}
