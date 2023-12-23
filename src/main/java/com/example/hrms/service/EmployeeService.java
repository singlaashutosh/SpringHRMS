package com.example.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hrms.dao.EmployeeDao;
import com.example.hrms.model.Employee;

@Component
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	
	public Optional<Employee> getEmp(int id) {
		;
		return this.empDao.findById(id);};


	public List<Employee> addEmp(Employee e) {

		this.empDao.save(e);

		return this.empDao.findAll();
	}

	public List<Employee> findByFirstName(String s) {
		return this.empDao.findByFirstName(s);
	}

	public List<Employee> findAllEmp() {
		return this.empDao.findAll();
	}
	public void deleteEmp(int id) {
		 this.empDao.deleteById(id);;
	}

}
