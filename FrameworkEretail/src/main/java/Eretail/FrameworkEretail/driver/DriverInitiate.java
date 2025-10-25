package Eretail.FrameworkEretail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import Eretail.FrameworkEretail.base.CommonToAllPages;
import Eretail.FrameworkEretail.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitiate {
	// 1. option:-make static and inherited this into pages for passing driver
	// in pages
	// public static WebDriver driver;

	public static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public static void startBrowser() {
		String browser = null;
		browser = PropertyReader.readKey("browserName");
		if (driver == null) {
			switch (browser) {
			case "edge":
				EdgeOptions edgeOption = new EdgeOptions();
				edgeOption.addArguments("start-maximized");
				edgeOption.addArguments("guest");
				WebDriverManager.edgedriver().clearDriverCache().setup();
				driver = new EdgeDriver(edgeOption);
				driver.get(PropertyReader.readKey("applicationURL"));
				String expectedTitle = "Welcome to eRetail";
				String pageTitle = driver.getTitle();
				try {
					if (pageTitle.equalsIgnoreCase(expectedTitle)) {
						driver.manage().window().maximize();
					}
				} catch (Exception e) {
					System.out.println("Login verification failed: " + e.getMessage());
				}
				break;
			case "chrome":
				ChromeOptions chromeOption = new ChromeOptions();
				chromeOption.addArguments("start-maximized");
				chromeOption.addArguments("guest");
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver(chromeOption);
				driver.navigate().to(PropertyReader.readKey("applicationURL"));
				CommonToAllPages.verifyPageTitle();
				break;
			default:
                throw new RuntimeException("Unsupported browser: " + browser);
			}
		}
	}
	@AfterMethod
	public static void closeBrowser() {
		// if(driver!=null){
		// driver.quit();
		// driver=null;
		// }
	}
}
