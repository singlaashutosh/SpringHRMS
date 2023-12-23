package com.example.hrms.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinicipal implements UserDetails{


    @Autowired
    User user;

    public UserPrinicipal(User user2) {
        this.user=user2;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return  Collections.singleton(new SimpleGrantedAuthority("USER")) ;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.user.getPass();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.user.getUname();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
