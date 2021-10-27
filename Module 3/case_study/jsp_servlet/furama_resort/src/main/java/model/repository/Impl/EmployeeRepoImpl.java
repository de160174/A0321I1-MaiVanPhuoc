package model.repository.Impl;


import model.bean.Employee;
import model.repository.EmployeeRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from employee";
    private static final String SELECT_ID="select * from employee where employee_id=?";
    private static final String CREATE_QUERY="insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY="update employee set  employee_id=?, employee_name=?,employee_birthday=?,employee_id_card=?," +
            "employee_salary=?, employee_phone=?, employee_email=?, employee_address=?, position_id=?, education_degree_id=?," +
            " division_id=?, username=?" + " where employee_id=?";
    private static final String DELETE_QUERY="delete from employee where employee_id=?";
    private static final String SEARCH_QUERY="select * from employee where employee_name like ?";
    @Override
    public List<model.bean.Employee> findAll() {
        List<Employee> employees=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            Employee employee;
            while (resultSet.next()){
                employee=new Employee();
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(resultSet.getString("position_id"));
                employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
                employee.setDivision_id(resultSet.getString("division_id"));
                employee.setUsername(resultSet.getString("username"));
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public model.bean.Employee findById(String id) {
        Employee employee=null;
        try {
            PreparedStatement statement=this.baseRepo.getConnection().prepareStatement(SELECT_ID);
            statement.setString(1,id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                employee=new Employee();
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(resultSet.getString("position_id"));
                employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
                employee.setDivision_id(resultSet.getString("division_id"));
                employee.setUsername(resultSet.getString("username"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void create(model.bean.Employee employee) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(CREATE_QUERY);
            statement.setString(1,employee.getEmployee_id());
            statement.setString(2,employee.getEmployee_name());
            statement.setString(3,employee.getEmployee_birthday());
            statement.setString(4,employee.getEmployee_id_card());
            statement.setDouble(5,employee.getEmployee_salary());
            statement.setString(6,employee.getEmployee_phone());
            statement.setString(7,employee.getEmployee_email());
            statement.setString(8,employee.getEmployee_address());
            statement.setString(9,employee.getPosition_id());
            statement.setString(10,employee.getEducation_degree_id());
            statement.setString(11,employee.getDivision_id());
            statement.setString(12,employee.getUsername());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(model.bean.Employee employee) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(UPDATE_QUERY);
            statement.setString(1,employee.getEmployee_id());
            statement.setString(2,employee.getEmployee_name());
            statement.setString(3,employee.getEmployee_birthday());
            statement.setString(4,employee.getEmployee_id_card());
            statement.setDouble(5,employee.getEmployee_salary());
            statement.setString(6,employee.getEmployee_phone());
            statement.setString(7,employee.getEmployee_email());
            statement.setString(8,employee.getEmployee_address());
            statement.setString(9,employee.getPosition_id());
            statement.setString(10,employee.getEducation_degree_id());
            statement.setString(11,employee.getDivision_id());
            statement.setString(12,employee.getUsername());
            statement.setString(13,employee.getEmployee_id());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(DELETE_QUERY);
            statement.setString(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<model.bean.Employee> search(String name) {
        List<Employee> employees=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SEARCH_QUERY);
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet= statement.executeQuery();
            Employee employee;
            while (resultSet.next()){
                employee=new Employee();
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(resultSet.getString("position_id"));
                employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
                employee.setDivision_id(resultSet.getString("division_id"));
                employee.setUsername(resultSet.getString("username"));
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }
}
