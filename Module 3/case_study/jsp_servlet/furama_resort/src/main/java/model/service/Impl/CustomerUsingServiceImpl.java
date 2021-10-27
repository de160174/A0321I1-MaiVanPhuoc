package model.service.Impl;

import model.bean.Customer;
import model.repository.CustomerUsingRepo;
import model.repository.Impl.CustomerUsingRepoImpl;
import model.service.CustomerUsingService;

import java.util.List;

public class CustomerUsingServiceImpl implements CustomerUsingService {
    private CustomerUsingRepo customerUsingRepo=new CustomerUsingRepoImpl();
    @Override
    public List<Customer> selectCustomer() {
        return this.customerUsingRepo.findCustomer();
    }
}
