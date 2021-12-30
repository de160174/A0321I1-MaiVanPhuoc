package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/member")
    public String member() {
        return "member";
    }
    @GetMapping("/deny")
    public String deny() {
        return "403";
    }
}
