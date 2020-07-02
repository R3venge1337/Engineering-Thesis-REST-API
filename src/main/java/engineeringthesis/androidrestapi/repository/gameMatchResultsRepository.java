package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.gameMatchResults;

@Repository
public interface gameMatchResultsRepository extends JpaRepository<gameMatchResults,Integer> {

}
