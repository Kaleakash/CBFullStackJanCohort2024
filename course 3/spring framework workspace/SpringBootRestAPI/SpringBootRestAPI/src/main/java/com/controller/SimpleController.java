package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

	//1st option 
	
//	@RequestMapping(value = "say",method = RequestMethod.GET)
//	public ModelAndView sayHello() {
//		// coding...
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("index.jsp");
//		return mav;
//	}
	
	// 2nd option 
	
//	@RequestMapping(value = "say",method = RequestMethod.GET)
//	public String sayHello() {
//		// coding...
//		return "index";	// using viewresolver 
//	}
	// http://localhost:9191/say
	@RequestMapping(value = "say",method = RequestMethod.GET)
	public @ResponseBody String sayHello() {
		return "Welcome to Spring boot with rest api";
	}
	//http://localhost:9191/text
	@RequestMapping(value = "text",method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String sayPlainText() {
		return "<h2>Welcome to Spring boot with rest api<h2>";
	}
	
	//http://localhost:9191/html
	@RequestMapping(value = "html",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String sayHtml() {
		return "<h2>Welcome to Spring boot with rest api<h2>";
	}
	
	//http://localhost:9191/html
		@RequestMapping(value = "xml",method = RequestMethod.GET,produces = MediaType.TEXT_XML_VALUE)
		public @ResponseBody String sayXml() {
			return "<h2>Welcome to Spring boot with rest api<h2>";
		}
}




