package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import com.example.demo.validator.SongValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("")
    public String getIndex(Model model){
        model.addAttribute("song",songService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("song",new Song());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Song song, BindingResult bindingResult){
        new SongValidator().validate(song,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        songService.save(song);
        return "redirect:";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String save(@Validated @ModelAttribute Song song,BindingResult bindingResult){
        new SongValidator().validate(song,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        songService.save(song);
        return "redirect:";
    }
}
