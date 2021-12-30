package com.example.demo.service;


import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.model.User user= userRepo.findByUserName(username);
        if(username==null){
            throw new UsernameNotFoundException("User" +username+"not found");
        }
        List<String> roles=userRoleRepo.findAllRoleByUser(user.getUserId());
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        if(roles!=null){
            for(String roleName: roles){
                GrantedAuthority authority=new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(authority);
            }
        }
        UserDetails userDetails=new User(user.getUserName(),user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
