package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(String id);

    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    List<Customer> search(String name);
}
