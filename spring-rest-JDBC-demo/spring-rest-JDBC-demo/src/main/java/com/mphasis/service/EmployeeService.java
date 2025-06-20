package com.mphasis.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bean.Employee;
import com.mphasis.repo.IEmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepo erepo;

	public List<Employee> getallEmployees() {
		return erepo.findAll();
	}

	public List<Employee> getallEmployeesByCity(String city) {
		return erepo.findByCity(city);
	}

	public List<Employee> getallEmployeesByEmail(String email) {
		return erepo.findByEmail(email);
	}
	public List<Employee> getallEmployeesByNameAndCity(String name, String city) {
		return erepo.findByNameAndCity(name,city);
	}

	public Employee getEmployee(int empid) {
		Optional<Employee> op = erepo.findById(empid);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}

	public Employee createEmployee(Employee e) {
		Employee emp = erepo.saveAndFlush(e);
		return emp;
	}

	public Employee updateEmployee(Employee e) {
		if (getEmployee(e.getEmpid()) != null)
			return erepo.saveAndFlush(e);
		else
			return null;
	}

	public String deleteEmployee(int empid) {
		if (getEmployee(empid) != null) {
			erepo.deleteById(empid);
			return "Employee Deleted";
		} else {
			return "Employee not found";
		}
	}

}