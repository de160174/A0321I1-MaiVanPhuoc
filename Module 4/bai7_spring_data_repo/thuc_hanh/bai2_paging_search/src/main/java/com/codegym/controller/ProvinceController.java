package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CustomerService customerService;
    @GetMapping("/province")
    public ModelAndView getIndex(){
        Iterable<Province> provinces=provinceService.findAll();
        ModelAndView modelAndView=new ModelAndView("province/list");
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }
    @GetMapping("/showCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }
    @GetMapping("/showEdit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("province/edit");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/showDelete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("province/delete");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        return "redirect:province";
    }
    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Province province = provinceService.findById(id);
        Iterable<Customer> customers = customerService.findAllByProvince(province);
        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
