package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> allProvince(){
        return provinceService.findAll();
    }
    @GetMapping
    public String showList(Model model, Optional<String> s, Pageable pageable){
        Page<Customer> customers=s.isPresent() ? search(s,pageable) : getPage(pageable);
        model.addAttribute("keyword",s.orElse(null));
        model.addAttribute("customers",customers);
        return "list";
    }
    @GetMapping("{id}")
    public String showInformation(@PathVariable Long id, Model model) {
        try{
            Customer customer=null;
            customer = customerService.findOne(id);
            model.addAttribute("customer", customer);
            return "info";
        }catch (Exception e){
            return ("redirect:/customers");
        }
    }

    @PostMapping
    public String updateCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
    private Page<Customer> getPage(Pageable pageInfo) {
        return customerService.findAll(pageInfo);
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
}
