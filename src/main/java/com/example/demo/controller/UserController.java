package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    // 요청 바디용 DTO
    public static class SignupRequest {
        @Email @NotBlank
        public String email;

        @NotBlank @Size(min=8, max=50)
        public String password;

        @NotBlank @Size(min=1, max = 50)
        public String name;
    }

    // 응답 DTO (비밀번호 해시 숨김)
    public static class SignupResponse {
        public Long id;
        public String email;
        public String name;

        public SignupResponse(User u) {
            this.id = u.getId();
            this.email = u.getEmail();
            this.name = u.getName();
        }
    }

    @PostMapping("/signup")
    public SignupResponse signup(@Valid @RequestBody SignupRequest req) {
        User saved = userService.register(req.email, req.name, req.password);
        return new SignupResponse(saved);
    }
}
