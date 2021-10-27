package model.service.Impl;

import model.bean.ContractDetail;
import model.repository.ContractDetailRepo;
import model.repository.Impl.ContractDetailRepoImpl;
import model.service.ContractDetailService;

import java.util.List;

public class ContractDetaiServiceImpl implements ContractDetailService {
    private ContractDetailRepo contractDetailRepo=new ContractDetailRepoImpl();
    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepo.findAll();
    }

    @Override
    public void create(ContractDetail contractDetail) {
        this.contractDetailRepo.create(contractDetail);
    }
}
