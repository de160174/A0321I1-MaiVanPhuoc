package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping("")
    private String getIndex(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("customers",customerService.findAll(pageable));
        return "customer/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, @PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("customers", customerService.findName(pageable, name));
        return "customer/list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerType",customerTypeService.findAll());
        return "customer/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","thêm mới khách hàng thành công");
        return "redirect:/customer/";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(Model model,@PathVariable Integer id){
        model.addAttribute("customer",customerService.findById(id));
        model.addAttribute("customerType",customerTypeService.findAll());
        return "customer/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","sửa khách hàng thành công");
        return "redirect:/customer/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");
        return "redirect:/customer/";
    }
}
