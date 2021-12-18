package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired 
    private BlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList(){
        List<Blog> BlogList=blogService.findAll();
        if(BlogList.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(BlogList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id){
        Blog Blog=blogService.findById(id);
        if(Blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(Blog,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Blog Blog){
        blogService.save(Blog);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id,@RequestBody Blog blog){
        Blog blog1=blogService.findById(id);
        if(blog1==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blog1.setBlogName(blog.getBlogName());
        blog1.setAuthor(blog.getAuthor());
        blog1.setContent(blog.getContent());
        blog1.setCategory(blog.getCategory());
        blog1.setBlogId(blog.getBlogId());
        blogService.save(blog1);
        return new ResponseEntity<Blog>(blog1,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        Blog Blog=blogService.findById(id);
        if(Blog==null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
