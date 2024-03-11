package com.qaracter.entities;

import com.qaracter.models.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleID;

    @Column(name = "rolename", nullable = false, length = 50)
    private String roleName;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @ManyToMany
    @JoinTable(name = "assigned_grants_to_role",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "grantid"))
    private Set<GrantEntity> grants = new HashSet<>();

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users = new HashSet<>();

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public Set<GrantEntity> getGrants() {
        return grants;
    }

    public void setGrants(Set<GrantEntity> grants) {
        this.grants = grants;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
