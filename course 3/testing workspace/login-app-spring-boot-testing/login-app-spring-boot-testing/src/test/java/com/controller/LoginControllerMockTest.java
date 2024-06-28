package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Login;
import com.service.LoginService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LoginControllerMockTest {

	@Mock
	LoginService loginService;
	
	@InjectMocks
	LoginController loginController;
	
	@Test
	void testSignIn() {
	Login ll = new Login();
	ll.setEmailid("raju@gmail.com");
	ll.setPassword("121212");
	
	// Fake information we are providing 
	Mockito.when(loginService.signIn(ll)).thenReturn("successfully login"); 
	
	String result = loginController.signIn(ll);
	assertEquals("successfully login", result);
	}

	@Test
	void testSignUp() {
		Login ll = new Login();
		ll.setEmailid("raju@gmail.com");
		ll.setPassword("121212");
		
		// Fake information we are providing 
		Mockito.when(loginService.signUp(ll)).thenReturn("account created"); 
		
		String result = loginController.signUp(ll);
		assertEquals("account created", result);
	}

}
