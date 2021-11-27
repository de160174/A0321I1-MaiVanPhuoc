package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public String getList(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "category/list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Category category,Model model){
        categoryService.save(category);
        model.addAttribute("category",new Category());
        model.addAttribute("message","create new category successful!");
        return "category/create";
    }
    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Category category= categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category,Model model){
        categoryService.save(category);
        model.addAttribute("category",category);
        model.addAttribute("message","update category successful!");
        return "category/edit";
    }
    @GetMapping("showDelete/{id}")
    public String showDelete(@PathVariable int id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/delete";
    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Category category){
        categoryService.remove(category.getCategoryId());
        return "redirect:/";
    }

}
//Repository -> crud -> pagingAndSearching -> jpaRepository