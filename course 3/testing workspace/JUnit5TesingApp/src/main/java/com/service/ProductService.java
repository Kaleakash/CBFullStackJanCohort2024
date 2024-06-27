package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Product;

public class ProductService {

	public String storeProduct(Product product) {
		// we need to write logic to store product in file or db or in arrary.
		return "Your product stored";
	}
	
	public Product getProduct() {
		// we can check from db present or not. 
		Product p = new Product(100, "TV", 56000);
		return p;
		//return null;
	}
	public List<Product> findAllProducts() {
		// we can retrieve from db. 
		List<Product> listOfproduct = new ArrayList<Product>();
		listOfproduct.add(new Product(100, "TV", 45000));
		listOfproduct.add(new Product(101, "Computer", 35000));
		listOfproduct.add(new Product(102, "Laptop", 95000));
		return listOfproduct;
	}
}
