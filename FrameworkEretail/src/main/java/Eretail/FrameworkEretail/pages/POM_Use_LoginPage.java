package Eretail.FrameworkEretail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Eretail.FrameworkEretail.base.CommonToAllPages;
import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.utils.PropertyReader;

public class POM_Use_LoginPage extends CommonToAllPages {

	 WebDriver driver = DriverInitiate.getDriver();

	private By enterOrgId = By.id("userOrgId");
	private By enterUsername = By.id("userName");
	private By enterPassword = By.id("password");
	private By clickLoginButton = By.name("Login");
	private By clickResetButton = By.xpath("//input[@value='Reset']");

	public void enterOrgId() {
		implicitWaitPageLoad();
		// driver.findElement(By.id("userOrgId")).sendKeys("BLDRT");
		driver.findElement(enterOrgId).sendKeys(PropertyReader.readKey("orgId"));
	}

	public void enterLoginId() {
		driver.findElement(enterUsername).sendKeys(PropertyReader.readKey("loginId"));
	}

	public void enterPassword() {
		driver.findElement(enterPassword).sendKeys(PropertyReader.readKey("password"));
	}

	public void enterLoginButton() {
		driver.findElement(clickLoginButton).click();
		acceptAlert();
	}

	public void enterResetButton() {
		driver.findElement(clickResetButton).click();
	}
}
