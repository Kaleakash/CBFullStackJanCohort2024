package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
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
	@Disabled
	void testSignUp() {
		
		Login ll = new Login();
		ll.setEmailid("akash@gmail.com");
		ll.setPassword("123");
		String result = loginService.signUp(ll);
		assertEquals("account already exists", result);
	}

	
	@Test
	public void testSignIn() {
		Login ll1 = new Login();
		ll1.setEmailid("akash@gmail.com");
		ll1.setPassword("123");
		String result1 = loginService.signIn(ll1);
		assertEquals("success", result1);
		
		Login ll2 = new Login();
		ll2.setEmailid("akash@gmail.com");
		ll2.setPassword("1235");
		String result2 = loginService.signIn(ll2);
		assertEquals("failure", result2);
	}
}
