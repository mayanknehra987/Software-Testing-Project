package annotationPractice;

import org.testng.annotations.Test;

public class A {

	@Test(groups={"smoke_test"})
	public void TC001() {
		System.out.println("Test case1");

	}
	@Test(groups={"sanity_test"})
	public void TC002() {
		System.out.println("Test case2");

	}
	@Test
	public void TC003() {
		System.out.println("Test case3");

	}

	
}
