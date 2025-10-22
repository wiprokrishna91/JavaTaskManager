package com.taskmanager.controller;

import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PostMapping
    public Task createTask(@RequestParam String title, 
                          @RequestParam String description, 
                          @RequestParam Long userId) {
        return taskService.createTask(title, description, userId);
    }

    @PutMapping("/{taskId}/status")
    public Task updateTaskStatus(@PathVariable Long taskId, @RequestParam boolean completed) {
        return taskService.updateTaskStatus(taskId, completed);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}