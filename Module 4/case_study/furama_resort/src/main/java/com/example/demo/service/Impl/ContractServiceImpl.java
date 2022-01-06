package com.example.demo.service.Impl;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
    @Override
    public Page<Contract> findCustomerUsingService(Pageable pageable, String name) {
        return contractRepository.findCustomerUsingService(pageable, name);
    }
}
