package com.codegym.Service;

import com.codegym.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "iPhone 13 Pro max", "iPhone", 30000));
        productMap.put(2, new Product(2, "Asus VivoBook", "Asus", 20000));
        productMap.put(3, new Product(3, "AirBlade", "Honda", 58000));
        productMap.put(4, new Product(4, "TV LG 4K", "LG", 10000));
        productMap.put(5, new Product(5, "Samsung zFold 3", "Samsung", 23000));
        productMap.put(6, new Product(6, "Vinfast e34", "Vinfast", 700000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }
}
