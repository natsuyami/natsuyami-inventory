package com.natsuyami.inventory.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ni_address")
public class Address implements Serializable {

    private static final long serialVersionUID = 4138714355455192166L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", unique = true, nullable = false)
    private long id;

    @Column(name = "address_block", nullable = false)
    private String addressBlock;

    @Column(name = "baranggay", unique = true, nullable = false)
    private String baranggay;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region", nullable = false)
    private String region;

    @OneToMany(mappedBy = "address")
    private Set<Shop> shop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }

    public String getBaranggay() {
        return baranggay;
    }

    public void setBaranggay(String baranggay) {
        this.baranggay = baranggay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Shop> getShop() {
        return shop;
    }

    public void setShop(Set<Shop> shop) {
        this.shop = shop;
    }

}
