package annotationPractice1;

import org.testng.annotations.Test;

public class C {
	@Test()
	public void TC007() {
		System.out.println("Test case7");

	}
	@Test()
	public void TC008() {
		System.out.println("Test case8");

	}
	@Test(groups={"smoke_test"})
	public void TC009() {
		System.out.println("Test case9");

	}
}
