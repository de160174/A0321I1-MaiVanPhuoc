package model.service.Impl;

import model.bean.Contract;
import model.repository.ContractRepo;
import model.repository.Impl.ContractRepoImpl;
import model.service.ContractService;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {
    private ContractRepo contractRepo=new ContractRepoImpl();
    @Override
    public List<Contract> findAll() {
        return this.contractRepo.findAll();
    }

    @Override
    public Map<String,String> create(Contract contract) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateDeposit(contract.getContract_deposit())!=null
                ||Validate.validateTotalMoney(contract.getContract_total_money())!=null){
            stringMap.put("contract_deposit",Validate.validateDeposit(contract.getContract_deposit()));
            stringMap.put("contract_total_money",Validate.validateTotalMoney(contract.getContract_total_money()));
        }else {
            this.contractRepo.create(contract);
        }
        return stringMap;

    }
}
