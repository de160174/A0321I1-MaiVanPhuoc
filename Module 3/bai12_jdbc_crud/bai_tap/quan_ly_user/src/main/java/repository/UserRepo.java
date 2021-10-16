package repository;

import bean.User;

import java.util.List;

public interface UserRepo {
     List<User> selectAll();

     User selectUser(int id);

     void create(User user);

     void update(User user);

     void delete(int id);

     List<User> search(String name);

     List<User> sort();
}
