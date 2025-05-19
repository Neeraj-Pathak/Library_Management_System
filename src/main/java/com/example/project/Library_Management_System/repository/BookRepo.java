package com.example.project.Library_Management_System.repository;

import com.example.project.Library_Management_System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);

    Optional<Book> findByTitleAndAuthor(String title, String author);
    List<Book> findByBorrowedById(Long userId);
}
