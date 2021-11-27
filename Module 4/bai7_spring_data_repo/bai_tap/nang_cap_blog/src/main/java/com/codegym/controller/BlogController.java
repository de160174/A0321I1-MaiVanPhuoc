package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping("/")
    public ModelAndView getIndex(@RequestParam(name = "nameSearch",required = false) String name){
        ModelAndView modelAndView=new ModelAndView("blog/index");
        if (name!=null && !name.isEmpty()){
            modelAndView.addObject("blogList",blogService.findByName(name));
        }else {
            modelAndView.addObject("blogList",blogService.findAll());
        }
        return modelAndView;
    }
    @GetMapping("/paging")
    public ModelAndView getIndexPaging(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "size",required = false,defaultValue = "3") int size,
            @RequestParam(name = "sort",required = false,defaultValue = "ASC") String sort

    ){
        Sort orders=null;
        if (sort.equals("ASC")){
            orders=Sort.by("blogName").ascending();
        }else if(sort.equals("DESC")){
            orders=Sort.by("blogName").descending();
        }
        Pageable pageable= PageRequest.of(page, size,orders);
        Page<Blog> blogList=blogService.findPaging(pageable);
        ModelAndView modelAndView=new ModelAndView("blog/index");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
    @GetMapping("/showCreate")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView=new ModelAndView("blog/create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("message","create new blog successful!");
        return modelAndView;
    }
    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        Blog blog= blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("blog/edit");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView=new ModelAndView("blog/edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","update blog successful!");
        return modelAndView;
    }
    @GetMapping("showDelete/{id}")
    public ModelAndView showDelete(@PathVariable int id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getBlogId());
        return "redirect:/";
    }
    @GetMapping("/showInfo/{id}")
    public ModelAndView showInfo(@PathVariable int id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/info");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
