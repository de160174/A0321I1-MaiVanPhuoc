package com.example.demo.service.Impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
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
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.model.User user=userRepository.findByUsername(username);
        if(username==null){
            throw new UsernameNotFoundException("User " +username+ " not found");
        }
        List<String> roles=userRoleRepository.findAllRoleByUser(user.getUsername());
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        if(roles!=null){
            for (String roleName: roles){
                GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(grantedAuthority);
            }
        }
        UserDetails userDetails=new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
