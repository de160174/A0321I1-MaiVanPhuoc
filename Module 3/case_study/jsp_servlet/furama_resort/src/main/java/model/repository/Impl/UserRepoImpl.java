package model.repository.Impl;

import model.bean.Customer;
import model.bean.User;
import model.repository.UserRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    private BaseRepo baseRepo=new BaseRepo();
    private static final String SELECT_ALL="select * from user";
    @Override
    public List<User> findAll() {
        List<User> users=new ArrayList<>();
        try {
            PreparedStatement statement=this.baseRepo.getConnection()
                    .prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            User user;
            while (resultSet.next()){
                user=new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
