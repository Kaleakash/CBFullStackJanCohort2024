package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	// http://localhost:9090
	
	@GetMapping(value = "/")
	public String sayHello() {
		return "Welcome to Spring boot running with Docker created by akash!";
	}
}
