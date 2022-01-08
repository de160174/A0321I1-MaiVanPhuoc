package com.example.demo.repository;

import com.example.demo.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Integer> {

    @Query("select ur.role.roleName from UserRole ur where ur.user.username like :username")
    List<String> findAllRoleByUser(String username);

}
