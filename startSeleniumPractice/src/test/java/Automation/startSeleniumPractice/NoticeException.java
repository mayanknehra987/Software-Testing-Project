package Automation.startSeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
public class NoticeException {
	
		    public static void main(String[] args) throws NoSuchElementException{
		    	WebDriverManager.chromedriver().clearDriverCache().setup();
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://example.com"); // Navigate to the page

		        try {
		            // Trying to find and click the button immediately
		            WebElement button = driver.findElement(By.id("submitButton")); // May cause NoSuchElementException
		            button.click();
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }

		        driver.quit();
		    }
		}


