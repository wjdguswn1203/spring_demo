package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    // 요청
    public static class LoginRequest {
        @Email @NotBlank
        public String email;

        @NotBlank
        public String password;
    }

    // 응답
    public static class LoginResponse {
        public String email;
        public String name;

        public LoginResponse(User u) {
            this.email = u.getEmail();
            this.name = u.getName();
        }
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        User user = userService.login(req.email, req.password);

        return new LoginResponse(user);
    }

}
