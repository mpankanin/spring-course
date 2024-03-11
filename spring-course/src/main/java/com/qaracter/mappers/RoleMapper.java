package com.qaracter.mappers;

import com.qaracter.entities.GrantEntity;
import com.qaracter.entities.RoleEntity;
import com.qaracter.entities.UserEntity;
import com.qaracter.models.Grant;
import com.qaracter.models.Role;
import com.qaracter.models.User;

import java.util.stream.Collectors;

public class RoleMapper {

        public static RoleEntity toEntity(Role role) {
            RoleEntity entity = new RoleEntity();
            entity.setRoleID(role.getId());
            entity.setRoleName(role.getName());
            entity.setDescription(role.getDescription());
            return entity;
        }

        public static Role toModel(RoleEntity entity) {
            Role role = new Role();
            role.setId(entity.getRoleID());
            role.setName(entity.getRoleName());
            role.setDescription(entity.getDescription());
            role.setUsers(entity.getUsers().stream().map(RoleMapper::toModel).collect(Collectors.toSet()));
            role.setGrants(entity.getGrants().stream().map(RoleMapper::toModel).collect(Collectors.toSet()));
            return role;
        }

        public static User toModel(UserEntity entity) {
            User user = new User();
            user.setId(entity.getUserID());
            user.setUsername(entity.getUsername());
            user.setEmail(entity.getEmail());
            return user;
        }


        public static Grant toModel(GrantEntity grantEntity){
            Grant grant = new Grant();
            grant.setId(grantEntity.getGrantID());
            grant.setGrantName(grantEntity.getGrantName());
            return grant;
        }

}
