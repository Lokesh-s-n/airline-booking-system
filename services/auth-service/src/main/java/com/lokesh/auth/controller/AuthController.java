package com.lokesh.auth.controller;

import com.lokesh.auth.model.User;
import com.lokesh.auth.repository.UserRepository;
import com.lokesh.auth.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository repository;

    public AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repository.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return JwtUtil.generateToken(user.getUsername());
        }

        return "Invalid Credentials";
    }
}