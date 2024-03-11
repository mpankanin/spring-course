package com.qaracter.mappers;

import com.qaracter.entities.UserEntity;
import com.qaracter.models.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setUserID(user.getId());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setLastLogin(user.getLastLogin());
        entity.setEmail(user.getEmail());
        entity.setRole(RoleMapper.toEntity(user.getRole()));
        return entity;
    }

    public static User toModel(UserEntity entity) {
        User user = new User();
        user.setId(entity.getUserID());
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setEmail(entity.getEmail());
        user.setLastLogin(entity.getLastLogin());
        return user;
    }
}
