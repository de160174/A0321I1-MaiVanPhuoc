package model.service.Impl;

import model.bean.Employee;
import model.repository.EmployeeRepo;
import model.repository.Impl.EmployeeRepoImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo=new EmployeeRepoImpl();
    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee findById(String id) {
        return this.employeeRepo.findById(id);
    }

    @Override
    public void create(Employee employee) {
        this.employeeRepo.create(employee);
    }

    @Override
    public void update(Employee employee) {
        this.employeeRepo.update(employee);
    }

    @Override
    public void delete(String id) {
        this.employeeRepo.delete(id);
    }

    @Override
    public List<Employee> search(String name) {
        return this.employeeRepo.search(name);
    }
}
