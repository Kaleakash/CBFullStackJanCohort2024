package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository				// this is dao related annotation 
public class EmployeeDao {

	@Autowired						// it search database details in application.properties files. 
	EntityManagerFactory emf;			// di happen for emf
	
	public int storeEmployee(Employee emp) {
		try {
		EntityManager manager  = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
			manager.persist(emp);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteEmployee(int id) {
		
		EntityManager manager  = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Employee emp = manager.find(Employee.class, id);
		if(emp==null) {
			return 0;
		}else {
			tran.begin();
				manager.remove(emp);
			tran.commit();
			return 1;
		}
	}
	
	public List<Employee> findAllEmployee() {
		EntityManager manager  = emf.createEntityManager();
		Query qry = manager.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp = qry.getResultList();
		return listOfEmp;
		
	}
	
	
}



