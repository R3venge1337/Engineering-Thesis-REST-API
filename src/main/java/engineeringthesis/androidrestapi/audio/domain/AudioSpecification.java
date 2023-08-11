package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.dto.AudioFilterForm;
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
class AudioSpecification implements Specification<Audio> {

    private final AudioFilterForm filterForm;

    @Override
    public Predicate toPredicate(final Root<Audio> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Audio.Fields.audioFileTable).get("audioFileTableName"), filterForm.filename());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
