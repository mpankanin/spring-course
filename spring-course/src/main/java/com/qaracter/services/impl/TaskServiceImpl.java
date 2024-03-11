package com.qaracter.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.qaracter.models.Task;
import com.qaracter.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>();
    }

    @Override
    public Task getTaskById(Integer id) {
        return new Task();
    }

    @Override
    public List<Task> getAllUnassignedTasks() {
        return new ArrayList<>();
    }

    @Override
    public List<Task> getAllUserTasks(Integer userId) {
        return new ArrayList<>();
    }

    @Override
    public Task createTask(Task task) {
        return task;
    }

    @Override
    public Task updateTask(Integer id, Task task) {
        return task;
    }

    @Override
    public void deleteTask(Integer id) {
    }
    
}
