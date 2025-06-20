package com.mphasis.api;
 
import java.time.LocalDate;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.mphasis.bean.Employee;
import com.mphasis.repo.EmployeeService;
 
@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	/*
	 * @GetMapping("hello") public String sayHello(@RequestParam("t1") String name)
	 * { return "Hello "+name; }
	 */
	 
	
	  @GetMapping("hello/{name}") public String sayHello(@PathVariable String name)
	  { return "Hello "+name; }
	 
	  @GetMapping("emp") public Employee sayHello1(String name) { return new
	  Employee(1001,"Sadhvi","sadhvivs@gmail.com", LocalDate.of(2002,07,27),75000);
	  }
	 
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public Set<Employee> getAllEmp(){
		return service.getallEmployees();
	}
	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid){
		Employee e=service.getEmployee(eid);
		if(e!=null)
			return new ResponseEntity<Employee>(e,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity("Employee Not Found",HttpStatus.NOT_FOUND);
	}
	@PostMapping
	public Employee createEmployee(Employee e) {
		System.out.println("=============="+e.getName());
		return service.createEmployee(e);
	}
}