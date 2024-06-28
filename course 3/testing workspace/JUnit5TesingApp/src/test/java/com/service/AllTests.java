package com.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ HookTestingFunctions.class, OperationTest.class, ProductServiceTest.class })
public class AllTests {

}
