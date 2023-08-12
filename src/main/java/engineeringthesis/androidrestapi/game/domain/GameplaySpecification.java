package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.dto.GameplayFilterForm;
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
class GameplaySpecification implements Specification<Gameplay> {

    private final GameplayFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Gameplay> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();


        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
