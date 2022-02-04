package com.patika.test.service.impl;

import com.patika.test.model.User;
import com.patika.test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    {
        users.add(new User("ibrahim AKIN", "ibrahimakin", "ibrahim@akin.com", "01.01.2020"));
        users.add(new User("Anakin", "anakin", "anakin@skywalker.com", "14.01.2020"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return users.add(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public User updateUser(String name, User user) {
        AtomicBoolean status = new AtomicBoolean(false);
        users.forEach(userItem -> {
            if (userItem.getUsername().equals(name)) {
                status.set(true);
                userItem.setUsername(user.getUsername());
            }
        });
        if (status.get()) return user;
        return null;
    }
}
