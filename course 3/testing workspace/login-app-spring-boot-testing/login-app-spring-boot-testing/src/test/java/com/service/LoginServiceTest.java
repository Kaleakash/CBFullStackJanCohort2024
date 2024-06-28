package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entity.Login;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	LoginService loginService;
	
	@Test
	void testSignUp() {
		
		Login ll = new Login();
		ll.setEmailid("akash@gmail.com");
		ll.setPassword("123");
		String result = loginService.signUp(ll);
		assertEquals("account already exists", result);
	}

}
