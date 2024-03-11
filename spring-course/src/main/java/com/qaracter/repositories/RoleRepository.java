package com.qaracter.repositories;

import java.util.Optional;

import com.qaracter.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
