package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);

    void update(Integer id,Product product);


}
