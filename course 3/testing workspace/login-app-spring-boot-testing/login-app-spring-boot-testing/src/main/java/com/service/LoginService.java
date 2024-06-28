package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			return "account already exists";
		}else {
			loginRepository.save(login);
			return "account created successfully";
		}
	}
	
//	public String signIn(Login login) {
//		Login result = loginRepository.signIn(login.getEmailid(), login.getPassword());
//		if(result!=null) {
//			return "success";
//		}else {
//			return "failure";
//		}
//	}
	
	public String signIn(Login login) {
		// coding 
		
		System.out.println("i came in service layer");
		return null;
	}
}


