package model.repository;

import model.bean.Contract;

import java.util.List;

public interface ContractRepo {
    List<Contract> findAll();

    Contract findById(String id);

    void create(Contract contract);

    void update(Contract contract);

    void delete(String id);

    List<Contract> search(String name);
}
