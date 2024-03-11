package com.qaracter.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qaracter.entities.UserEntity;
import com.qaracter.mappers.UserMapper;
import com.qaracter.models.Credentials;
import com.qaracter.models.User;
import com.qaracter.repositories.UserRepository;
import com.qaracter.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        List<User> models = new ArrayList<>();
        for(UserEntity entity : entities) {
            models.add(UserMapper.toModel(entity));
        }
        return models;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        Optional<UserEntity> optEntity = userRepository.findById(id);
        return optEntity.map(userEntity -> Optional.of(UserMapper.toModel(userEntity))).orElseGet(() -> Optional.of(null));
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity userTmp = userRepository.save(entity);
        return UserMapper.toModel(userTmp);
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {
        UserEntity entity = UserMapper.toEntity(updatedUser);
        if (updatedUser.getId() != null && userRepository.existsById(updatedUser.getId())) {
            return UserMapper.toModel(userRepository.save(entity));
        }
        throw new RuntimeException("User not found with id: " + updatedUser.getId());
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

	@Override
	public User getUserByCredentials(Credentials credentials) {
		
		UserEntity entity = userRepository.findUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
		
		if(entity != null) {			
			return UserMapper.toModel(entity);
		}
		
		return null;
		
	}

}