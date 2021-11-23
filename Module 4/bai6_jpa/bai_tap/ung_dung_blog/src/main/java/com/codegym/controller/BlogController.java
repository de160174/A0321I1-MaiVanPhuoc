package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/")
    public ModelAndView getIndex(){
        List<Blog> blogList=blogService.findAll();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
    @GetMapping("/showCreate")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog){
        blogService.add(blog);
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("message","create new blog successful!");
        return modelAndView;
    }
    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        Blog blog= blogService.findById(id);
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog){
        blogService.update(blog);
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","update blog successful!");
        return modelAndView;
    }
    @GetMapping("showDelete/{id}")
    public ModelAndView showDelete(@PathVariable int id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
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
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
