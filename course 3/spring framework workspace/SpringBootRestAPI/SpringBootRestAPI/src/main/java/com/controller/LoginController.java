package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	// http://localhost:9191/singleQueryParam?emailid=ravi@gmail.com
	
	@RequestMapping(value = "singleQueryParam",method = RequestMethod.GET)
	public String singleQueryParam(@RequestParam("emailid") String emailid) {
		return "Welcome to rest api using query param "+emailid;
	}
	
	// http://localhost:9191/multiQueryParam?emailid=ravi@gmail.com&password=123
	@RequestMapping(value = "multiQueryParam",method = RequestMethod.GET)
	public String multiQueryParam(@RequestParam("emailid") String emailid,@RequestParam("password") String password) {
		if(emailid.equals("ravi@gmail.com") && password.equals("123")) {
			return "successfully login using query param";
		}else {
			return "failure try once again using query param";
		}
	}
	
	// http://localhost:9191/singlePathParam/ravi@gmail.com
	
	@RequestMapping(value = "singlePathParam/{emailid}",method = RequestMethod.GET)
	public String singlePathParam(@PathVariable("emailid") String emailid) {
		return "Welcome to rest api using path param "+emailid;
	}
	
	// http://localhost:9191/multiPathParam/ravi@gmail.com/123
	
		@RequestMapping(value = "multiPathParam/{emailid}/{password}",method = RequestMethod.GET)
		public String multiPathParam(@PathVariable("emailid") String emailid, @PathVariable("password") String password) {
			if(emailid.equals("ravi@gmail.com") && password.equals("123")) {
				return "successfully login using path param";
			}else {
				return "failure try once again using path param";
			}
		}
}
