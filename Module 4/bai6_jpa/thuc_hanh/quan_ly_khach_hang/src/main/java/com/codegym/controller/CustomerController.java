package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getIndex(){
        List<Customer> customerList=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }
    @GetMapping("/showCreate")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView=new ModelAndView("redirect:/");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","New customer created successfully");
        return modelAndView;
    }
    @GetMapping("showEdit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Customer customer=customerService.findById(id);
        if (customer!=null){
            ModelAndView modelAndView=new ModelAndView("edit");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("edit")
    public ModelAndView update(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("showDelete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/";
    }
}
