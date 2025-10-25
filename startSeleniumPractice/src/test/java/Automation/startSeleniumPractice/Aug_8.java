package Automation.startSeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aug_8 {
	ChromeDriver driver;

	@BeforeMethod
	public void browserStart() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void TC001() throws InterruptedException {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Automation Testing Practice")) {
			driver.findElement(By.id("name")).sendKeys("mayank");
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("phone")).sendKeys("8877887788");
			driver.findElement(By.id("textarea")).sendKeys("Modinagar");
			WebElement element = driver.findElement(By.id("male"));
			System.out.println(element);
			if (element.isEnabled() && driver.findElement(By.id("female")).isEnabled()) {
				try {
					Assert.assertEquals(element.getAttribute("id"), "male"); // Corrected
																				// assert
																				// statement
					driver.findElement(By.id("male")).click();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			driver.findElement(By.cssSelector("input[id='saturday']")).click();
			js.executeScript("window.scrollBy(0,350)", "");
			Select select = new Select(driver.findElement(By.id("country")));
			select.selectByValue("japan");
			Select select1 = new Select(driver.findElement(By.id("colors")));
			select1.selectByValue("white");
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.id("datepicker"))).perform();
			action.sendKeys(driver.findElement(By.cssSelector("a[title='Prev']"))).perform();
			action.sendKeys(driver.findElement(By.xpath("//td[4]/a[text()='14']"))).perform();
			action.sendKeys(Keys.PAGE_DOWN).perform();
			WebElement element1 = driver.findElement(By.cssSelector("div#HTML8"));
			js.executeScript("arguments[0].scrollIntoView();", element1);
			List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for (WebElement check : checkboxList) {

				if (!check.isSelected()) {
					check.click();
				}
			}
			driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='2']")).click();
			List<WebElement> checkboxList1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for (WebElement check1 : checkboxList1) {

				if (!check1.isSelected()) {
					check1.click();
				}
			}
			driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='3']")).click();
			List<WebElement> checkboxList2 = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for (WebElement check2 : checkboxList2) {

				if (!check2.isSelected()) {
					check2.click();
				}
			}
			driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='4']")).click();
			List<WebElement> checkboxList3 = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for (WebElement check3 : checkboxList3) {

				if (!check3.isSelected()) {
					check3.click();
				}
			}
			// driver.findElement(By.xpath("//td[text()='$10.99']//following-sibling::td/input[@type='checkbox']")).click();
			// driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='2']")).click();
			// driver.findElement(By.xpath("//td[text()='$15.99']//following-sibling::td/input[@type='checkbox']")).click();
			// driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='3']")).click();
			// driver.findElement(By.xpath("//td[text()='$19.99']//following-sibling::td/input[@type='checkbox']")).click();
			// driver.findElement(By.xpath("//ul[@id='pagination']//following-sibling::li//a[text()='4']")).click();
			// driver.findElement(By.xpath("//td[text()='$13.99']//following-sibling::td/input[@type='checkbox']")).click();
			WebElement element2 = driver.findElement(By.xpath("//h2[text()='Tabs']"));
			js.executeScript("arguments[0].scrollIntoView();", element2);
			driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("h");
			driver.findElement(By.cssSelector("input.wikipedia-search-button[type=submit]")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			List<WebElement> links = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("wikipedia-search-result-link")));
			System.out.println("The number of links is" + links.size());
			driver.findElement(By.cssSelector("div[dir='ltr']")).click();
			driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-more a")).click();
		}

	}

	@AfterMethod
	public void browserClose() {
		// driver.close();

	}

}
