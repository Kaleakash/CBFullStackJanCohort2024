package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secondclient")
public class SampleController {		// http://localhost:8282/secondclient/

	@GetMapping(value = "/")
	public String sayHello() {
		return "Welcome to simple micro service client app!";
	}
}
