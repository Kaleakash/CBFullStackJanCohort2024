package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public String storeEmployee(Employee employee) {
		
		if(employee.getSalary()<10000) {
			return "Salary must be > 10000";
		}else if(employeeDao.storeEmployee(employee)>0) {
			return "Employee record stored successfully";
		}else {
			return "Employee record didn't store";
		}
		
	}
	
	public List<Employee> findAllEmployee() {
		List<Employee> listOfEmp = employeeDao.findAllEmployee();
		Iterator<Employee> li = listOfEmp.iterator();
		while(li.hasNext()) {
			Employee emp = li.next();
			float bonus = emp.getSalary()*0.05f;
			emp.setSalary(emp.getSalary()+bonus);
		}
		
		return listOfEmp;
	}
	
	public String deleteEmployee(int id) {
		if(employeeDao.deleteEmployee(id)>0) {
			return "Employee record deleted";
		}else {
			return "Employee record not present";
		}
		
	}
}






