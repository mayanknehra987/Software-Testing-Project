package testng3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class D {
	@Test()
	public void TC001() {
		System.out.println("Test case1");

	}

	@Test()
	public void TC002() {
		System.out.println("Test case2");

	}

	@Test()
	public void TC003() {
		System.out.println("Test case3");
		Assert.assertTrue(false);
	}
}
