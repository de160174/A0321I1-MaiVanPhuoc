package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showList() {
        return "index";
    }
    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping
    public String updateCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }
}
