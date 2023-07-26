package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.language.dto.LanguageFilterForm;
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
class LanguageSpecification implements Specification<Language> {

    private final LanguageFilterForm specificationForm;

    @Override
    public Predicate toPredicate(Root<Language> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Language.Fields.name), specificationForm.name());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
