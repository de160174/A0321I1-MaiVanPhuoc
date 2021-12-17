package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class ProductController {
    @Autowired
    private ProductService productService;
//    Truy cập vào session tên carts vè đưa lên session carts 1 đối tượng hashMap.
//    @ModelAttribute("carts")
//    public HashMap<Long, Cart> cartHashMap(){
//        System.out.println("Đưa Map lên session!");
//        HashMap<Long, Cart> hashMap = new HashMap<>();
//        hashMap.put((long) 1, new Cart());
//        return hashMap;
//    }
    @ModelAttribute("carts")
    public HashMap<String, Cart> cartHashMap(){
        return new HashMap<>();
    }
    @GetMapping("")
    public String getIndex(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/index";
    }
    @GetMapping("/create")
    public String showCreate(@ModelAttribute("carts") HashMap<String, Cart> hashMap,Model model){
        //truy cập vào session tên cart và lấy giá trị từ session xuống
        model.addAttribute("product",new Product());
        return "product/create";
    }
    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("message", "New product created successfully");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        Product product = productService.findById(id);
//        model.addAttribute("carts", cartHashMap);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteProduct(@PathVariable String id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product) {
        productService.delete(product.getProductId());
        return "redirect:/";
    }
    @GetMapping("/delete-cart")
    public String deleteCart(@SessionAttribute("carts") HashMap<String,Cart> hashMap) {
        hashMap.clear();
        return "redirect:/";
    }
}
