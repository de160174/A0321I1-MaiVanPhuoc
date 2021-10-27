package model.service;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(String id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(String id);

    List<Employee> search(String name);
}
