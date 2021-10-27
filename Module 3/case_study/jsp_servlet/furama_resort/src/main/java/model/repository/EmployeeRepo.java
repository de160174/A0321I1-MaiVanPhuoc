package model.repository;


import java.util.List;

public interface EmployeeRepo {
    List<model.bean.Employee> findAll();

    model.bean.Employee findById(String id);

    void create(model.bean.Employee employee);

    void update(model.bean.Employee employee);

    void delete(String id);

    List<model.bean.Employee> search(String name);
}
