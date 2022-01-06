package com.example.demo.repository;

import com.example.demo.model.AttachService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends CrudRepository<AttachService,Integer> {
}
