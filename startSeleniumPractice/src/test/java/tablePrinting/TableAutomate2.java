package tablePrinting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

public class TableAutomate2 {
	WebDriver driver;

	@BeforeMethod
	public void Base() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
	}

	@Description("Verify the table content is print")
	@Test
	public void taseCase() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Hacker@4321");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h6[text()='PIM']")));
		String ele = driver.findElement(By.xpath("//h6[text()='PIM']")).getText();
		Assert.assertEquals(ele, "PIM");
//		WebElement element = driver.findElement(By.xpath("//table[@summary ='Sample Table']/tbody"));
//		List<WebElement> row_data = element.findElements(By.tagName("tr"));
//		for (int i = 0; i < row_data.size(); i++) {
//			List<WebElement> col_data = row_data.get(i).findElements(By.tagName("td"));
//			for (WebElement c: col_data) {
//				//DO some following, preceding-sibling data print
//				System.out.println(c.getText());
//			}
//		}
	}

	@AfterMethod
	public void Closing() {

	}

}
