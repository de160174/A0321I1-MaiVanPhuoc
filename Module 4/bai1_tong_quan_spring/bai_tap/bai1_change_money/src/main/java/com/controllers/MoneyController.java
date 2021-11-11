package com.controllers;

import com.service.ChangeMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    ChangeMoney changeMoney;
    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    @GetMapping("/change")
    public String change(@RequestParam String usd, Model model){
        Double vnd=changeMoney.change(Double.parseDouble(usd));
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "index";
    }
}
