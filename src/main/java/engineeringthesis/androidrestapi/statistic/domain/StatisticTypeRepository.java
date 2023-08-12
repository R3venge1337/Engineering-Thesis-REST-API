package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface StatisticTypeRepository extends UUIDAwareJpaRepository<StatisticType, Long>, JpaSpecificationExecutor<StatisticType> {
}
