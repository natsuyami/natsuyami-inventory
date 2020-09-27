package com.natsuyami.inventory.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 9100958229344878380L;

    private long id;

    private String productName;

    private String brandName;

    private String productDescription;

    private long categoryId;

    private String createdBy;

    private Date updated;

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"productName\" : ");
        builder.append("\"" + productName + "\", ");
        builder.append("\"brandName\" : ");
        builder.append("\"" + brandName + "\", ");
        builder.append("\"productDescription\" : ");
        builder.append("\"" + productDescription + "\", ");
        builder.append("\"categoryId\" : ");
        builder.append("\"" + categoryId + "\", ");
        builder.append("\"createdBy\" : ");
        builder.append("\"" + createdBy + "\", ");
        builder.append("\"updated\" : ");
        builder.append("\"" + updated + "\", ");
        builder.append("\"created\" : ");
        builder.append("\"" + created + "\"");
        builder.append("}");
        return builder.toString();
    }
}
