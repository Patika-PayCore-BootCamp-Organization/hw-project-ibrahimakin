package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByUsername(String username);

    User findByUsername(String username);

    void deleteByUsername(String username);

}