package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationDegreeService degreeService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;
    @GetMapping("")
    private String getIndex(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("employees",employeeService.findAll(pageable));
        return "employee/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, @PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("employees", employeeService.findName(pageable, name));
        return "employee/list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("degree",degreeService.findAll());
        model.addAttribute("user",userService.findAll());
        return "employee/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","thêm mới nhân viên thành công");
        return "redirect:/employee/";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(Model model,@PathVariable Integer id){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("degree",degreeService.findAll());
        model.addAttribute("user",userService.findAll());
        return "employee/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","sửa nhân viên thành công");
        return "redirect:/employee/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/employee/";
    }
}
