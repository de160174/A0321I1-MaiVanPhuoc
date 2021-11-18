package com.codegym.controller;

import com.codegym.Model.Product;
import com.codegym.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductManager {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("productList",productService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product){
        productService.create(product);
         return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
}
