package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepo blogRepo;


    @Override
    public Page<Blog> findPaging(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        Iterable<Blog> iterable = blogRepo.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog b: iterable) {
            blogList.add(b);
        }
        return blogList;
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
