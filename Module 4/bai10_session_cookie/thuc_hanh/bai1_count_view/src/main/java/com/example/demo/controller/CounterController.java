package com.example.demo.controller;

import com.example.demo.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class CounterController {
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }
    @GetMapping("")
    public String getIndex(@ModelAttribute("mycounter") MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}
