package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.teacher.dto.TeacherFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.addEqualPredicate;
import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.addLikePredicate;
import static engineeringthesis.androidrestapi.common.repository.PredicateUtils.buildAndPredicates;

@RequiredArgsConstructor
public class TeacherSpecification implements Specification<Teacher> {

    private final TeacherFilterForm specificationForm;

    @Override
    public Predicate toPredicate(final Root<Teacher> root, final CriteriaQuery<?> query, final CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Teacher.Fields.name), specificationForm.name());
        addLikePredicate(criteriaBuilder, predicates, root.get(Teacher.Fields.surname), specificationForm.surname());
        addLikePredicate(criteriaBuilder, predicates, root.get(Teacher.Fields.city), specificationForm.city());

        addEqualPredicate(criteriaBuilder, predicates, root.get(Teacher.Fields.yearOfBirth), specificationForm.yearOfBirth());
        addEqualPredicate(criteriaBuilder, predicates, root.get(Teacher.Fields.languageTeacher).get("nickname"), specificationForm.language());
        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
