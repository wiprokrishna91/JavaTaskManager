package com.taskmanager.service;

import com.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Task> getTasksByUserId(Long userId) {
        return tasks.values().stream()
                .filter(task -> task.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public Task createTask(String title, String description, Long userId) {
        Long id = idGenerator.getAndIncrement();
        Task task = new Task(id, title, description, userId);
        tasks.put(id, task);
        return task;
    }

    public Task updateTaskStatus(Long taskId, boolean completed) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setCompleted(completed);
        }
        return task;
    }

    public void deleteTask(Long taskId) {
        tasks.remove(taskId);
    }
}