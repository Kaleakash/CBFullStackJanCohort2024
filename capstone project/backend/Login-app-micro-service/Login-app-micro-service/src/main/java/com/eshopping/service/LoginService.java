package com.eshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.entity.Login;
import com.eshopping.repository.LoginRepository;

@Service 
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public String signUp(Login login) {
		if(loginRepository.existsById(login.getEmailid())) {
			return "Emailid must be unique";
		}else if(login.getTypeofuser().equals("admin")){
			return "You can't create admin account";
		}else {
			loginRepository.save(login);
			return "Account created successfully";
		}
	}
	
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login ll =result.get();
			if(ll.getPassword().equals(login.getPassword())) {
				
				if(ll.getTypeofuser().equals(login.getTypeofuser()) && ll.getTypeofuser().equals("admin")) {
					return "Admin login successfully";
				}else if(ll.getTypeofuser().equals(login.getTypeofuser()) && ll.getTypeofuser().equals("customer")) {
					return "Customer login successfully";
				}
				else {
					return "Type of user is invalid";
				}
				
			}else {
				return "Password is wrong";
			}
		}else {
			return "Emailid is wrong";
		}
		
	}
}
