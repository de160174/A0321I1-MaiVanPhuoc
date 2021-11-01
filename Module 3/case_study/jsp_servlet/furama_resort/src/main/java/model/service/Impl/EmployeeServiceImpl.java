package model.service.Impl;

import model.bean.Employee;
import model.repository.EmployeeRepo;
import model.repository.Impl.EmployeeRepoImpl;
import model.service.EmployeeService;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,String> create(Employee employee) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateIDCard(employee.getEmployee_id_card())!=null
                ||Validate.validateSalary(employee.getEmployee_salary())!=null
                ||Validate.validatePhone(employee.getEmployee_phone())!=null
                ||Validate.validateEmail(employee.getEmployee_email())!=null){
            stringMap.put("employee_id_card",Validate.validateIDCard(employee.getEmployee_id_card()));
            stringMap.put("employee_salary",Validate.validateSalary(employee.getEmployee_salary()));
            stringMap.put("employee_phone",Validate.validatePhone(employee.getEmployee_phone()));
            stringMap.put("employee_email",Validate.validateEmail(employee.getEmployee_email()));
        }else {
            this.employeeRepo.create(employee);
        }
        return stringMap;
    }

    @Override
    public Map<String,String> update(Employee employee) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateIDCard(employee.getEmployee_id_card())!=null
                ||Validate.validateSalary(employee.getEmployee_salary())!=null
                ||Validate.validatePhone(employee.getEmployee_phone())!=null
                ||Validate.validateEmail(employee.getEmployee_email())!=null){
            stringMap.put("employee_id_card",Validate.validateIDCard(employee.getEmployee_id_card()));
            stringMap.put("employee_salary",Validate.validateSalary(employee.getEmployee_salary()));
            stringMap.put("employee_phone",Validate.validatePhone(employee.getEmployee_phone()));
            stringMap.put("employee_email",Validate.validateEmail(employee.getEmployee_email()));
        }else {
            this.employeeRepo.update(employee);
        }
        return stringMap;

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
