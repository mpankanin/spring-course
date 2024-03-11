package com.qaracter.repositories;

import com.qaracter.entities.UserEntity;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	@Query("SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.password = ?2")
	public UserEntity findUserByUsernameAndPassword(String username, String password);

}
