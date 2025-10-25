package annotationPractice1;

import org.testng.annotations.Test;

public class D {
	@Test()
	public void TC0010() {
		System.out.println("Test case10");

	}
	@Test()
	public void TC0011() {
		System.out.println("Test case11");

	}
	@Test(groups={"smoke_test"})
	public void TC0012() {
		System.out.println("Test case12");

	}

}
