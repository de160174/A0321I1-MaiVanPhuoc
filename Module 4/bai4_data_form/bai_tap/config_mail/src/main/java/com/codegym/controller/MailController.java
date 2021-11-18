package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("email",new Email());
        return "index";
    }
    @PostMapping("/submit")
    public String submit(@ModelAttribute Email email,Model model){
        model.addAttribute("languages",email.getLanguages());
        model.addAttribute("pageSize",email.getPageSize());
        model.addAttribute("spamFilter",email.isSpamFilter());
        model.addAttribute("signature",email.getSignature());
        return "info";
    }
}
