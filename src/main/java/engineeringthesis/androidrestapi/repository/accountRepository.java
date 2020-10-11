package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.AccountEntity;

@Repository
public interface AccountRepository  extends JpaRepository<AccountEntity,Integer>{

}
