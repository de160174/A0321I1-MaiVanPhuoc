package service;

import model.Product;
import repository.ProductRepo;
import repository.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo=new ProductRepoImpl();
    @Override
    public List<Product> findAll() {
        List<Product> products=this.productRepo.findAll();
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Product product=this.productRepo.findById(id);
        return product;
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepo.remove(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepo.update(id,product);
    }

}
