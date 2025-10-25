package Automation.startSeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pickvaluesuggestionwithaction {
	// ChromeDriver driver;
	WebDriver driver;

	@BeforeMethod
	public void browserStart() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	public void TC001() throws InterruptedException {
		Actions action = new Actions(driver);
		//action.sendKeys(driver.findElement(By.cssSelector("textarea.gLFyf[aria-label='Search']"))).perform();
		action.sendKeys(driver.findElement(By.name("q"))).perform();
		action.keyDown(Keys.SHIFT).sendKeys("hdfc").keyUp(Keys.SHIFT).build().perform();
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("HDFC Bank")) {
				option.click();
				break;
			}
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		action.keyDown(Keys.ARROW_DOWN)
//				.sendKeys(driver.findElement(By.cssSelector("li.sbct.PZPZlf.sbre[data-entityname='HDFC Bank']")))
//				.build().perform();
//		action.keyUp(Keys.ARROW_DOWN);

	}

	@AfterMethod
	public void browserClose() {
		// driver.close();

	}

}
