package com.example.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hrms.model.Employee;
import com.example.hrms.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
@RequestMapping("/v1")
public class HRMSRestController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employee/{id}")
	Optional<Employee> getEmp(@PathVariable int id) {
		return this.empService.getEmp(id);
		}

		@PostMapping("/employee")
		public List<Employee> addEmp(@RequestBody Employee entity) {
			
			//TODO: process POST request
			
			return this.empService.addEmp(entity);
		}
@GetMapping("/employee")
public List<Employee> getMethodName(@RequestParam String fname) {

    return this.empService.findByFirstName(fname) ;
}

		
		
		
	
	
}
