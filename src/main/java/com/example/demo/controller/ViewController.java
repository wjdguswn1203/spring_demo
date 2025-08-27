package com.example.demo.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/post")
    public String post() {
        return "post-list";
    }

    @GetMapping("/post_detail")
    public String post_detail() {
        return "post-detail";
    }

    @GetMapping("/fortune/today")
    public String  today() {
        return "fortune";
    }
}
