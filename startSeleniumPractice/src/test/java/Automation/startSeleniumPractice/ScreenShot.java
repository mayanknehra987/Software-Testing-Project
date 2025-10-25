package Automation.startSeleniumPractice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) {
//		WebDriverManager.chromedriver().clearDriverCache().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://blazedemo.com/");
//		Select s = new Select(driver.findElement(By.cssSelector("select[name ='fromPort']")));
//		s.selectByVisibleText("Boston");
//		//pariall screenshot
//		WebElement element = driver.findElement(By.cssSelector("select[name ='fromPort']"));
//		File dest= new File("C:\\Users\\mayank.nehra\\Pictures\\Screenshots\\single_2.png");
//		File src= element.getScreenshotAs(OutputType.FILE);
//		src.renameTo(dest);
		
		//Fullpage screeshot
		//File dest= new File("C:\\Users\\mayank.nehra\\Pictures\\Screenshots\\single_2.png");
		//TakesScreenshot tc= (TakesScreenshot) driver;
		//File src= tc.getScreenshotAs(OutputType.FILE);
		//src.renameTo(dest);
	
		String a = "Hello";
		for(int i=a.length()-1;i>=0;i--){
			System.out.print(a.charAt(i));
		}
	}
}
