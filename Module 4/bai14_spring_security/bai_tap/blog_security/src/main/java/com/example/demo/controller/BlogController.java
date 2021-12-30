package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String getList(@PageableDefault(value = 2) Pageable pageable,Model model){
        model.addAttribute("blogs",blogService.findAll(pageable));
        return "index";
    }
    @GetMapping("/detail/{id}")
    public String getBlog(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name,@PageableDefault(value = 2) Pageable pageable,Model model){
        model.addAttribute("blogs", blogService.findName(pageable, name));
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","them blog thanh cong");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(Model model,@PathVariable Integer id){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categories",categoryService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","sua blog thanh cong");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message","xoa thanh cong");
        return "redirect:/";
    }
}
