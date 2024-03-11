package com.qaracter.controllers;

import com.qaracter.models.Task;
import com.qaracter.services.TaskService;
import com.qaracter.validators.TaskValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskValidator taskValidator;
    private final TaskService taskService;

    public TaskController(TaskValidator taskValidator, TaskService taskService) {
        this.taskValidator = taskValidator;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/unassigned")
    public ResponseEntity<List<Task>> getAllUnassignedTasks() {
        return ResponseEntity.ok(taskService.getAllUnassignedTasks());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getAllUserTasks(@PathVariable Integer userId) {
        return ResponseEntity.ok(taskService.getAllUserTasks(userId));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task, BindingResult result) {
        taskValidator.validate(task, result);
        if (!result.hasErrors()) {
            return ResponseEntity.status(201).body(taskService.createTask(task));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @Valid @RequestBody Task task, BindingResult result) {
        taskValidator.validate(task, result);
        if (!result.hasErrors()) {
            return ResponseEntity.ok(taskService.updateTask(id, task));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}





