package repository.Impl;

import bean.User;
import repository.UserRepo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<User> selectAll_proc() {
        List<User> users=new ArrayList<>();
        String query="{CALL select_all()}";
        try {
            CallableStatement statement=this.baseRepo.getConnection()
                    .prepareCall(query);
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
    public void edit_proc(User user) {
        String query="{CALL update_user(?,?,?,?)}";
        try {
            CallableStatement statement=this.baseRepo.getConnection()
                    .prepareCall(query);
            statement.setString(1,user.getName());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmail());
            statement.setInt(4,user.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete_prov(int id) {
        String query="{CALL delete_user(?)}";
        try {
            CallableStatement statement=this.baseRepo.getConnection()
                    .prepareCall(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
