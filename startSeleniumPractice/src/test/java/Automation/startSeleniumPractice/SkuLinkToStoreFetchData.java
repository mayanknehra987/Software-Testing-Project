package Automation.startSeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class SkuLinkToStoreFetchData {
	public void handleFrame(String frameXpath) {
		driver.switchTo().frame(driver.findElement(By.xpath(frameXpath)));
	}

	public void acceptAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert appeared: " + alert.getText());
			alert.accept();
		} catch (TimeoutException | NoAlertPresentException e) {
			System.out.println("No alert appeared. Continuing without accepting alert.");
		} catch (Exception e) {
			System.out.println("Unexpected error while handling alert: " + e.getMessage());
		}
	}

	public void implicitWaitPageLoad() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	WebDriver driver;
	@Test
	public void search() throws InterruptedException {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://preprod.vineretail.com/eRetailWeb/eRetailLogin.action?popup=true");
		driver.manage().window().maximize();
		driver.findElement(By.id("userOrgId")).sendKeys("VSPL");
		driver.findElement(By.id("userName")).sendKeys("himanshu" + "");
		driver.findElement(By.id("password")).sendKeys("sa@321");
		driver.findElement(By.name("Login")).click();
		acceptAlert();
		implicitWaitPageLoad();
		Actions action = new Actions(driver);
		implicitWaitPageLoad();
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[2]")));
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SKU Master')]")));
		action.click().build().perform();
		handleFrame("//iframe[@id='SKUMaster_IFrame']");
		driver.findElement(By.xpath("//label[normalize-space()='Add New']")).click();
		driver.switchTo().defaultContent();
		handleFrame("//iframe[@id='SKUCreateEdit_IFrame']");
		WebElement element = driver.findElement(By.xpath("//select[@id='SKUClassification']"));
		Select s = new Select(element);
		s.selectByIndex(5);
		driver.findElement(By.xpath("//i[@class='fa fa-check']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@name='linkToStoreText']/parent::div/span/button")));
		js.executeScript("arguments[0].scrollIntoView();", element1);
		element1.click();
		implicitWaitPageLoad();
		handleFrame("//iframe[@id='linkToStoreDialogIFrame']");
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='allLinkToStoreGrid']/tbody/tr"));
		int index = 0;
		for (WebElement checkbox : ele) {
			if (index == 0) {
				index++;
				continue; // skip the first row
			}
			String name = checkbox.getText();
			System.out.println("Checkbox text: " + name);
			index++;
		}
		driver.findElement(By.xpath("//input[@id='cb_allLinkToStoreGrid']")).click();
		driver.findElement(By.xpath("//button[@title='Add']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-warning btn-md']/i")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.name("skuMaintDTO.displaySku")).sendKeys("12qwe321");
	}
}
