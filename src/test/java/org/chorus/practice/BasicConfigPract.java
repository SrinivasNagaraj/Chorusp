package org.chorus.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicConfigPract {
@BeforeSuite
public void beforeSetup() {
	System.out.println("before suite1");
}
@BeforeTest
public void beforeTestSetup() {
	System.out.println("before test1");
}
@BeforeClass
public void beforeClassSetup() {
	System.out.println("before class1");
}
@AfterClass
public void afterClassSetup() {
	System.out.println("after class1");
}
@Test
public void testStep() {  
	System.out.println("test Script");
}
@BeforeMethod
public void beforeMethodSetup() {
	System.out.println("before method1");
}
}
