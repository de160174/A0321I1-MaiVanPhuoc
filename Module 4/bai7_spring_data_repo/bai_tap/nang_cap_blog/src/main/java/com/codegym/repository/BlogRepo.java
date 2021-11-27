package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepo extends PagingAndSortingRepository<Blog,Integer> {
    List<Blog> findByBlogNameContains(String name);
}
