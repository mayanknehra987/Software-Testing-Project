package testng2;

import org.testng.annotations.Test;

public class C {
	@Test(dependsOnMethods="TC3")
	public void TC1() {
		System.out.println("Test case1");

	}

	@Test()
	public void TC2() {
		System.out.println("Test case2");

	}

	@Test
	public void TC3() {
		System.out.println("Test case3");

	}
	@Test
	public void TC4() {
		System.out.println("Test case4");

	}

}
