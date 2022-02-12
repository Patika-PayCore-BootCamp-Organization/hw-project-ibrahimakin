package com.iAKIN.LanguageApp.controller;

import com.iAKIN.LanguageApp.model.user.User;
import com.iAKIN.LanguageApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
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

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping(value = "/update")
    public User updateUser(@RequestBody final User user) { return userService.updateUser(user); }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteUser(@PathVariable @Min(1) final Integer id) { return userService.deleteUser(id); }
}