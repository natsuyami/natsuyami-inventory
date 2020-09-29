package com.natsuyami.inventory.dto;

import java.io.Serializable;
import java.util.Date;

public class AccountDto implements Serializable {

    private static final long serialVersionUID = 4314046542187290376L;

    private long id;

    private String username;

    private String password;

    private String emailAddress;

    private long roleId;

    private Date created;

    private Date updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\" : ");
        builder.append("\"" + id + "\", ");
        builder.append("\"username\" : ");
        builder.append("\"" + username + "\", ");
        builder.append("\"password\" : ");
        builder.append("\"" + password + "\", ");
        builder.append("\"emailAddress\" : ");
        builder.append("\"" + emailAddress + "\", ");
        builder.append("\"roleId\" : ");
        builder.append("\"" + roleId + "\", ");
        builder.append("\"created\" : ");
        builder.append("\"" + created + "\", ");
        builder.append("\"updated\" : ");
        builder.append("\"" + updated + "\"");
        builder.append("}");
        return builder.toString();
    }
}
