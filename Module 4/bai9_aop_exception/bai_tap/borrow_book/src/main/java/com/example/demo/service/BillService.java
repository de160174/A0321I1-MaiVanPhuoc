package com.example.demo.service;

import com.example.demo.model.Bill;
import com.example.demo.model.Book;

import java.util.List;

public interface BillService {
    List<Bill> findAll();

    Bill findById(int id);

    void save(Bill bill);

    void delete(Bill bill);
}
