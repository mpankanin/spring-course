package com.qaracter.services;

import java.util.List;
import java.util.Optional;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserByCredentials(Credentials credentials);

    Optional<User> getUserById(Integer id);

    User createUser(User user);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
    
}
