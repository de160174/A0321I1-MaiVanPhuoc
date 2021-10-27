package model.repository.Impl;

import model.bean.AttachService;
import model.bean.User;
import model.repository.AttachRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachRepoImpl implements AttachRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from attach_service";
    @Override
    public List<AttachService> findAll() {
        List<AttachService> attachServices=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            AttachService attachService;
            while (resultSet.next()){
                attachService=new AttachService();
                attachService.setAttach_service_id(resultSet.getString("attach_service_id"));
                attachService.setAttach_service_name(resultSet.getString("attach_service_name"));
                attachService.setAttach_service_cost(resultSet.getDouble("attach_service_cost"));
                attachService.setAttach_service_unit(resultSet.getInt("attach_service_unit"));
                attachService.setAttach_service_status(resultSet.getString("attach_service_status"));
                attachServices.add(attachService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachServices;
    }
}
