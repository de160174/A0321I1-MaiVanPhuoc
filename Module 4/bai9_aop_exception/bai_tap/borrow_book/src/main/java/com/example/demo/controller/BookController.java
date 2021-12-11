package com.example.demo.controller;

import com.example.demo.exception.BookException;
import com.example.demo.model.Bill;
import com.example.demo.model.Book;
import com.example.demo.service.BillService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BillService billService;

    @GetMapping("")
    public String getIndex(Model model){
        model.addAttribute("books",bookService.findAll());
        return "index";
    }
    @GetMapping("detail/{id}")
    public String getDetail(@PathVariable int id,Model model){
        model.addAttribute("book",bookService.detail(id));
        return "detail";
    }
    @GetMapping("borrow/{id}")
    public String getBorrow(@PathVariable int id) throws BookException {
        Book book=bookService.findById(id);
        if(book==null|book.getQuantity()==0){
            throw new BookException("số lượng sách đã hết");
        }else {
            Bill bill=new Bill();
            bill.setIdBill((int) (Math.random()*(99999 - 10000)+ 10000));
            bill.setBook(book);
            bookService.borrowBook(id);
            billService.save(bill);
            return "redirect:/";
        }
    }

    @GetMapping("/showDelete/{id}")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Book book){
        bookService.delete(book);
        return "redirect:/";
    }
}
