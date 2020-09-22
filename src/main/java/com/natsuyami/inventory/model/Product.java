package com.natsuyami.inventory.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ni_products")
public class Product implements Serializable {

    private static final long serialVersionUID = 6032531647133471571L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", unique = true, nullable = false)
    private long id;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @OneToMany(mappedBy = "product")
    private Set<ShopProduct> shopProducts;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Set<ShopProduct> getShopProduct() {
        return shopProducts;
    }

    public void setShopProduct(Set<ShopProduct> shopProduct) {
        this.shopProducts = shopProduct;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

}
