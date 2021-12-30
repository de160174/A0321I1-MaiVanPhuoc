package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findName(Pageable pageable,String name);

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    List<Blog> findByName(String name);
}
