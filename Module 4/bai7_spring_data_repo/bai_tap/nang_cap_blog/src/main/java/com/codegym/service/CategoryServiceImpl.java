package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void remove(int id) {

        categoryRepo.deleteById(id);
    }
}
