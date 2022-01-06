package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.model.ContractDetail;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Service service;
    @Autowired
    private AttachService attachService;
    @Autowired
    private ContractDetailService contractDetailService;
    @GetMapping("")
    private String getIndex( Model model){
        model.addAttribute("contracts",contractService.findAll());
        return "contract/list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("employee",employeeService.findAll());
        model.addAttribute("customer",customerService.findAll());
        model.addAttribute("service",service.findAll());
        return "contract/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Contract contract, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("employee",employeeService.findAll());
            model.addAttribute("customer",customerService.findAll());
            model.addAttribute("service",service.findAll());
            return "contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "thêm mới hợp đồng thành công");
        return "redirect:/contract/";
    }
    @GetMapping("/showCreateDetail")
    public String showCreateDetail(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contract",contractService.findAll());
        model.addAttribute("attach",attachService.findAll());
        return "contract/create_detail";
    }
    @PostMapping("/createDetail")
    public String createDetail(@Validated @ModelAttribute ContractDetail contractDetail,BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contract",contractService.findAll());
            model.addAttribute("attach",attachService.findAll());
            return "contract/create_detail";
        }
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "thêm hợp đồng chi tiết thành công");
        return "redirect:/contract/";
    }
    @GetMapping("/listCustomerUsingService")
    private String getList(@RequestParam String name, @PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("customerUsing",contractService.findCustomerUsingService(pageable, name));
        return "contract/list_customer_using_service";
    }
}
