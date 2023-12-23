package com.example.hrms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hrms.dao.UserdetailsDao;
import com.example.hrms.model.User;
import com.example.hrms.model.UserPrinicipal;


@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
UserdetailsDao userdetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user =  this.userdetailsDao.findByUname(username);
       if (user==null){
        throw new UsernameNotFoundException("user not found");
       }
        // TODO Auto-generated method stub
       return new UserPrinicipal(user);
    }
    
}
