package model.service.Impl;

import model.bean.Contract;
import model.repository.ContractRepo;
import model.repository.Impl.ContractRepoImpl;
import model.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractRepo contractRepo=new ContractRepoImpl();
    @Override
    public List<Contract> findAll() {
        return this.contractRepo.findAll();
    }

    @Override
    public void create(Contract contract) {
        this.contractRepo.create(contract);
    }
}
