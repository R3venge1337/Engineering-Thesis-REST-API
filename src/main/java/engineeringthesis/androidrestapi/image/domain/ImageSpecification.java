package engineeringthesis.androidrestapi.image.domain;

import engineeringthesis.androidrestapi.image.dto.ImageFilterForm;
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
class ImageSpecification implements Specification<Image> {

    private final ImageFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Image> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Image.Fields.imageFileTable).get("imageFileTableName"), specificationForm.filename());

        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
