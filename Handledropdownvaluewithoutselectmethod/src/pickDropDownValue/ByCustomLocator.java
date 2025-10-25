package pickDropDownValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ByCustomLocator {
	public static void main(String[] args) throws ElementNotInteractableException {
		String expectedTitle = "Welcome to eRetail";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dynamic.vineretail.com/eRetailWeb/eRetailLogin.action?popup=true");
		driver.manage().window().maximize();
		String pageTitle=driver.getTitle();
		if(pageTitle.equals(expectedTitle)){
		driver.findElement(By.id("userOrgId")).sendKeys("vspl");
		driver.findElement(By.id("userName")).sendKeys("sa");
		driver.findElement(By.id("password")).sendKeys("sa@321");
		driver.findElement(By.name("Login")).click();

		try {
			driver.wait(1000);
		} catch (Exception e) {
			driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='childIFrame']"));
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
		action.moveToElement(driver.findElementByXPath("//ul[@class='sidebar-menu']/li[4]"));
		action.moveToElement(driver.findElementByXPath("//a[text()='Order Enquiry']"));
		action.click().build().perform();
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='OrderEnquiry_IFrame']"));
	//	driver.findElement(By.xpath("//*[@title='Advance Search']")).click();
		driver.findElement(By.cssSelector("button[title='Advance Search']")).click();
	//	driver.findElement(By.xpath("//button[contains(@class, 'btn-default') and @title='Advance Search']")).click();
		String option = "Self Ship";
		WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));
		dropdown.click();
		System.out.println("clicked");
		}

}

}
