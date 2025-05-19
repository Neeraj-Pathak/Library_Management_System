package com.example.project.Library_Management_System.controller;

import com.example.project.Library_Management_System.entity.User;
import com.example.project.Library_Management_System.service.BookService;
import com.example.project.Library_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("newUser", new User());
        return "home";  // create user form view
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("newUser") User user, RedirectAttributes redirectAttributes) {
        if (userService.existsByUsername(user.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "Username already exists, try another.");
            return "redirect:/";
        }
        User savedUser = userService.save(user);
        redirectAttributes.addFlashAttribute("message", "User created successfully!");
        // redirect to books page with user id param
        return "redirect:/books?userId=" + savedUser.getId();
    }
}
