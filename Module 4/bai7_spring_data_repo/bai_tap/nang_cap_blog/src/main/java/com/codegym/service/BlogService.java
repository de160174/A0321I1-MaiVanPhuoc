package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BlogService {
    Page<Blog> findPaging(Pageable pageable);

    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    List<Blog> findByName(String name);
}
