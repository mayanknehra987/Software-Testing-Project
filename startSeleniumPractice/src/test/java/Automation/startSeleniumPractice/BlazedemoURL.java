package Automation.startSeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.qameta.allure;
import io.qameta.allure.Description;

public class BlazedemoURL {
	WebDriver driver;

	@BeforeMethod
	public void browserStart() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Description("KHDJKHJKHDJK")
	@Test
	public void Test1() {
		Select option1 = new Select(driver.findElement(By.cssSelector("select[name='fromPort']")));
		option1.selectByVisibleText("Boston");
		Select option2 = new Select(driver.findElement(By.cssSelector("select[name='toPort']")));
		option2.selectByVisibleText("Berlin");
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		List<WebElement> option = driver.findElements(By.xpath("//table//input[@value='Choose This Flight']"));
		List<WebElement> option3 = driver.findElements(By.xpath("//tbody//td[6]"));
		System.out.println(option3.size());
		String []arr= new String[option3.size()];
		int i=0;
			for (WebElement webElement : option3){
			String name = webElement.getText();
			arr[i]=name;	
			System.out.println(arr[i]);
			i++;
		}
		
		for (int j = 0; j <arr.length-1; j++) {
			if (option3.get(j).getText().equalsIgnoreCase(arr[3])) {
				option.get(j).click();
				break;
			}
		}
		driver.findElement(By.id("inputName")).sendKeys("a");
		driver.findElement(By.cssSelector("input[id='address']")).sendKeys("b");
		driver.findElement(By.cssSelector("input[id='city']")).sendKeys("c");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(By.cssSelector("input[id='state']")).sendKeys("d");
		driver.findElement(By.cssSelector("input[id='zipCode']")).sendKeys("201204");
		Select option4 = new Select(driver.findElement(By.cssSelector("select[name='cardType']")));
		option4.selectByVisibleText("Diner's Club");
		driver.findElement(By.cssSelector("input[id='creditCardNumber']")).sendKeys("201204201204");
		action.sendKeys(Keys.PAGE_DOWN).perform();
		WebElement element = driver.findElement(By.cssSelector("input[id='creditCardMonth']"));
		element.clear();
		driver.findElement(By.cssSelector("input[id='creditCardMonth']")).sendKeys("2");
		WebElement element1 = driver.findElement(By.cssSelector("input[id='creditCardYear']"));
		element1.clear();
		driver.findElement(By.cssSelector("input[id='creditCardYear']")).sendKeys("2024");
		driver.findElement(By.cssSelector("input[id='nameOnCard']")).sendKeys("mayank");
		WebElement element2 = driver.findElement(By.cssSelector("input[id='rememberMe']"));
		action.click(element2).build().perform();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}
