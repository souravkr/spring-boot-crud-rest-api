package com.trickspy.crudapiboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trickspy.crudapiboot.entity.Employee;
import com.trickspy.crudapiboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
   @GetMapping("/employees")
	public List<Employee> getEmployee(){
		return service.getEmp();
	}
   
   @PostMapping("employees")
    public Employee postEmploye(@RequestBody Employee emp) {
	   service.save(emp);
	   return emp;
   }
   
   @GetMapping("employees/{id}")
   public Employee getEmplyeeById(@PathVariable("id") int id) {
	   
	   Employee emp = service.findById(id);
      if(emp==null) {
    	  throw new RuntimeException("employee not found");
      }
      
      return emp;
   
   }
   
   @PutMapping("employees/")
   public Employee updateEmp(@RequestBody Employee emp) {
	   
	   service.save(emp);
	   return emp;
   }
   
   @DeleteMapping("employees/{id}")
   public String deleteEmp(@PathVariable("id") int id) {
	   Employee emp = service.findById(id);
	   
	   if(emp == null) {
		   throw new RuntimeException("id does not existes");
	   }
	   
	   service.deleteById(id);
	   
	   return "deleted id is "+id;
   }
}
