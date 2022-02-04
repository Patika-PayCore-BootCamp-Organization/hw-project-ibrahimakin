package com.patika.test.service;

import com.patika.test.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    boolean addUser(User user);

    boolean deleteUser(Integer id);

    User updateUser(String name, User user);
}
