package model.repository.Impl;

import model.bean.BenhNhan;
import model.bean.Category;
import model.repository.BenhNhanRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepoImpl implements BenhNhanRepo {
    private static final String SELECT_ALL = "SELECT * FROM benh_nhan";
    @Override
    public List<BenhNhan> findAll() {
        Connection connection=BaseRepo.getConnection();
        List<BenhNhan> benhNhans=new ArrayList<>();
        if(connection!=null){
            try {
                PreparedStatement statement=connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("benh_nhan_id");
                    String name = resultSet.getString("benh_nhan_name");
                    benhNhans.add(new BenhNhan(id,name));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhNhans;
    }
}
