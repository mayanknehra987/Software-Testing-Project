package assertion;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Softassertion {
	WebDriver driver;
	SoftAssert softAssert;
	@Test
    public void verifyData() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.google.com");
        String actualTitle = "My App";
        softAssert.assertEquals(actualTitle, "My Application", "Incorrect application title");

        int actualCount = 5;
        softAssert.assertTrue(actualCount > 10, "Countess than expected");

        boolean actualFlag = false;
        softAssert.assertTrue(actualFlag, "Flag is true instead of false");

        // Perform more soft assertions

        softAssert.assertAll();
}
	@BeforeMethod
    public void setUp() {
        // Set up WebDriver
       WebDriverManager.chromedriver().clearDriverCache().setup();
		//WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Initialize SoftAssert
        softAssert = new SoftAssert();
    }

}
