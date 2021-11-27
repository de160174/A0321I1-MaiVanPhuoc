package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
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

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepo.findAllByFirstNameContaining(firstname, pageable);
    }
}
