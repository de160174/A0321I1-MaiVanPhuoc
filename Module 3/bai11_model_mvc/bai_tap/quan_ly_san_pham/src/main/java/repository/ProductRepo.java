package repository;

import model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);

    void update(Integer id, Product product);


}
