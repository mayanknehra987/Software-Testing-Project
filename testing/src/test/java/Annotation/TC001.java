package Annotation;

import org.testng.annotations.Test;

public class TC001 {
	
	@Test
	public void TC1() {
		System.out.println("Test Case1");

	}
	@Test
	public void TC2() {
		System.out.println("Test Case2");

	}
	@Test(groups= {"smoke"})
	public void TC3() {
		System.out.println("Test Case3");

	}
	@Test(groups= {"sanity"})
	public void TC4() {
		System.out.println("Test Case4");

	}
}
