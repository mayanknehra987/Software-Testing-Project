package annotationPractice;

import org.testng.annotations.Test;

public class B {
//	@Test()
//	public void TC004() {
//		System.out.println("Test case4");
//
//	}
//	@Test(groups={"smoke_test"})
//	public void TC005() {
//		System.out.println("Test case5");
//
//	}
//	@Test
//	public void TC006() {
//		System.out.println("Test case6");
//
//	}
	@Test
	public void TC001() {
		System.out.println("Test case1");

	}

	@Test(dependsOnMethods = "TC003")
	public void TC002() {
		System.out.println("Test case2");

	}

	@Test
	public void TC003() {
		System.out.println("Test case3");

	}
	@Test
	public void TC004() {
		System.out.println("Test case4");

	}
}
