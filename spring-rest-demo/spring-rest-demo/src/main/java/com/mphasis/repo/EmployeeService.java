package com.mphasis.repo;
 
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.mphasis.bean.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo erepo;
	public Set<Employee> getallEmployees() {
		return erepo.getAll();
	}
	public Employee getEmployee(int empid) {
		for(Employee e:erepo.getAll()) {
			if(e.getEmpid()==empid)
				return e;
		}
		return null;
	}
	public Employee createEmployee(Employee e) {
		erepo.getAll().add(e);
		return e;
	}
}
 