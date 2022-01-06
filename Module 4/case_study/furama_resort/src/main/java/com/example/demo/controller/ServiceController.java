package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.RentTypeService;
import com.example.demo.service.Service;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    Service service;
    @Autowired
    ServiceTypeService serviceTypeService;
    @GetMapping("")
    private String getIndex(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("services",service.findAll(pageable));
        return "service/list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("service",new com.example.demo.model.Service());
        model.addAttribute("serviceType",serviceTypeService.findAll());
        model.addAttribute("rentType",rentTypeService.findAll());
        return "service/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute com.example.demo.model.Service serviceObj,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("serviceType",serviceTypeService.findAll());
            model.addAttribute("rentType",rentTypeService.findAll());
            return "service/create";
        }
        service.save(serviceObj);
        redirectAttributes.addFlashAttribute("message", "thêm mới dịch vụ thành công");
        return "redirect:/service/";
    }
}
