package model.repository.Impl;

import model.bean.Contract;
import model.repository.ContractRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepoImpl implements ContractRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from contract";
    private static final String CREATE_QUERY="insert into contract values (?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public List<Contract> findAll() {
        List<Contract> contracts=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            Contract contract;
            while (resultSet.next()){
                contract=new Contract();
                contract.setContract_id(resultSet.getString("contract_id"));
                contract.setContract_start_date(resultSet.getString("contract_start_date"));
                contract.setContract_end_date(resultSet.getString("contract_end_date"));
                contract.setContract_deposit(resultSet.getDouble("contract_deposit"));
                contract.setContract_total_money(resultSet.getDouble("contract_total_money"));
                contract.setEmployee_id(resultSet.getString("employee_id"));
                contract.setCustomer_id(resultSet.getString("customer_id"));
                contract.setService_id(resultSet.getString("service_id"));
                contracts.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contracts;
    }

    @Override
    public Contract findById(String id) {
        return null;
    }

    @Override
    public void create(Contract contract) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(CREATE_QUERY);
            statement.setString(1,contract.getContract_id());
            statement.setString(2,contract.getContract_start_date());
            statement.setString(3,contract.getContract_end_date());
            statement.setDouble(4,contract.getContract_deposit());
            statement.setDouble(5,contract.getContract_total_money());
            statement.setString(6,contract.getEmployee_id());
            statement.setString(7,contract.getCustomer_id());
            statement.setString(8,contract.getService_id());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Contract> search(String name) {
        return null;
    }
}
