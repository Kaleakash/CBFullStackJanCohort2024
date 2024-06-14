package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// http://localhost:9191/posttest
	
	@RequestMapping(value = "posttest",method = RequestMethod.POST)
	public String postTest() {
		System.out.println("post method called");
		return "post method test";
	}
	// http://localhost:9191/storeProduct
	// data : {"pid":100,"pname":"TV","price":56000}
	@RequestMapping(value = "storeProduct",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product product) {//@RequestBody annotation extract json data from body part with post method 
		System.out.println(product);
		System.out.println("product data post method");
		return "Product data stored";
	}
	
		// http://localhost:9191/updateProduct
		// data : {"pid":100,"price":56000}
	
		@RequestMapping(value = "updateProduct",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updateProduct(@RequestBody Product product) {//@RequestBody annotation extract json data from body part with post method 
			System.out.println(product);
			System.out.println("product data update method");
			return "Product data updated";
		}
		
		// http://localhost:9191/deleteProduct/100
			
		@RequestMapping(value = "deleteProduct/{pid}",method = RequestMethod.DELETE)
		public String deleteProduct(@PathVariable("pid") int pid) { 
			System.out.println("product data update method");
			return "Product deleted using pid as "+pid;
		}
}


