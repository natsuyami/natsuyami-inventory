package com.natsuyami.inventory.repository.specification;

import com.natsuyami.inventory.dto.SearchCriteriaDto;
import com.natsuyami.inventory.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    private SearchCriteriaDto searchCriteriaDto;

    /**
     * assign criteria to be used
     * @param searchCriteriaDto - criteria containing the key, operation and value
     */
    public ProductSpecification(SearchCriteriaDto searchCriteriaDto) {
        this.searchCriteriaDto = searchCriteriaDto;
    };

    /**
     * override predicate for custom query
     * @param root
     * @param query
     * @param criteriaBuilder
     * @return Predicate
     */
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (searchCriteriaDto.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.<String> get(searchCriteriaDto.getKey()), searchCriteriaDto.getValue().toString());
        } else if (searchCriteriaDto.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(root. <String> get(searchCriteriaDto.getKey()), searchCriteriaDto.getValue().toString());
        } else if (searchCriteriaDto.getOperation().equalsIgnoreCase("=")) {
            return criteriaBuilder.equal(root.get(searchCriteriaDto.getKey()), searchCriteriaDto.getValue().toString().toUpperCase());
        } else if (searchCriteriaDto.getOperation().equalsIgnoreCase(":")){
            return criteriaBuilder.like(root.<String> get(searchCriteriaDto.getKey()), "%" + searchCriteriaDto.getValue().toString().toUpperCase() + "%");
        }
        return null;
    }
}
