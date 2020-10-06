package com.natsuyami.inventory.repository;

import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {

    List<ShopProduct> findByProduct(Product product);
}
