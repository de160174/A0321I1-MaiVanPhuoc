package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();

    Page<Employee> findName(Pageable pageable, String name);

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);
}
