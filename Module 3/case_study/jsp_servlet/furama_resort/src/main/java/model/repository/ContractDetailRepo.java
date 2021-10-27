package model.repository;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailRepo {
    List<ContractDetail> findAll();

    void create(ContractDetail contractDetail);
}
