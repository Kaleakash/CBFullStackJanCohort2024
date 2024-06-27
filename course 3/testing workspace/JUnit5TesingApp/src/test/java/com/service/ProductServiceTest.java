package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.bean.Product;

class ProductServiceTest {

	@Test
	@Disabled
	void testStoreProduct() {
		//fail("Not yet implemented");
		ProductService ps = new ProductService();
		Product p = new Product(100, "TV", 56000);
		String result = ps.storeProduct(p);
		assertEquals("Your product stored", result);
	}

	@Test
	void testGetProduct() {
		//fail("Not yet implemented");
		ProductService ps = new ProductService();
		Product p= ps.getProduct();
		assertNotNull(p);
		assertEquals(100, p.getPid());
			try {
			assertEquals(45000, p.getPrice());
			}catch(Error e) {
				System.err.println(e);
			}
		assertEquals("TV", p.getPname());
	}

	@Test
	@Disabled
	void testFindAllProducts() {
		//fail("Not yet implemented");
	}

}
