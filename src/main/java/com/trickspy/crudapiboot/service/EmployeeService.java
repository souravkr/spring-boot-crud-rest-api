package com.trickspy.crudapiboot.service;

import java.util.List;

import com.trickspy.crudapiboot.entity.Employee;


public interface EmployeeService {
	public List<Employee> getEmp();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);

}
