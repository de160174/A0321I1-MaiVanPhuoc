package com.example.demo.service;

import com.example.demo.model.Phone;
import com.example.demo.repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneRepo phoneRepo;
    @Override
    public Iterable<Phone> findAll() {
        return phoneRepo.findAll();
    }

    @Override
    public Phone findById(Integer id) {
        return phoneRepo.findById(id).orElse(null);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepo.save(phone);
    }

    @Override
    public Phone remove(Integer id) {
        Phone phone=phoneRepo.getById(id);
        phoneRepo.deleteById(id);
        return phone;
    }
}
