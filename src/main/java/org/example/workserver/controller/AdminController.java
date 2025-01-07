package org.example.workserver.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.example.workserver.entity.Bid;
import org.example.workserver.repository.RegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class AdminController {
    private final RegistrationRepository registrationRepository;

    public AdminController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @GetMapping("/admin/users")
    public String viewAllUsers(Model model) {
        List<Bid> users = registrationRepository.findAll();
        model.addAttribute("users", users);
        return "/admin";  // Ссылается на admin.html
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Возвращает login.html
    }
}
