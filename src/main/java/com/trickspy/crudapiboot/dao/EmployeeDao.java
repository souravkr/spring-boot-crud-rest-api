package com.trickspy.crudapiboot.dao;

import java.util.List;

import com.trickspy.crudapiboot.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getEmp();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
