package com.qaracter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qaracter.entities.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer>{
    
}
