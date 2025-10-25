package ArchitectureofSelenium.SeleniumFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ArchitectureofSelenium.SeleniumFramework.drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestVWOLogin {
	
	@BeforeMethod
	public void setUp(){
		DriverManager.inIt();
	}
	
	@Test
	public void testLoginNegativeVWO(){
		WebDriver driver = DriverManager.getDriver();
		driver.get("https://app.vwo.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Login - VWO");
		Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
		
		WebElement emailInputBox = driver.findElement(By.id("login-username"));
		emailInputBox.sendKeys("admin@admin.com");
		WebElement passwordlInputBox = driver.findElement(By.name("password"));
		passwordlInputBox.sendKeys("admin");
		driver.findElement(By.id("js-login-btn")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		}
		
		WebElement error_msg = driver.findElement(By.className(".notification-box-description"));
		String error_msg_text = error_msg.getText();
		String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
		System.out.println(error_msg_attribute_dataqa);
		
		Assert.assertEquals(error_msg_attribute_dataqa, "Your email, password, IP address or location did not match");
	}

}
