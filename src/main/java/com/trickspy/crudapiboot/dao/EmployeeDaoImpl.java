package com.trickspy.crudapiboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trickspy.crudapiboot.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager temp) {
		entityManager = temp;
	}
	
	
	@Override
	public List<Employee> getEmp() {
      
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee",Employee.class);

		List<Employee> result = query.getResultList();
		
		return result;
	}


	@Override
	public Employee findById(int id) {

		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Employee.class, id);
	}


	@Override
	public void save(Employee emp) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(emp);
	}


	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(session.get(Employee.class, id));
		
	}

}
