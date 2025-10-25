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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clickonflipkartelement {
	ChromeDriver driver;
	

	@BeforeMethod
	public void browserStart() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void Test1() {
		// driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("i
		// phone");
		// driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("i
		// phone");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.findElement(By.cssSelector("img[title='Flipkart']")).click();
		Actions action = new Actions(driver);
		try {
			// action.moveToElement(driver.findElement(By.xpath("//div[text()='i
			// phone 16 pro max']"))).build().perform();
			action.moveToElement(driver.findElement(By.cssSelector("span._30XB9F[role='button']"))).build().perform();
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='Pke_EE']"))).click();
			action.keyDown(Keys.SHIFT).sendKeys("iphone").keyUp(Keys.SHIFT).build().perform();
			//List<WebElement> options = driver.findElements(By.xpath("//li[@class='_3D0G9a']//div//following-sibling::div//div[1]"));
			//List<WebElement> options = driver.findElements(By.xpath("//form[@action='/search']//div//div//following-sibling::div[text()]"));
			//List<WebElement> options = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc']//li//following-sibling::div[text()]"));
			List<WebElement> options = driver.findElements(By.xpath("//li[@class='_3D0G9a']//following-sibling::div[text()]"));
			System.out.println(options.size());
		    for (WebElement webElement : options) {
	            String name = webElement.getText();
	            System.out.println(name);
	        }
	    
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("iphone 13")) {
					option.click();
					break;
				}
			}
//			driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("i phone");
//			action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),' 16pro max')]"))).build()
//					.perform();
		}

		// //WebDriverWait wait = new WebDriverWait(driver,
		// Duration.ofSeconds(10));
		// // List<WebElement> suggestions = (List<WebElement>)
		// driver.findElement(By.xpath("//*[@class='G43f7e']"));
		// //List<WebElement> suggestions =
		// driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		// //List<WebElement> suggestions =
		// driver.findElements(By.xpath("//ul[@class='_1sFryS
		// _2x2Mmc']//li//span"));
		//
		// try {
		// WebElement closePopup =
		// driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
		// closePopup.click();
		// } catch (Exception e) {
		// System.out.println("Popup not present, continuing...");
		// }
		//
		// // Find the search box and input the search term "iPhone"
		// WebElement searchBox =
		// driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		// searchBox.sendKeys("i Phone");
		//
		// // Explicitly wait for the suggestions to appear
		// WebDriverWait wait = new WebDriverWait(driver,
		// Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='_1sFryS
		// _2x2Mmc']//li")));
		//
		// // Get the list of suggestions using the correct XPath
		// List<WebElement> suggestions =
		// driver.findElements(By.xpath("//ul[@class='_1sFryS
		// _2x2Mmc']//li//span"));
		//
		// boolean found = false;
		// for (WebElement suggestion : suggestions) {
		// System.out.println("Suggestion found: " + suggestion.getText());
		//
		// // Look for 'i Phone 16'
		// if (suggestion.getText().contains("i Phone 16")) {
		// System.out.println("Found 'i Phone 16' in suggestions. Trying to
		// click...");
		//
		// // Scroll to the element using JavaScript
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);", suggestion);
		//
		// // Check if the element is displayed and enabled
		// if (suggestion.isDisplayed() && suggestion.isEnabled()) {
		// try {
		// System.out.println("Element is visible and enabled.");
		//
		// // Try normal click first
		// suggestion.click();
		// System.out.println("Normal click worked.");
		// found = true;
		// break;
		// } catch (Exception e) {
		// System.out.println("Normal click failed. Trying JavaScript
		// click...");
		//
		// // Force click using JavaScript if normal click fails
		// js.executeScript("arguments[0].click();", suggestion);
		// System.out.println("JavaScript click worked.");
		// found = true;
		// break;
		// }
		// } else {
		// System.out.println("Element is not clickable (not displayed or
		// enabled).");
		// }
		// }
		// }
		//
		// if (!found) {
		// System.out.println("'i Phone 16' not found in suggestions.");
		// }
		//
		// // Optionally, wait for the page to load after clicking
		// wait.until(ExpectedConditions.titleContains("i Phone 16"));
		//
		// }
	}
}
