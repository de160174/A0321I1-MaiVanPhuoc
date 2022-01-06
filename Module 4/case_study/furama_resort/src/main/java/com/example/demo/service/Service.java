package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service {
    Page<com.example.demo.model.Service> findAll(Pageable pageable);

    List<com.example.demo.model.Service> findAll();

    void save(com.example.demo.model.Service service);
}
