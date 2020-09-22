package com.natsuyami.inventory.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.sql.Time;

public class ShopDto implements Serializable {

    private static final long serialVersionUID = -5288252174501458083L;

    @JsonProperty("shop_id")
    private long id;

    private String shopName;

    private String shopDescription;

    private String daysOfOperation;

    private Time openHour;

    private Time closingHour;

    public long addressId;

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

    public Time getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Time openHour) {
        this.openHour = openHour;
    }

    public Time getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Time closingHour) {
        this.closingHour = closingHour;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
        builder.append("\"" + openHour + "\", ");
        builder.append("\"closingHour\" : ");
        builder.append("\"" + closingHour + "\", ");
        builder.append("\"addressId\" : ");
        builder.append("\"" + addressId + "\"");
        builder.append("}");
        return builder.toString();
    }
}
