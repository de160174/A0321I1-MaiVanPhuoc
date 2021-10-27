package model.repository.Impl;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.ContractDetailRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepoImpl implements ContractDetailRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from contract_detail";
    private static final String CREATE_QUERY="insert into contract_detail values (?, ?, ?, ?)";
    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetails=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            ContractDetail contractDetail;
            while (resultSet.next()){
                contractDetail=new ContractDetail();
                contractDetail.setContract_detail_id(resultSet.getString("contract_detail_id"));
                contractDetail.setContract_id(resultSet.getString("contract_id"));
                contractDetail.setAttach_service_id(resultSet.getString("attach_service_id"));
                contractDetail.setQuantity(resultSet.getInt("quantity"));
                contractDetails.add(contractDetail);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetails;

    }

    @Override
    public void create(ContractDetail contractDetail) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(CREATE_QUERY);
            statement.setString(1,contractDetail.getContract_detail_id());
            statement.setString(2,contractDetail.getContract_id());
            statement.setString(3,contractDetail.getAttach_service_id());
            statement.setInt(4,contractDetail.getQuantity());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
