package com.natsuyami.inventory.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ni_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 3016449867424714789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    private long id;

    @Column(name = "role", unique = true, nullable = false)
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
        this.role = role.toUpperCase();
    }
}
