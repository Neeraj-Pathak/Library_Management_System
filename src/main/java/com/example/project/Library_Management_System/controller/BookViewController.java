package com.example.project.Library_Management_System.controller;

import com.example.project.Library_Management_System.entity.Book;
import com.example.project.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookViewController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String booksPage(@RequestParam Long userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("newBook", new Book());
        return "books";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam Long userId, @ModelAttribute("newBook") Book book, RedirectAttributes redirectAttributes) {
        bookService.saveBook(book);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/books";
    }

    @PostMapping("/{bookId}/delete")
    public String deleteBook(@RequestParam Long userId, @PathVariable Long bookId, RedirectAttributes redirectAttributes) {
        bookService.deleteBookById(bookId);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/books";
    }

    @PostMapping("/{bookId}/borrow")
    public String borrowBook(@RequestParam Long userId, @PathVariable Long bookId, RedirectAttributes redirectAttributes) {
        bookService.borrowBook(bookId, userId);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/books";
    }

    @PostMapping("/{bookId}/return")
    public String returnBook(@RequestParam Long userId, @PathVariable Long bookId, RedirectAttributes redirectAttributes) {
        bookService.returnBook(bookId);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/books";
    }
}
