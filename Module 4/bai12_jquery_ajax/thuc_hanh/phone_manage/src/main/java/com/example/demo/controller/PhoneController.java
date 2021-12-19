package com.example.demo.controller;

import com.example.demo.model.Phone;
import com.example.demo.service.PhoneService;
import com.sun.org.apache.xpath.internal.operations.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Phone> getIndex(){
        return phoneService.findAll();
    }
    @GetMapping("")
    public String allPhone(Model model){
        model.addAttribute("phones",getIndex());
        return "all-phone";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("phone",new Phone());
        return "new-phone";
    }

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone create(@RequestBody Phone phone){
        return phoneService.save(phone);
    }
    @PostMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone deleteSmartphone(@PathVariable Integer id){
        return phoneService.remove(id);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("edit-phone");
        Phone phone = phoneService.findById(id);
        mav.addObject("sPhone", phone);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone editSmartphone(@PathVariable int id, @RequestBody Phone phone) {
        phone.setId(id);
        return phoneService.save(phone);
    }
}
