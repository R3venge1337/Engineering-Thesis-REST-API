package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.account;

@Repository
public interface accountRepository  extends JpaRepository<account,Integer>{

}
