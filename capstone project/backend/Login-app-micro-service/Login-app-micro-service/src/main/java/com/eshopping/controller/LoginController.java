package com.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.entity.Login;
import com.eshopping.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin			// allow to access my rest api for all url for all methods. 
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "signin",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		return loginService.signIn(login);
	}
	
	@PostMapping(value = "signup",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		return loginService.signUp(login);
	}
}
