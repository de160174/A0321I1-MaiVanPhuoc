package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/","/home"})
    public String index(){
        return "index";
    }

    @GetMapping("/deny")
    public String getException(){
        return "403";
    }
    @GetMapping("/login")
    public String doLogin(){
        return "login";
    }

}
