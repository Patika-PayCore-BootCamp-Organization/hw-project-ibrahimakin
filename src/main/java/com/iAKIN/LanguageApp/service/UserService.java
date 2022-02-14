package com.iAKIN.LanguageApp.service;

import com.iAKIN.LanguageApp.model.user.User;
import javax.servlet.http.HttpServletRequest;

public interface UserService {

    String signin(String username, String password);

    String signup(User user);

    Object whoami(HttpServletRequest req);

    void delete(String username);
}