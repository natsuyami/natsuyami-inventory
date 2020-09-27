package com.natsuyami.inventory.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ni_shops")
public class Shop implements Serializable {

    private static final long serialVersionUID = 629430758404133415L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id", unique = true, nullable = false)
    private long id;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "shop_description")
    private String shopDescription;

    @Column(name = "days_of_operation")
    private String daysOfOperation;

    @Column(name = "open_hour")
    @Temporal(TemporalType.TIME)
    private Date openHour;

    @Column(name = "closing_hour")
    @Temporal(TemporalType.TIME)
    private Date closingHour;

    @Column(name = "createdBy")
    private String createdBy;

    @OneToMany(mappedBy = "shop")
    private Set<ShopProduct> shopProducts;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getDaysOfOperation() {
        return daysOfOperation;
    }

    public void setDaysOfOperation(String daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
    }

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Date closingHour) {
        this.closingHour = closingHour;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Set<ShopProduct> getShopProducts() {
        return shopProducts;
    }

    public void setShopProducts(Set<ShopProduct> shopProducts) {
        this.shopProducts = shopProducts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

}
