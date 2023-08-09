package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.dto.CategoryFilterForm;
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
class CategorySpecification implements Specification<Category> {

    private final CategoryFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Category> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Category.Fields.language).get("name"), specificationForm.language());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
