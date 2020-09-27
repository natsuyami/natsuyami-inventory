package com.natsuyami.inventory.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = -4993584502591852199L;

    private long id;

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
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"category\" : ");
        builder.append("\"" + category + "\"");
        builder.append("}");
        return builder.toString();
    }
}
