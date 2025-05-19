package com.example.project.Library_Management_System.repository;

import com.example.project.Library_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {

boolean existsByUsername(String username);
}
