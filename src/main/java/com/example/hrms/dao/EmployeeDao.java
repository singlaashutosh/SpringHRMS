package com.example.hrms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.hrms.model.Employee;
@Component
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    //QueryDSL Db can be searched using any instantance variable. JPA provides its implementaion.
   List<Employee> findByFirstName(String firstName);

;

}
