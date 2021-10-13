package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepoImpl implements ProductRepo {
    static Map<Integer ,Product> productList=new HashMap();
    static {
        productList.put(1,(new Product(1,"BMW",15000,"no desc","german")));
        productList.put(2,new Product(2,"Mercedes",12000,"no desc","german"));
        productList.put(3,new Product(3,"Vinfast",16500,"no desc","vin"));
        productList.put(4,new Product(4,"Toyota",16000,"no desc","jap"));
        productList.put(5,new Product(5,"Ford",13400,"no desc","usa"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(Integer id) {
        return productList.get(id);
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void remove(Integer id) {
        productList.remove(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productList.put(id,product);
    }


}
