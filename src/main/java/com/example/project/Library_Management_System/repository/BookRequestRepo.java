package com.example.project.Library_Management_System.repository;

import com.example.project.Library_Management_System.entity.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepo extends JpaRepository<BookRequest, Long> {
    boolean existsByTitle(String title);
}
