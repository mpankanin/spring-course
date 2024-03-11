package com.qaracter.models;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;

import java.util.Set;

public class Role {
    @NotNull
    private Integer id;
    @NotNull
    @Size(max = 50)
    private String name;
    @Size(max = 255)
    private String description;

    private Set<User> users = new HashSet<>();
    private Set<Grant> grants = new HashSet<>();


    public Role(Set<User> users, Set<Grant> grants) {
        this.users = users;
        this.grants = grants;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Grant> getGrants() {
        return grants;
    }

    public void setGrants(Set<Grant> grants) {
        this.grants = grants;
    }

    public Role()
    {
    }
    
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Role(String name) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
