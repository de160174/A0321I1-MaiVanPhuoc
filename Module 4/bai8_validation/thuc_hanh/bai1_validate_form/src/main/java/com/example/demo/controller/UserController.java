package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/validate")
    public String checkValidate(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        return "result";
    }
}
