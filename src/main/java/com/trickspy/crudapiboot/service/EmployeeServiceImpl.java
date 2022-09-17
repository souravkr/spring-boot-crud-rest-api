package com.trickspy.crudapiboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trickspy.crudapiboot.dao.EmployeeDao;
import com.trickspy.crudapiboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao dao;

	@Override
	@Transactional
	public List<Employee> getEmp() {
		// TODO Auto-generated method stub
		return dao.getEmp();
	}

	@Transactional
	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		dao.save(emp);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
dao.deleteById(id);
	}

}
