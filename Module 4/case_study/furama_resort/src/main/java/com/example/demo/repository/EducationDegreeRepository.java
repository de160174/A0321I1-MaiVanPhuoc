package com.example.demo.repository;

import com.example.demo.model.EducationDegree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends CrudRepository<EducationDegree,Integer> {
}
