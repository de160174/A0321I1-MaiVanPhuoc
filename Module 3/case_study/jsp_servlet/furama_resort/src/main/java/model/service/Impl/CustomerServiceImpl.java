package model.service.Impl;

import model.bean.Customer;
import model.repository.CustomerRepo;
import model.repository.Impl.CustomerRepoImpl;
import model.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo=new CustomerRepoImpl();
    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public Customer findById(String id) {
        return this.customerRepo.findById(id);
    }

    @Override
    public void create(Customer customer) {
        this.customerRepo.create(customer);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepo.update(customer);
    }

    @Override
    public void delete(String id) {
        this.customerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return this.customerRepo.search(name);
    }
}
