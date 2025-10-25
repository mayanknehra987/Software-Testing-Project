package notepad;

import org.testng.annotations.Test;

public class TestNG {
	@Test(priority = 2)
	public void TC001() {
		System.out.println("Test case1");

	}
	@Test(priority =1)
	public void TC002() {
		System.out.println("Test case2");

	}
	@Test
	public void TC003() {
		System.out.println("Test case3");

	}

}
