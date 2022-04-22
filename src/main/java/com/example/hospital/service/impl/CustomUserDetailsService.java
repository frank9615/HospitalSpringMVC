package com.example.hospital.service.impl;

import com.example.hospital.entities.User;
import com.example.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.transaction.Transactional;

@Service("customUserDetailService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Utente non Trovato!!");
        }
        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());;
        userBuilder.password("{noop}"+ user.getPassword());
        userBuilder.authorities("ROLE_" + user.getRole());

        return userBuilder.build();


    }
}
