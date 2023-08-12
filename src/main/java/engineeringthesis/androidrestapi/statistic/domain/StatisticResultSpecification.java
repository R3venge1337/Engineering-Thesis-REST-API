package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.statistic.dto.StatisticResultFilterForm;
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
class StatisticResultSpecification implements Specification<StatisticResult> {

    private final StatisticResultFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<StatisticResult> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
