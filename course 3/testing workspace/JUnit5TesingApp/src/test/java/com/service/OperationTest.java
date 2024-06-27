package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationTest {

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		Operation op = new Operation();
		int result = op.add(100, 200);
		assertEquals(300,result);
	}

	@Test
	void testSub() {
		//fail("Not yet implemented");
		Operation op = new Operation();
		int result = op.sub(500, 200);
		assertEquals(300,result);
	}

}
