package az.springbootlessons.faketweetapp.model.genericSearch;

import az.springbootlessons.faketweetapp.model.Comment;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import jakarta.persistence.criteria.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Slf4j
public class CustomSpecification<T> implements Specification<T> {
    private final List<SearchCriteria> list = new ArrayList<>();

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    public CustomSpecification(List<SearchCriteria> searchCriteriaList) {
        this.list.addAll(searchCriteriaList);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : list) {
            log.info("criteria: {}", criteria);
            if (criteria.getOperation().equals(SearchOperation.JOIN)) {
                String[] getter = criteria.getKey().split("\\.");
                if (getter[0].equals("posts")) {
                    Join<Post, User> postUserJoin = root.join("posts");
                    predicates.add(criteriaBuilder.like(postUserJoin.get(getter[1]), "%" + criteria.getValue() + "%"));
                } else if (getter[0].equals("comments")) {
                    Join<Comment, User> commentUserJoin = root.join("comments");
                    predicates.add(criteriaBuilder.like(commentUserJoin.get(getter[1]), "%" + criteria.getValue() + "%"));
                }
            } else {
                if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                    predicates.add(criteriaBuilder.greaterThan(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                    predicates.add(criteriaBuilder.lessThan(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_OR_EQUAL)) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_OR_EQUAL)) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                    predicates.add(criteriaBuilder.notEqual(
                            root.get(criteria.getKey()), criteria.getValue()));
                } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                    predicates.add(criteriaBuilder.equal(
                            root.get(criteria.getKey()), criteria.getValue()));
                } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                    predicates.add(criteriaBuilder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%"));
                } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                    predicates.add(criteriaBuilder.like(
                            root.get(criteria.getKey()), criteria.getValue() + "%"));
                } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                    predicates.add(criteriaBuilder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue()));
                }
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
