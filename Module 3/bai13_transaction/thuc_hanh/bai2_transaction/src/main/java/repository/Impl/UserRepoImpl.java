package repository.Impl;

import bean.User;
import repository.UserRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    private BaseRepo baseRepo=new BaseRepo();
    @Override
    public List<User> selectAll() {
        List<User> users=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("select * from users");
            ResultSet resultSet=statement.executeQuery();
            User user;
            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public User selectUser(int id) {
        User user=null;
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("select * from users where id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("INSERT INTO users  VALUES (?, ?, ?, ?)");
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getCountry());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("update users set name =?, email=?, country=?"+ " where id=?");
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("delete from users where id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        ResultSet rs=null;
        try {
            this.baseRepo.getConnection().setAutoCommit(false);
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement("INSERT INTO users" + "  (name, email, country) VALUES " +
                            " (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            int rowAffected = statement.executeUpdate();
            rs=statement.getGeneratedKeys();
            int userId=0;
            if(rs.next()){
                userId=rs.getInt(1);
            }
            if(rowAffected==1){
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                PreparedStatement statement1=this.baseRepo.getConnection()
                        .prepareStatement(sqlPivot);
                for(int permisionId:permision){
                    statement1.setInt(1,userId);
                    statement1.setInt(2,permisionId);
                    statement1.executeUpdate();
                }
                baseRepo.getConnection().commit();
            }else {
                baseRepo.getConnection().rollback();
            }
        } catch (SQLException throwables) {
                try {
                    if(baseRepo.getConnection()!=null){
                    baseRepo.getConnection().rollback();}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            throwables.printStackTrace();
        }
    }
}
