package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.dto.GameFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.addLikePredicate;
import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.buildAndPredicates;

@RequiredArgsConstructor
class GameSpecification implements Specification<Game> {

    private final GameFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Game> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Game.Fields.name), specificationForm.name());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
