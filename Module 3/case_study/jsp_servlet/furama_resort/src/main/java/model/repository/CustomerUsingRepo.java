package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerUsingRepo {
    List<Customer> findCustomer();
}
