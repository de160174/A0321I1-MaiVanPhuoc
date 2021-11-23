package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void add(Blog blog);

    void update(Blog blog);

    void remove(int id);
}
