package model.repository.Impl;

import model.bean.Customer;
import model.repository.CustomerUsingRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingRepoImpl implements CustomerUsingRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_CUSTOMER="select customer.customer_id,customer_name,customer_birthday,customer_gender,customer_phone,customer_email,customer_address,contract.contract_id,\n" +
            "contract_total_money,contract_detail.contract_detail_id,attach_service.attach_service_id,attach_service_name\n" +
            "from customer \n" +
            "inner join contract on customer.customer_id=contract.customer_id\n" +
            "inner join service on contract.service_id=service.service_id\n" +
            "inner join contract_detail on contract.contract_id=contract_detail.contract_id\n" +
            "inner join attach_service on contract_detail.attach_service_id=attach_service.attach_service_id\n" +
            "group by customer.customer_id;";
    @Override
    public List<Customer> findCustomer() {
        List<Customer> customers=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection().prepareStatement(SELECT_CUSTOMER);
            ResultSet resultSet=statement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer=new Customer();
                customer.setCustomer_id(resultSet.getString("customer_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getBoolean("customer_gender"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customer.setContract_id(resultSet.getString("contract_id"));
                customer.setContract_total_money(resultSet.getString("contract_total_money"));
                customer.setContract_detail_id(resultSet.getString("contract_detail_id"));
                customer.setAttach_service_id(resultSet.getString("attach_service_id"));
                customer.setAttach_service_name(resultSet.getString("attach_service_name"));
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }
}
