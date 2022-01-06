package com.example.demo.service.Impl;

import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.example.demo.service.Service {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<com.example.demo.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<com.example.demo.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(com.example.demo.model.Service service) {
        serviceRepository.save(service);
    }
}
