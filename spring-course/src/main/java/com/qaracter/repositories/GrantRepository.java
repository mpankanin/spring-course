package com.qaracter.repositories;

import com.qaracter.entities.GrantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantRepository extends JpaRepository<GrantEntity, Integer> {
}
