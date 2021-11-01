package model.service;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(String id);

    Map<String,String> create(Customer customer);

    Map<String,String> update(Customer customer);

    void delete(String id);

    List<Customer> search(String name);
}
