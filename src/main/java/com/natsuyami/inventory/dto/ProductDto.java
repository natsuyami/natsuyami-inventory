package com.natsuyami.inventory.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 9100958229344878380L;

    private long id;

    private String productName;

    private String productDescription;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public void setCreated(Timestamp created) {
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
        builder.append("\"productDescription\" : ");
        builder.append("\"" + productDescription + "\", ");
        builder.append("\"Timestamp\" : ");
        builder.append("\"" + updated + "\", ");
        builder.append("\"created\" : ");
        builder.append("\"" + created + "\"");
        builder.append("}");
        return builder.toString();
    }
}
