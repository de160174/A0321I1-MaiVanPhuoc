package model.service.Impl;

import model.bean.User;
import model.repository.Impl.UserRepoImpl;
import model.repository.UserRepo;
import model.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo=new UserRepoImpl();
    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }
}
