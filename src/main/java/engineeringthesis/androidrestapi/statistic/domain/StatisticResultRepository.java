package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


interface StatisticResultRepository extends UUIDAwareJpaRepository<StatisticResult, Long>, JpaSpecificationExecutor<StatisticResult> {
}
