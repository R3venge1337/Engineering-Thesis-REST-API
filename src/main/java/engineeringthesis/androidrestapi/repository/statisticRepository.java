package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.statistic;

@Repository
public interface statisticRepository  extends JpaRepository<statistic,Integer>{

}
