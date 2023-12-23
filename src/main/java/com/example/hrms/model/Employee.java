package com.example.hrms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.stereotype.Component;



@Entity
public class Employee {

    @javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	String firstName;

	String lastName;
	
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
