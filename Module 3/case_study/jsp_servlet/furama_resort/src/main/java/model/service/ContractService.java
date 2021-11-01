package model.service;

import model.bean.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    List<Contract> findAll();

    Map<String,String> create(Contract contract);
}
