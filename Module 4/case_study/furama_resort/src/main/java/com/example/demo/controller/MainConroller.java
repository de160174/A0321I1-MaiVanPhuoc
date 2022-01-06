package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainConroller {
    @GetMapping("")
    public String index(){
        return "index";
    }
}
