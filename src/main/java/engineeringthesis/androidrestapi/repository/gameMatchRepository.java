package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.gameMatch;

@Repository
public interface gameMatchRepository extends JpaRepository<gameMatch,Integer> {

}
