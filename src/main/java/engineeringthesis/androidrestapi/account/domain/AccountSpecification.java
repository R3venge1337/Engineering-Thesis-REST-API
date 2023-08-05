package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.account.dto.AccountFilterForm;
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
class AccountSpecification implements Specification<Account> {

    private final AccountFilterForm specificationForm;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        addLikePredicate(criteriaBuilder, predicates, root.get(Account.Fields.nickname), specificationForm.nickname());
        addLikePredicate(criteriaBuilder, predicates, root.get(Account.Fields.email), specificationForm.email());

        addEqualPredicate(criteriaBuilder, predicates, root.get(Account.Fields.isActive), specificationForm.isActive());
        addEqualPredicate(criteriaBuilder, predicates, root.get(Account.Fields.role).get("name"), specificationForm.role());
        return buildAndPredicates(criteriaBuilder, predicates);
    }
}
