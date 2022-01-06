package com.example.demo.repository;

import com.example.demo.model.ContractDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends CrudRepository<ContractDetail,Integer> {
}
