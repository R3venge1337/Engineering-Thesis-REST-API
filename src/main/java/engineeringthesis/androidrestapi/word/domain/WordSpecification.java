package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.word.dto.WordFilterForm;
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
class WordSpecification implements Specification<Word> {

    private final WordFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Word> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Word.Fields.name), specificationForm.name());
        addLikePredicate(criteriaBuilder, predicates, root.get(Word.Fields.category).get("name"), specificationForm.category());
        addLikePredicate(criteriaBuilder, predicates, root.get(Word.Fields.language).get("name"), specificationForm.language());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
