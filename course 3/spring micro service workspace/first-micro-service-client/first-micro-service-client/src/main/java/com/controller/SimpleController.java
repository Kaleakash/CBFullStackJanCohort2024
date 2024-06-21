package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("firstclient")
public class SimpleController {	// http://localhost:8181/firstclient/

	@GetMapping(value = "/")
	public String sayHello() {
		return "Welcome to Spring micro servic first client app!";
	}
}
