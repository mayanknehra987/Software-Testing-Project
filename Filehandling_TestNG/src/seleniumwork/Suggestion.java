package seleniumwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Suggestion {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.findElement(By.id("autosuggest")).sendKeys("Ind");	
	Thread.sleep(2000);
	//css by parent to child method use space b/w parent- child
	List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	 
	 for (WebElement option: options)
	 {
		  if (option.getText().equalsIgnoreCase("India"))
		  {
			  option.click();
			  break;
		  }
		 
	 }
	 
	 
	
	
	}
	}
