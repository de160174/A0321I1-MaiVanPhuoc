package model.repository.Impl;

import model.bean.Customer;
import model.repository.CustomerRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from customer";
    private static final String SELECT_ID="select * from customer where customer_id=?";
    private static final String CREATE_QUERY="insert into customer values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY="update customer set  customer_id=?,customer_type_id=?, " +
            "customer_name =?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?, customer_email=?, " +
            "customer_address=? where customer_id=?";
    private static final String DELETE_QUERY="delete from customer where customer_id=?";
    private static final String SEARCH_QUERY="select * from customer where customer_name like ?";
    @Override
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer=new Customer();
                customer.setCustomer_id(resultSet.getString("customer_id"));
                customer.setCustomer_type_id(resultSet.getString("customer_type_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getBoolean("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(String id) {
        Customer customer=null;
        try {
            PreparedStatement statement=this.baseRepo.getConnection().prepareStatement(SELECT_ID);
            statement.setString(1,id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                customer=new Customer();
                customer.setCustomer_id(resultSet.getString("customer_id"));
                customer.setCustomer_type_id(resultSet.getString("customer_name"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getBoolean("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(Customer customer) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(CREATE_QUERY);
            statement.setString(1,customer.getCustomer_id());
            statement.setString(2,customer.getCustomer_type_id());
            statement.setString(3,customer.getCustomer_name());
            statement.setString(4,customer.getCustomer_birthday());
            statement.setBoolean(5,customer.getCustomer_gender());
            statement.setString(6,customer.getCustomer_id_card());
            statement.setString(7,customer.getCustomer_phone());
            statement.setString(8,customer.getCustomer_email());
            statement.setString(9,customer.getCustomer_address());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(UPDATE_QUERY);
            statement.setString(1,customer.getCustomer_id());
            statement.setString(2,customer.getCustomer_type_id());
            statement.setString(3,customer.getCustomer_name());
            statement.setString(4,customer.getCustomer_birthday());
            statement.setBoolean(5,customer.getCustomer_gender());
            statement.setString(6,customer.getCustomer_id_card());
            statement.setString(7,customer.getCustomer_phone());
            statement.setString(8,customer.getCustomer_email());
            statement.setString(9,customer.getCustomer_address());
            statement.setString(10,customer.getCustomer_id());
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
    public List<Customer> search(String name) {
        List<Customer> customers=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SEARCH_QUERY);
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet= statement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer=new Customer();
                customer.setCustomer_id(resultSet.getString("customer_id"));
                customer.setCustomer_type_id(resultSet.getString("customer_type_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getBoolean("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }
}
