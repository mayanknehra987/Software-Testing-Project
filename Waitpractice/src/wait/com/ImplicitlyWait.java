package wait.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // launch Chrome and redirect it to the URL
       	driver.get("https://demoqa.com/dynamic-properties");
       	driver.manage().window().maximize();
       	
       	//Scroll to given element
       	JavascriptExecutor js = (JavascriptExecutor) driver;
       	WebElement element = driver.findElement(By.id("visibleAfter"));
    	js.executeScript("arguments[0].scrollIntoView();", element);
    	element.click();
    	try{
    		WebElement element1 = driver.findElement(By.xpath("//span[text()='Links']"));
        	js.executeScript("arguments[0].scrollIntoView();", element1);
        	element1.click();
    	}catch (Exception e) {
			System.out.println(e);
		}
    	
    	System.out.println("A");
        //This element will appear after 5 sec
	//driver.findElement(By.id("visibleAfter")).click();
	}

}
