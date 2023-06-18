package engineeringthesis.androidrestapi.statistic.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StatisticResultRepository extends JpaRepository<StatisticResult,Integer> {

}
