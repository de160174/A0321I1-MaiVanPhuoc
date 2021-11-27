package com.codegym.repository;

import com.codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepo extends PagingAndSortingRepository<Province,Long> {
}
