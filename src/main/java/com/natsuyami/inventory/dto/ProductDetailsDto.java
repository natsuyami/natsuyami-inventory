package com.natsuyami.inventory.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProductDetailsDto extends ProductDto implements Serializable {

    private static final long serialVersionUID = 5862163852019253994L;

    private long shopId;

    private BigDecimal quantity;

    private String unit;

    private BigDecimal price;

    private String currency;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString().replace("}", ", "));
        builder.append("\"shopId\" : ");
        builder.append("\"" + shopId + "\", ");
        builder.append("\"quantity\" : ");
        builder.append("\"" + quantity + "\", ");
        builder.append("\"unit\" : ");
        builder.append("\"" + unit + "\", ");
        builder.append("\"price\" : ");
        builder.append("\"" + price + "\", ");
        builder.append("\"currency\" : ");
        builder.append("\"" + currency + "\"");
        builder.append("}");

        return builder.toString();
    }
}
