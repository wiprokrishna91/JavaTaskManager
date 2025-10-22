package com.taskmanager.controller;

import com.taskmanager.service.UserService;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/user/{userId}")
    public String userTasks(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("tasks", taskService.getTasksByUserId(userId));
        return "tasks";
    }
}