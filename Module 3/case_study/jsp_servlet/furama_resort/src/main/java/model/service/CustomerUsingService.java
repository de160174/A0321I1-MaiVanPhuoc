package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerUsingService {
    List<Customer> selectCustomer();
}
