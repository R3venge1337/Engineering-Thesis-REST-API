package engineeringthesis.androidrestapi.statistic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticTypeRepository  extends JpaRepository<StatisticTypeEntity,Integer>{

}
