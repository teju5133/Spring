package com.mphasis.repo;
 
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
 
import org.springframework.stereotype.Repository;
 
import com.mphasis.bean.Employee;
@Repository
public class EmployeeRepo {
	private Set<Employee> emps;
	
	public EmployeeRepo () {
		emps=new HashSet<Employee>();
		emps.add(new Employee(1001,"SwarnaTeja","teju5133@gmail.com",LocalDate.of(2001,05,18),55000));
		emps.add(new Employee(1002,"Sadhvi","sadhvivs@gmail.com",LocalDate.of(2002,07,27),50000));
		emps.add(new Employee(1003,"Gayathri","raja@gmail.com",LocalDate.of(2001,05,18),50000));
		emps.add(new Employee(1004,"Madhuri","madhurinaidu904@gmail.com",LocalDate.of(2001,10,12),45000));
		emps.add(new Employee(1005,"Raviteja","ravitej1618@gmail.com",LocalDate.of(2004,11,27),75000));
	}
	public Set<Employee> getAll() {
		return emps;
	}
}
 