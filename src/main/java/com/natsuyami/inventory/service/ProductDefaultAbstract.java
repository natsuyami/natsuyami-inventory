package com.natsuyami.inventory.service;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.dto.builder.ProductDtoBuilder;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.repository.ProductRepository;
import com.natsuyami.inventory.repository.ShopProductRepository;
import com.natsuyami.inventory.repository.specification.ProductSpecification;
import com.natsuyami.inventory.repository.specification.SearchCriteria;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ProductDefaultAbstract implements DefaultImpl<ProductDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDefaultAbstract.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopProductRepository shopProductRepository;

    @Override
    public List<ProductDto> getAll() {
        LOGGER.info("Initialized ProductDefaultAbstract getAll() method");

        List<ProductDto> result = new ArrayList<>();

        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            result.add(ProductDtoBuilder.getInstance().build(product));
        }
        return result;
    }

    @Override
    public ProductDetailsDto getById(long id) {
        return new ProductDetailsDto();
    }

    @Override
    public List<ProductDto> search(String keyword) {
        LOGGER.info("Initialized ProductDefaultAbstract search() method with keyword={{}}", keyword);

        List<Product> products = findProductsWithKeyword(keyword);
        List<ProductDto> result = new ArrayList<>();

        LOGGER.info("Product search result size={{}}", products.size());
        for (Product product : products) {
            ProductDto productDetailsDto = ProductDtoBuilder.getInstance().build(product);
            result.add(productDetailsDto);
        }

        return result;
    }

    public Product findById(long id) {
        LOGGER.info("Initialized ProductDefaultAbstract findById() method with id={{}}", id);

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }

        return null;
    }

    public List<Product> findProductsWithKeyword(String keyword) {
        LOGGER.info("Initialized ProductDefaultAbstract findProductsWithKeyword() method with keyword={{}}", keyword);

        ProductSpecification specsProduct = new ProductSpecification(new SearchCriteria("productName", "like", keyword));
        List<Product> products = productRepository.findAll(specsProduct);

        return products;
    }

}
