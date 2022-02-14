package com.iAKIN.LanguageApp.model.user;

import com.iAKIN.LanguageApp.model.role.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String email;
    List<Role> roles;

}