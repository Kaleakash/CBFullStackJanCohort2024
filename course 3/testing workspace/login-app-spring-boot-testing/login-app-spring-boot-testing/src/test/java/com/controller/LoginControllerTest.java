package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Login;

@SpringBootTest
class LoginControllerTest {

	@Autowired
	LoginController loginController;
	
	@Test
	@Disabled
	void testSignIn() {
	Login ll1 = new Login();
	ll1.setEmailid("akash@gmail.com");
	ll1.setPassword("123");
	String result1 = loginController.signIn(ll1);
	assertEquals("success", result1);
	Login ll2 = new Login();
	ll2.setEmailid("akash@gmail.com");
	ll2.setPassword("123555");
	String result2 = loginController.signIn(ll2);
	assertEquals("failure", result2);
	
	}
	@Test
	@Disabled
	void testSignUp() {
		Login ll1 = new Login();
		ll1.setEmailid("ravi@gmail.com");
		ll1.setPassword("123");
		String result1 = loginController.signUp(ll1);
		assertEquals("account created successfully", result1);
	}

}
