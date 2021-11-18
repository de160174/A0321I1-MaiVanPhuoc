package com.codegym.controller;

import com.codegym.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping("")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam int num1,@RequestParam int num2,@RequestParam String operation, Model model){
        model.addAttribute("calculate",calculateService.save(num1,num2,operation));
        return "index";
    }
}
