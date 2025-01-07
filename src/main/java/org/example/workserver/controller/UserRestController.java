package org.example.workserver.controller;

import lombok.AllArgsConstructor;
import org.example.workserver.entity.User;
import org.example.workserver.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserRestController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @PostMapping("/api/users/new")
    public User saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }
}
