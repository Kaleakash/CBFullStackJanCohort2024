package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "findAllProducts",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public List<Product> findAllProducts() {
		return productService.findAllProducts();
	}
	@RequestMapping(value = "storeProduct",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String storeProduct(@RequestBody Product product) {
		return productService.storeProduct(product);
	}
	
}



