package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;

@RestController					// @Controller +@ResponseBody
public class ProductController {

	// http://localhost:9191/hello

	@RequestMapping(value = "hello",method = RequestMethod.GET)
	public String sayHello() {
		return "Welcome to Spring boot with product rest api";
	}
	
	// http://localhost:9191/product
	
	@RequestMapping(value = "product",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductInfo() {
		Product p1 = new Product(100, "TV", 34000);
		return p1;
	}
	// http://localhost:9191/products
	@RequestMapping(value = "products",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProducts() {
		List<Product> listOfProduct = new ArrayList<Product>();
		Product p1 = new Product(100, "TV", 34000);
		Product p2 = new Product(101, "Computer", 24000);
		Product p3 = new Product(102, "Laptop", 84000);
		listOfProduct.add(p1);
		listOfProduct.add(p2);
		listOfProduct.add(p3);
		return listOfProduct;
	}
}
