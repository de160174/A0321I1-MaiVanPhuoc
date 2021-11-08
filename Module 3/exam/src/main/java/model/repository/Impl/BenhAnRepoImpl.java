package model.repository.Impl;

import model.bean.BenhAn;
import model.bean.Product;
import model.repository.BenhAnRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepoImpl implements BenhAnRepo {
    private static final String SELECT_ALL="select * from benh_an";
    private static final String SELECT_ID="select * from benh_an where benh_an_id=?";
    private static final String UPDATE_QUERY="update benh_an set  benh_an_id=?,benh_nhan_name =?,ngay_nhap=?," +
            "ngay_ra=?,ly_do=?, benh_nhan_id=? where benh_an_id=?";
    private static final String DELETE_QUERY="delete from benh_an where benh_an_id=?";
    @Override
    public List<BenhAn> findAll() {
        Connection connection=BaseRepo.getConnection();
        List<BenhAn> benhAns=new ArrayList<>();
        if(connection!=null){
            try {
                PreparedStatement statement=connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("benh_an_id");
                    String name = resultSet.getString("benh_nhan_name");
                    String start = resultSet.getString("ngay_nhap");
                    String end = resultSet.getString("ngay_ra");
                    String lyDo = resultSet.getString("ly_do");
                    String benhNhanId = resultSet.getString("benh_nhan_id");
                    benhAns.add(new BenhAn(id,name,start,end,lyDo,benhNhanId));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return benhAns;
    }

    @Override
    public BenhAn findById(String id) {
        Connection connection=BaseRepo.getConnection();
        BenhAn benhAn=null;
        if (connection!=null){
            try {
                PreparedStatement statement=connection.prepareStatement(SELECT_ID);
                statement.setString(1,id);
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()){
                    benhAn=new BenhAn();
                    benhAn.setBenh_an_id(resultSet.getString("benh_an_id"));
                    benhAn.setBenh_nhan_name(resultSet.getString("benh_nhan_name"));
                    benhAn.setNgay_nhap(resultSet.getString("ngay_nhap"));
                    benhAn.setNgay_ra(resultSet.getString("ngay_ra"));
                    benhAn.setLy_do(resultSet.getString("ly_do"));
                    benhAn.setBenh_nhan_id(resultSet.getString("benh_nhan_id"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return benhAn;
    }

    @Override
    public void update(BenhAn benhAn) {
        Connection connection=BaseRepo.getConnection();
        if(connection!=null){
            try {
                PreparedStatement statement=connection.prepareStatement(UPDATE_QUERY);
                statement.setString(1,benhAn.getBenh_an_id());
                statement.setString(2,benhAn.getBenh_nhan_name());
                statement.setString(3,benhAn.getNgay_nhap());
                statement.setString(4,benhAn.getNgay_ra());
                statement.setString(5,benhAn.getLy_do());
                statement.setString(6,benhAn.getBenh_nhan_id());
                statement.setString(7,benhAn.getBenh_an_id());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(String id) {
        Connection connection=BaseRepo.getConnection();
        if (connection!=null){
            try {
                PreparedStatement statement=connection.prepareStatement(DELETE_QUERY);
                statement.setString(1,id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
