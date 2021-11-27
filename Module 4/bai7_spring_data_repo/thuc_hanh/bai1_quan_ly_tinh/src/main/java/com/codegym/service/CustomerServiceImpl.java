package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.delete(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepo.findAllByProvince(province);
    }
}
