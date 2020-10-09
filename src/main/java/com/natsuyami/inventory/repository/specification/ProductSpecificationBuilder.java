package com.natsuyami.inventory.repository.specification;

import com.natsuyami.inventory.dto.SearchCriteriaDto;
import com.natsuyami.inventory.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSpecificationBuilder {

    private List<SearchCriteriaDto> searchCriteriaDto;

    /**
     * instantiate SearchCriteriaDto
     */
    public ProductSpecificationBuilder() {
        searchCriteriaDto = new ArrayList<>();
    }

    /**
     * instantiate ProductSpecificationBuilder and add criteria
     * @param key - name of the attribute in the model
     * @param operation - type of query (e.g. : = like, = = equals, > = greater than equal, < = less than equal)
     * @param value - value to be search
     * @return ProductSpecificationBuilder - instantiated builder with criteria
     */
    public ProductSpecificationBuilder with(String key, String operation, String value) {
        searchCriteriaDto.add(new SearchCriteriaDto(key, operation, value));
        return this;
    }

    /**
     * instantiate ProductSpecificationBuilder and pass the criteria
     * @param searchCriteriaDto - criteria to be used
     * @return ProductSpecificationBuilder - instantiated builder with criteria
     */
    public ProductSpecificationBuilder with(List<SearchCriteriaDto> searchCriteriaDto) {
        this.searchCriteriaDto = searchCriteriaDto;
        return this;
    }

    /**
     * build specification that will be used by the jpa for querying data.
     * can be refactor so that it can be generic
     * @return Specification - product specification
     */
    public Specification<Product> build() {
        if (searchCriteriaDto.size() == 0) {
            return null;
        }

        List<Specification> specs = searchCriteriaDto.stream().map(ProductSpecification::new).collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int a=0; a < searchCriteriaDto.size(); a++) {
            result = Specification.where(result).and(specs.get(a));
        }

        return result;
    }
}
