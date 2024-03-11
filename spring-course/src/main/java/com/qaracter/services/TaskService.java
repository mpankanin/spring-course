package com.qaracter.services;

import java.util.List;
import com.qaracter.models.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    public List<Task> getAllTasks();

    public Task getTaskById(Integer id);

    public List<Task> getAllUnassignedTasks();

    public List<Task> getAllUserTasks(Integer userId);

    public Task createTask(Task task);

    public Task updateTask(Integer id, Task task);

    public void deleteTask(Integer id);
    
    
}
