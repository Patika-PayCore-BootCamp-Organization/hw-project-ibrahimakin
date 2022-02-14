package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> { }