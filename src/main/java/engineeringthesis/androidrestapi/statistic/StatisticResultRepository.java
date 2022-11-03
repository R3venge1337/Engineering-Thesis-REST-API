package engineeringthesis.androidrestapi.statistic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticResultRepository extends JpaRepository<StatisticResultEntity,Integer> {

}
