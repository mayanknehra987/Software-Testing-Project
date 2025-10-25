package Annotation;

import org.testng.annotations.Test;

public class TC002 {

	
	@Test(dependsOnMethods = "TC004")
	public void TC001() {
		System.out.println("Test case1");

	}

	@Test()
	public void TC0002() {
		System.out.println("Test case2");
		//Assert.assertTrue(false);
	}

	@Test()
	public void TC003() {
		System.out.println("Test case3");

	}
	@Test()
	public void TC004() {
		System.out.println("Test case4");

	}
}
