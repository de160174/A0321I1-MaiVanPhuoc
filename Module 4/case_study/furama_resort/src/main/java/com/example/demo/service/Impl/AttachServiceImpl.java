package com.example.demo.service.Impl;

import com.example.demo.repository.AttachServiceRepository;
import com.example.demo.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceImpl implements AttachService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<com.example.demo.model.AttachService> findAll() {
        return (List<com.example.demo.model.AttachService>) attachServiceRepository.findAll();
    }
}
