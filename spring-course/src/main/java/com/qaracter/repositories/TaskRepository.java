package com.qaracter.repositories;

import com.qaracter.entities.TaskEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{

    //@Query("SELECT t FROM TaskEntity t WHERE t.userEntity IS NULL")
    //List<TaskEntity> findAllUnassignedTasks();

    //@Query("SELECT t FROM TaskEntity t WHERE t.userEntity.id = ?1")
    //List<TaskEntity> findAllUserTasks(Integer userId);





    
}
