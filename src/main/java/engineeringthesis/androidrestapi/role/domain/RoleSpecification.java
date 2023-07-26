package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.role.dto.RoleFilterForm;
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
class RoleSpecification implements Specification<Role> {
    private final RoleFilterForm specificationForm;

    @Override
    public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Role.Fields.name), specificationForm.name());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
