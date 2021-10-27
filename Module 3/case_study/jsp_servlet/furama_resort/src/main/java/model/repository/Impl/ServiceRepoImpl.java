package model.repository.Impl;

import model.bean.Customer;
import model.bean.Service;
import model.repository.ServiceRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepoImpl implements ServiceRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from service";
    private static final String CREATE_QUERY="insert into service values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public List<Service> findAll() {
        List<Service> services=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            Service service;
            while (resultSet.next()){
                service=new Service();
                service.setService_id(resultSet.getString("service_id"));
                service.setService_name(resultSet.getString("service_name"));
                service.setService_area(resultSet.getInt("service_area"));
                service.setService_cost(resultSet.getDouble("service_cost"));
                service.setService_max_people(resultSet.getInt("service_max_people"));
                service.setStandard_room(resultSet.getString("standard_room"));
                service.setDescription(resultSet.getString("description"));
                service.setPool_area(resultSet.getDouble("pool_area"));
                service.setNumber_of_floor(resultSet.getInt("number_of_floor"));
                service.setRent_type_id(resultSet.getString("rent_type_id"));
                service.setService_type_id(resultSet.getString("service_type_id"));
                services.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }

    @Override
    public void create(Service service) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(CREATE_QUERY);
            statement.setString(1,service.getService_id());
            statement.setString(2,service.getService_name());
            statement.setInt(3,service.getService_area());
            statement.setDouble(4,service.getService_cost());
            statement.setInt(5,service.getService_max_people());
            statement.setString(6,service.getRent_type_id());
            statement.setString(7,service.getService_type_id());
            statement.setString(8,service.getStandard_room());
            statement.setString(9,service.getDescription());
            statement.setDouble(10,service.getPool_area());
            statement.setInt(11,service.getNumber_of_floor());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
