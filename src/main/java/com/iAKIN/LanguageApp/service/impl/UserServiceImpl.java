package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.repository.UserRepository;
import com.iAKIN.LanguageApp.model.User;
import com.iAKIN.LanguageApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get();
        return null;
    }

    @Override
    public boolean addUser(User user) {
        User save = userRepository.save(user);
        if (save == null) return false;
        return true;
    }

    @Override
    public User updateUser(User user) { return userRepository.save(user); }

    @Override
    public boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
