package com.mphasis.bean;
 
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
 
public class Employee {
	private int empid;
	private String name;
	private String email;
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private LocalDate dob;
	private double salary;
	
	public Employee() {
		
	}
 
	public Employee(int empid, String name, String email, LocalDate dob, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.salary = salary;
	}
 
	public int getEmpid() {
		return empid;
	}
 
	public void setEmpid(int empid) {
		this.empid = empid;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public LocalDate getDob() {
		return dob;
	}
 
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
 
	public double getSalary() {
		return salary;
	}
 
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, empid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && empid == other.empid;
	}
	
}