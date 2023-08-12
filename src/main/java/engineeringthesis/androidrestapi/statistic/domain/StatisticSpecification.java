package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.statistic.dto.StatisticFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.buildAndPredicates;

@RequiredArgsConstructor
class StatisticSpecification implements Specification<StatisticType> {

    private final StatisticFilterForm specificationForm;
    @Override
    public Predicate toPredicate(final Root<StatisticType> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
