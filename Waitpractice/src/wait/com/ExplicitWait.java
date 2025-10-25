package wait.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        // launch Chrome and redirect it to the URL
       	driver.get("https://demoqa.com/dynamic-properties");
       	
       	//Scroll to given element
       	JavascriptExecutor js = (JavascriptExecutor) driver;
       	WebElement element = driver.findElement(By.id("visibleAfter"));
    	js.executeScript("arguments[0].scrollIntoView();", element);
    	//js.executeScript("window.scrollBy(0,350)", "");
    	element.click();
    	WebDriverWait wait = new WebDriverWait (driver, 20);
    	try{
    		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Links']")));
    		//WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Links1']")));
        	//js.executeScript("arguments[0].scrollIntoView();", element1);
    		js.executeScript("window.scrollBy(0,-550)", "");
        	//element1.click();
    	}catch (Exception e) {
			System.out.println(e);
		}
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Links1']")));
    	//driver.findElement(By.xpath("//span[text()='Links']"));
    	System.out.println("A");
        //This element will appear after 5 sec
	//driver.findElement(By.id("visibleAfter")).click();
    	//Keyboard.keyDown(Keys.CONTROL).sendKeys("a").build().perform();   //  multiple operation perform through Action class
	}

}
