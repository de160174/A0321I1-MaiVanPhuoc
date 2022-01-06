package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Page<Customer> findName(Pageable pageable, String name);

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);


}
