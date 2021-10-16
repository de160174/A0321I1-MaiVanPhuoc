package service;

import bean.User;

import java.util.List;

public interface UserService {
     void insertUser(User user);

     User selectUser(int id);

     List<User> selectAllUsers();

     void deleteUser(int id);

     void updateUser(User user);

     List<User> findByCountry(String name) ;

     List<User> sortByName();
}
