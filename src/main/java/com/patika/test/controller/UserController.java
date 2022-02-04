package com.patika.test.controller;

import com.patika.test.model.User;
import com.patika.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    // @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}