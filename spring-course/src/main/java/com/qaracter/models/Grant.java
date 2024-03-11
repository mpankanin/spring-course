package com.qaracter.models;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class Grant {


    private Integer id;

    @NotNull
    @Size(max = 50)
    private String grantName;

    @Size(max = 255)
    private String description;

    @ManyToMany(mappedBy = "grants")
    private Set<Role> roles = new HashSet<>();

    public Grant() {
    }

    public Grant(int id, String grantName, String description, Set<Role> roles) {
        this.id = id;
        this.grantName = grantName;
        this.description = description;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
