package repository;

import bean.User;

import java.util.List;

public interface UserRepo {
    public List<User> selectAll();

    public User selectUser(int id);

    public void create(User user);

    public void update(User user);

    public void delete(int id);

    List<User> selectAll_proc();

    void edit_proc(User user);

    void delete_prov(int id);
}
