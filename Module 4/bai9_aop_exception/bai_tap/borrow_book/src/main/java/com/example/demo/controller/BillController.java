package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.Book;
import com.example.demo.service.BillService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bill")
public class BillController {
    @Autowired
    BookService bookService;
    @Autowired
    private BillService billService;
    @GetMapping("")
    public String getBill(Model model){
        model.addAttribute("bill",billService.findAll());
        return "bill/index";
    }
    @GetMapping("/show/{id}")
    public String showDetail(@PathVariable int id,Model model){
        Bill bill= billService.findById(id);
        model.addAttribute("bill",bill);
        return "bill/detail";
    }
    @PostMapping("/return")
    public String getReturn(@RequestParam int idBook,@ModelAttribute Bill bill){
        bookService.returnBook(idBook);
        Book book=bookService.findById(idBook);
        bill.setStatus(true);
        bill.setBook(book);
        billService.save(bill);
        return "redirect:/bill";
    }
}
