package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.dto.ChildFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.*;

@RequiredArgsConstructor
class ChildSpecification implements Specification<Child> {

    private final ChildFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Child> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Child.Fields.name), specificationForm.name());
        addLikePredicate(criteriaBuilder, predicates, root.get(Child.Fields.surname), specificationForm.surname());
        addLikePredicate(criteriaBuilder, predicates, root.get(Child.Fields.city), specificationForm.city());

        addEqualPredicate(criteriaBuilder, predicates, root.get(Child.Fields.yearOfBirth), specificationForm.yearOfBirth());


        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
