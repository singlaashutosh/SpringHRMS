package com.example.hrms;

import java.util.List;

import javax.annotation.security.PermitAll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class HrmsWebSecurity extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsService  userDetailsService;

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;

    }
   @Override
    protected void configure(HttpSecurity http) throws Exception{
//configuration for custom login page and not spring defalut.
        http 
        .csrf().disable()
        .authorizeRequests().antMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login").permitAll();
        


    }


   /* 
    @Bean
   @Override
    protected UserDetailsService userDetailsService() {
        // TODO Auto-generated method stub
        List<UserDetails> users = new ArrayList<>();
        users.add(User.builder().username("abc").password("{noop}xyz").roles("admin").build());
        return new InMemoryUserDetailsManager(users);
    }*/ 
    

    
}
