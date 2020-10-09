package com.natsuyami.inventory.model;

import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ni_product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 8418845809541519543L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id", unique = true, nullable = false)
    private long id;

    @Column(name = "category", unique = true, nullable = false)
    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = StringUtils.capitalize(category);
    }
}
