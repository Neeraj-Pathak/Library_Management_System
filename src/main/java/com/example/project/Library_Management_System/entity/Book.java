package com.example.project.Library_Management_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private boolean available = true;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User borrowedBy;

    public Book(String title, String author, String publisher, boolean available) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.available = available;
    }
}

