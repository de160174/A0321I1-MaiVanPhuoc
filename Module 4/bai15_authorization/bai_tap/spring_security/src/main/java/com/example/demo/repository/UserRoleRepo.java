package com.example.demo.repository;

import com.example.demo.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUser(Integer id);

    @Query("select ur.role.roleName from UserRole ur where ur.user.userId= :userId")
    List<String> findAllRoleByUser(Integer userId);
}
