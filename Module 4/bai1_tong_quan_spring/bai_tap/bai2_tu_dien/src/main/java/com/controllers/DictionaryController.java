package com.controllers;

import com.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String show(){
        return "index";
    }
    @GetMapping("/dictionary")
    public String Dictionary(@RequestParam String eng, Model model){
        String vie=dictionaryService.dict(eng.toLowerCase());
        model.addAttribute("eng",eng);
        model.addAttribute("vie",vie);
        return "index";
    }
}
