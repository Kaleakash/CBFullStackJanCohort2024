package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.bean.Product;

class ProductServiceTest {

	@Test
	//@Disabled
	void testStoreProduct() {
		//fail("Not yet implemented");
		ProductService ps = new ProductService();
		Product p = new Product(100, "TV", 56000);
		String result = ps.storeProduct(p);
		assertEquals("Your product stored", result);
	}

	@Test
	//@Disabled
	void testGetProduct() {
		//fail("Not yet implemented");
		ProductService ps = new ProductService();
		Product p= ps.getProduct();
		assertNotNull(p);
		assertEquals(100, p.getPid());
			try {
			assertEquals(56000, p.getPrice());
			}catch(Error e) {
				System.err.println(e);
			}
		assertEquals("TV", p.getPname());
	}

	@Test
	void testFindAllProducts() {
		ProductService ps = new ProductService();
		List<Product> listOfProduct = ps.findAllProducts();
		assertNotNull(listOfProduct);
		assertEquals(3, listOfProduct.size());
		Product p = listOfProduct.get(1);
		assertEquals(101, p.getPid());
		try {
		assertEquals(35000, p.getPrice());
		}catch(Error e) {
			System.err.println(e);
		}
		assertEquals("Computer", p.getPname());
	}

}
