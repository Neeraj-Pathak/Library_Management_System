package com.example.project.Library_Management_System.service;

import com.example.project.Library_Management_System.entity.BookRequest;
import com.example.project.Library_Management_System.repository.BookRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRequestService {

    @Autowired
    private BookRequestRepo bookRequestRepo;

    public boolean existsByTitle(String title) {
        return bookRequestRepo.existsByTitle(title);
    }

    public BookRequest saveRequest(BookRequest bookRequest) {
        return bookRequestRepo.save(bookRequest);
    }
}
