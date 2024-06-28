package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HookTestingFunctions {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("before all test start");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after all test start");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before each test start");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("after each test start");
	}
	@Test
	void test1() {
		System.out.println("test1 method");
		assertTrue(true);
	}
	@Test
	void test2() {
		System.out.println("test2 method");
		assertFalse(false);
	}
}
