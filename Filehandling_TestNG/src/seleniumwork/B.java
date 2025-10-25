package seleniumwork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B {
WebDriver driver;
	
	@BeforeClass
	public void createDriver(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dynamic.vineretail.com/eRetailWeb/eRetailLogin.action?popup=true");	
	}
   @Test
   public void TC001() throws ElementNotInteractableException {
	   A obj = new A();
	  // obj.setDriver(driver);
	String expectedTitle = "Welcome to eRetail";
	String pageTitle=driver.getTitle();
	if(pageTitle.equals(expectedTitle)){
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.id("userOrgId")).sendKeys("vspl");
	driver.findElement(By.id("userName")).sendKeys("sa");
	driver.findElement(By.id("password")).sendKeys("sa@321");
	driver.findElement(By.name("Login")).click();
	try {
		driver.wait(1000);
	} catch (Exception e) {
		obj.handleFrame2("//iframe[@id='childIFrame']",driver);
		driver.findElement(By.xpath("//*[@id='signin-button']")).click();
	}
	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
	driver.switchTo().window(windowHandles.get(1));
	driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("mayank.nehra@vinculumgroup.com");
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Welcome!@#$1234567890");
	driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/span")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.switchTo().window(windowHandles.get(0));
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[2]")));
	action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SKU Master')]")));
	action.click().build().perform();
	obj.handleFrame2("//iframe[@id='SKUMaster_IFrame']", driver);
	driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();

//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.cssSelector("select[name='sku.status']"));
	js.executeScript("arguments[0].scrollIntoView();", element);
	Select s = new Select(element);
	s.selectByIndex(3);
	System.out.println("done");
}
	else{
		System.out.println("Page does not contaion text");
	}
}
	@AfterMethod
	public void browserClose(){
		System.out.println("12345678");
	}

}
