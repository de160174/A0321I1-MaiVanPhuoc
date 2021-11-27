package com.codegym.service;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceRepo provinceRepo;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepo.findOne(id);
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepo.delete(id);
    }
}
