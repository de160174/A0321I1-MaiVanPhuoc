package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList=categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Category>>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id){
        Category category=categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Category> update(@PathVariable int id,@RequestBody Category category){
        Category category1=categoryService.findById(id);
        if(category1==null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        category1.setCategoryName(category.getCategoryName());
        category1.setCategoryId(category.getCategoryId());
        categoryService.save(category1);
        return new ResponseEntity<Category>(category1,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        Category category=categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
