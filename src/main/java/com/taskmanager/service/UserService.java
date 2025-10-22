package com.taskmanager.service;

import com.taskmanager.model.User;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public User createUser(String name) {
        Long id = idGenerator.getAndIncrement();
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }
}