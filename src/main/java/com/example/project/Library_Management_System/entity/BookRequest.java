package com.example.project.Library_Management_System.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime requestedAt;

    // Constructors
    public BookRequest() {}

    public BookRequest(String title) {
        this.title = title;
        this.requestedAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getRequestedAt() { return requestedAt; }
    public void setRequestedAt(LocalDateTime requestedAt) { this.requestedAt = requestedAt; }
}
