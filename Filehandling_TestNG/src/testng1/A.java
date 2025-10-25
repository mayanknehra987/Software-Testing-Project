package testng1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A {
	@Test(priority = 3)
	public void TC001() {
		System.out.println("Test case1");

	}

	@Test(priority = 1)
	public void TC002() {
		System.out.println("Test case2");

	}

	@Test(priority = 2)
	public void TC003() {
		System.out.println("Test case3");

	}
	@BeforeClass
	public void dbConnection() {
		System.out.println("DB connection");
		
	}
	@BeforeMethod
	public void browser() {
		System.out.println("Browser Open");
		
	}
	@AfterMethod
	public void browserClose() {
		System.out.println("Browser Close");
		
	}
}
