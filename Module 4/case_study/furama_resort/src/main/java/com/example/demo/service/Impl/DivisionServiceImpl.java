package com.example.demo.service.Impl;

import com.example.demo.model.Division;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return (List<Division>) divisionRepository.findAll();
    }
}
