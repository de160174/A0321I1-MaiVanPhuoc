package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id);
    }

    @Override
    public void add(Blog blog) {
        blogRepo.add(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepo.update(blog);
    }

    @Override
    public void remove(int id) {
        blogRepo.remove(id);
    }
}
