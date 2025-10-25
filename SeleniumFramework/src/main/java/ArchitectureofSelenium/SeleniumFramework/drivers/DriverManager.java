package ArchitectureofSelenium.SeleniumFramework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import ArchitectureofSelenium.SeleniumFramework.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}
	public static void inIt() {
		String browser = null;
		browser = PropertyReader.readKey("browser");
		if (driver == null) {
			switch (browser) {
			case "edge":
				EdgeOptions edgeOption = new EdgeOptions();
				edgeOption.addArguments("start-maximized");
				edgeOption.addArguments("guest");
				WebDriverManager.edgedriver().clearDriverCache().setup();
				driver = new EdgeDriver(edgeOption);
				break;
			case "chrome":
				ChromeOptions chromeOption = new ChromeOptions();
				chromeOption.addArguments("start-maximized");
				chromeOption.addArguments("guest");
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver(chromeOption);
				break;
			default:
				System.out.println("Not Browser Found");
			}
		}
	}

	public static void Down() {
		if(driver!=null){
			driver.quit();
			driver=null;
		}

	}

}
