package com.example.demo.service;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Page<Contract> findCustomerUsingService(Pageable pageable, String name);
}
