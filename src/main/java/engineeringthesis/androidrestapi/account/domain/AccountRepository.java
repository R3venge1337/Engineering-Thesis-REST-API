package engineeringthesis.androidrestapi.account.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface AccountRepository  extends JpaRepository<Account,Integer>{
	
	@Query("SELECT a FROM AccountEntity a WHERE a.accountName = :accountName")
	Account findByAccountName(@Param("accountName") String accountName);
	
	@Query("SELECT a FROM AccountEntity a WHERE YEAR(GETDATE()) - YEAR(a.accountCreatedDate) > :accountExpiredAge")
	List<Account> findExpiredAccounts(@Param("accountExpiredAge") Integer  accountExpiredAge);
}
