package com.qaracter.mappers;


import com.qaracter.entities.TaskEntity;
import com.qaracter.entities.UserEntity;
import com.qaracter.models.Task;
import com.qaracter.models.User;

public class TaskMapper {

    public static TaskEntity toEntity(Task task) {
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(),StatusMapper.toEntity(task.getStatus()), new UserEntity() );
        
        
    }

    public static Task toModel(TaskEntity taskEntity) {
        return new Task(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getDueDate(), StatusMapper.toModel(taskEntity.getStatusEntity()), new User());
    }
}