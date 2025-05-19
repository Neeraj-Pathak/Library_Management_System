package com.example.project.Library_Management_System.service;

import com.example.project.Library_Management_System.entity.Book;
import com.example.project.Library_Management_System.entity.User;
import com.example.project.Library_Management_System.repository.BookRepo;
import com.example.project.Library_Management_System.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    public  boolean existsByTitle(String title) {
        return bookRepo.existsByTitle(title);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Book saveBook(Book book) {
        Optional<Book> existingBook = bookRepo.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
        if (existingBook.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }
        return bookRepo.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Optional<Book> bookOpt = bookRepo.findById(bookId);
        Optional<User> userOpt = userRepo.findById(userId);
        if (bookOpt.isEmpty() || userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book or User not found");
        }
        Book book = bookOpt.get();
        if (!book.isAvailable()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book not available");
        }
        book.setAvailable(false);
        book.setBorrowedBy(userOpt.get());
        return bookRepo.save(book);
    }


    public Book returnBook(Long bookId) {
        Optional<Book> bookOpt = bookRepo.findById(bookId);
        if (bookOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        Book book = bookOpt.get();
        if (book.isAvailable()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already returned");
        }
        book.setAvailable(true);
        book.setBorrowedBy(null);
        return bookRepo.save(book);
    }


    public List<Book> getBooksBorrowedByUser(Long userId) {
        return bookRepo.findByBorrowedById(userId);
    }

}
