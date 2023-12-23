package com.example.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.model.User;

public interface UserdetailsDao extends JpaRepository<User,Integer>{
    User findByUname(String username);


}
