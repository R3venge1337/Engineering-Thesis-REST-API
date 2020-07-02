package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.statisticResults;

@Repository
public interface statisticResultsRepository extends JpaRepository<statisticResults,Integer> {

}
