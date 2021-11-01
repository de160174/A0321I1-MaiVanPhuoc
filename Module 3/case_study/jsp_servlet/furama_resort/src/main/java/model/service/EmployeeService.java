package model.service;

import model.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(String id);

    Map<String,String> create(Employee employee);

    Map<String,String> update(Employee employee);

    void delete(String id);

    List<Employee> search(String name);
}
