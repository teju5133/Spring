package com.mphasis.api;
 
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.mphasis.bean.Employee;
import com.mphasis.service.EmployeeService;
 
@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAllEmp() {
		return service.getallEmployees();
	}

	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid) {
		Employee e = service.getEmployee(eid);
		if (e != null)
			return new ResponseEntity<Employee>(e, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND);
	}

	  @GetMapping("/city/{city}") 
	  public List<Employee> getByCity(@PathVariable String city) { 
		  return service.getallEmployeesByCity(city); 
	  }
	  @GetMapping("/email/{email}")
		public List<Employee> getByEmail(@PathVariable String email) {
			return service.getallEmployeesByEmail(email);
		}
	  @GetMapping("/name/{name}/city/{city}")
	  public List<Employee> getByNameAndCity(@PathVariable String name, @PathVariable String city) {
		  return service.getallEmployeesByNameAndCity(name,city);
	  }
	 

	@PostMapping
	public Employee createEmployee(@RequestBody Employee e) {
		return service.createEmployee(e);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);
	}

	@DeleteMapping("/{eid}")
	public String deleteEmployee(@PathVariable int eid) {
		return service.deleteEmployee(eid);
	}

}