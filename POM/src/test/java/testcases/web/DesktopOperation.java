package testcases.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.web.DriverInitiate;

public class DesktopOperation extends DriverInitiate {

	@Test
	public void desktopOperation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Desktops']")));
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Desktops']"))).perform();
		// act.moveToElement(driver.findElement(By.xpath("//a[text()='Mac (1)']"))).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[text()='Mac (1)']"))).keyUp(Keys.CONTROL).perform();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}
}
