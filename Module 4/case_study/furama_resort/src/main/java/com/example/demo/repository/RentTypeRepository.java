package com.example.demo.repository;

import com.example.demo.model.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends PagingAndSortingRepository<RentType,Integer> {
}
