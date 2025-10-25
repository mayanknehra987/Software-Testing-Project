package assertion;

import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hardassertion {
	WebDriver driver;
	
	@BeforeMethod
    public void setUp() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void loginTest() {
        // Perform login functionality
    	String actualTitle = "Google";
        Assert.assertEquals(actualTitle, "Google1", "correct application title");


        // Verify the login result using hard assertions
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        
        String expectedUsername = "testUser";
        String actualUsername = driver.findElement(By.id("usernameLabel")).getText();
        Assert.assertEquals(actualUsername, expectedUsername, "Incorrect username displayed");
    }

}
