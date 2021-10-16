package service.Impl;

import bean.User;
import repository.Impl.UserRepoImpl;
import repository.UserRepo;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo=new UserRepoImpl();


    @Override
    public void insertUser(User user) {
        this.userRepo.create(user);
    }

    @Override
    public User selectUser(int id) {
        return this.userRepo.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userRepo.selectAll();
    }

    @Override
    public void deleteUser(int id) {
        this.userRepo.delete(id);
    }

    @Override
    public void updateUser(User user) {
        this.userRepo.update(user);
    }

    @Override
    public List<User> findByCountry(String name) {
        return this.userRepo.search(name);
    }

    @Override
    public List<User> sortByName() {
        return this.userRepo.sort();
    }
}
