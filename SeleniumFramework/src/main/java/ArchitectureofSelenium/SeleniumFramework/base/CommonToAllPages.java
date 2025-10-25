package ArchitectureofSelenium.SeleniumFramework.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ArchitectureofSelenium.SeleniumFramework.drivers.DriverManager;
import ArchitectureofSelenium.SeleniumFramework.utils.PropertyReader;

public class CommonToAllPages {

	public CommonToAllPages() {

	}
	public void openVWOLoginURL() {
		DriverManager.getDriver().get(PropertyReader.readKey("url"));
	}
	public void openVWOLoginURL(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	public void openVWOLoginURL(WebElement by) {
		by.click();
	}
	public void enterInput(By by, String key) {
		DriverManager.getDriver().findElement(by).sendKeys(key);
	}
	public void enterInput(WebElement element, String key) {
		element.sendKeys(key);
	}
	public WebElement presenceOfElement(By elementLocator) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
	}

	public WebElement visibilityOfElement(By elementLocator) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	public WebElement getElement(By key) {
		return DriverManager.getDriver().findElement(key);
	}
}
