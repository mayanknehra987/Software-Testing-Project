package Eretail.FrameworkEretail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Eretail.FrameworkEretail.base.CommonToAllPages;
import Eretail.FrameworkEretail.utils.PropertyReader;

public class LoginPage extends CommonToAllPages{
	// now we are using page factory concept for managing locator and passing driver in page
	@FindBy(id="userOrgId") WebElement enterOrgId;
	@FindBy(id="userName") WebElement enterUsername;
	@FindBy(id="password") WebElement enterPassword;
	@FindBy(name="Login") WebElement clickLoginButton;
	@FindBy(xpath="//input[@value='Reset']") WebElement clickResetButton;
	
	public void enterOrgId() {
		implicitWaitPageLoad();
		//driver.findElement(By.id("userOrgId")).sendKeys("BLDRT");
		enterOrgId.sendKeys(PropertyReader.readKey("orgId"));
	}
	public void enterLoginId() {
		enterUsername.sendKeys(PropertyReader.readKey("loginId"));
	}
	public void enterPassword() {
		enterPassword.sendKeys(PropertyReader.readKey("password"));
	}
	public void enterLoginButton() {
		clickLoginButton.click();
		acceptAlert();
	}
	public void enterResetButton() {
		clickResetButton.click();
	}
}
