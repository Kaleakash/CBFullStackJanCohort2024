package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Employee;
import com.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	// http://localhost:9191/
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String firstPage() {
		System.out.println("I Came Here");
		return "index";		// viewresolver :return page with without extension
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String addEmployeePage() {
		System.out.println("Add Employee Page Open");
		return "addEmployee";		// viewresolver :return page with without extension
	}
	
	@RequestMapping(value = "addEmployeeInDb",method = RequestMethod.POST)
	public String addEmployeeInDb(HttpServletRequest req,Employee emp,Model model) {   // DI for request object as well as Employee  
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		float salary = Float.parseFloat(req.getParameter("salary"));
		
		emp.setId(id);
		emp.setSalary(salary);
		emp.setName(name);
		
		String result = employeeService.storeEmployee(emp);
		model.addAttribute("msg", result);  // store result in model scope
		System.out.println(result);
		
		return "addEmployee";		// viewresolver :return page with without extension
	}
	
	
}





