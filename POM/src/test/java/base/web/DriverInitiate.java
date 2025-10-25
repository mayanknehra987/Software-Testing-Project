package base.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitiate {
	// 1. option:-make static and inherited this into pages for passing driver in pages
	// public static WebDriver driver;
	public static WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		String expectedTitle = "Your Store";
		String pageTitle=driver.getTitle();
		if(pageTitle.equalsIgnoreCase(expectedTitle)){
		driver.manage().window().maximize();
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

}
