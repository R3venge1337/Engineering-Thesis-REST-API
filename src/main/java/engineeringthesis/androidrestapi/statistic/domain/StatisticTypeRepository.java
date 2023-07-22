package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.stereotype.Repository;

interface StatisticTypeRepository extends UUIDAwareJpaRepository<StatisticType, Integer> {
}
