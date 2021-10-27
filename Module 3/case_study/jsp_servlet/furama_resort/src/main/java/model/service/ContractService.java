package model.service;

import model.bean.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void create(Contract contract);
}
