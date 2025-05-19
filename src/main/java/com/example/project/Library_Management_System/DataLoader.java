package com.example.project.Library_Management_System;

import com.example.project.Library_Management_System.entity.Book;
import com.example.project.Library_Management_System.repository.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepo bookRepository;

    public DataLoader(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() == 0) {
            bookRepository.save(new Book("The Alchemist", "Paulo Coelho", "HarperOne", true));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin", "Prentice Hall", true));
            bookRepository.save(new Book("Effective Java", "Joshua Bloch", "Addison-Wesley", true));
            bookRepository.save(new Book("Spring in Action", "Craig Walls", "Manning", true));
            System.out.println("Default books loaded.");
        }
    }
}
