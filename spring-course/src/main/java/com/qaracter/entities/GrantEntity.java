package com.qaracter.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grants")
public class GrantEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int grantID;
        @Column(name = "grantname", nullable = false, length = 50)
        private String grantName;
        @Column(name = "description", length = 255)
        private String description;

        @ManyToMany(mappedBy = "grants")
        private Set<RoleEntity> roles = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public GrantEntity() {
        }

        public GrantEntity(int grantID, String grantName, String description) {
            this.grantID = grantID;
            this.grantName = grantName;
            this.description = description;
        }

        public int getGrantID() {
            return grantID;
        }

        public void setGrantID(int grantID) {
            this.grantID = grantID;
        }

        public String getGrantName() {
            return grantName;
        }

        public void setGrantName(String grantName) {
            this.grantName = grantName;
        }
}
