package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.StatisticResultEntity;

@Repository
public interface StatisticResultRepository extends JpaRepository<StatisticResultEntity,Integer> {

}
