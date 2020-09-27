package com.natsuyami.inventory.dto;

import java.io.Serializable;

public class ShopDto implements Serializable {

    private static final long serialVersionUID = -5288252174501458083L;

    private long id;

    private String shopName;

    private String shopDescription;

    private String daysOfOperation;

    private String hourOpening;

    private String hourClosing;

    public long addressId;

    private String createdBy;

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

    public String getHourOpening() {
        return hourOpening;
    }

    public void setHourOpening(String openHour) {
        this.hourOpening = openHour;
    }

    public String getHourClosing() {
        return hourClosing;
    }

    public void setHourClosing(String hourClosing) {
        this.hourClosing = hourClosing;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"shopName\" : ");
        builder.append("\"" + shopName + "\", ");
        builder.append("\"shopDescription\" : ");
        builder.append("\"" + shopDescription + "\", ");
        builder.append("\"daysOfOperation\" : ");
        builder.append("\"" + daysOfOperation + "\", ");
        builder.append("\"openHour\" : ");
        builder.append("\"" + hourOpening + "\", ");
        builder.append("\"closingHour\" : ");
        builder.append("\"" + hourClosing + "\", ");
        builder.append("\"createdBy\" : ");
        builder.append("\"" + createdBy + "\", ");
        builder.append("\"addressId\" : ");
        builder.append("\"" + addressId + "\"");
        builder.append("}");
        return builder.toString();
    }
}
