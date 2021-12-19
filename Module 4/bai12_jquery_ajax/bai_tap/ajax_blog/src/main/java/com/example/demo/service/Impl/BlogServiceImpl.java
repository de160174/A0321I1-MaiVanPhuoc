package com.example.demo.service.Impl;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepo;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public Page<Blog> findName(Pageable pageable, String name) {
        return blogRepo.findByBlogNameContains(pageable,name);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepo.findByBlogNameContains(name);
    }
}
