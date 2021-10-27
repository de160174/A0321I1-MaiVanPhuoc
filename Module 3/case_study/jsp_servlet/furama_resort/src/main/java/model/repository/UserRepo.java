package model.repository;

import model.bean.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();
}
