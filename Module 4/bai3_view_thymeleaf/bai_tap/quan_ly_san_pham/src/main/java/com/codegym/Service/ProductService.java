package com.codegym.Service;

import com.codegym.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void create(Product product);

    void delete(int id);

    void update(int id,Product product);

}
