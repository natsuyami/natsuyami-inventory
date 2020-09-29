package com.natsuyami.inventory.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {

    private static final long serialVersionUID = 6078037895931320538L;

    private long id;

    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"role\" : ");
        builder.append("\"" + role + "\"");
        builder.append("}");
        return builder.toString();
    }
}
