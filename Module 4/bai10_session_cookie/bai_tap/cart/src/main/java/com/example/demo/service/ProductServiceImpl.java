package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void create(Product cart) {
        productRepo.save(cart);
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }
}
