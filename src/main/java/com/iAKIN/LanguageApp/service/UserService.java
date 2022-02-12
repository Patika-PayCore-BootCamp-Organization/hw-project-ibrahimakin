package com.iAKIN.LanguageApp.service;

import com.iAKIN.LanguageApp.model.user.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    boolean addUser(User user);

    boolean deleteUser(Integer id);

    User updateUser(User user);
}
