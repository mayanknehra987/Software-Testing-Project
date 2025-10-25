package Eretail.FrameworkEretail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Eretail.FrameworkEretail.base.CommonToAllPages;

public class LoginWithCsvData extends CommonToAllPages{
	// now we are using page factory concept for managing locator and passing driver in page
	@FindBy(id="userOrgId") WebElement enterOrgId;
	@FindBy(id="userName") WebElement enterUsername;
	@FindBy(id="password") WebElement enterPassword;
	@FindBy(name="Login") WebElement clickLoginButton;
	@FindBy(xpath="//li['dropdown. user user-menu']/a/img") WebElement clickLogoutButton;
	@FindBy(xpath="//div[@class='pull-right']/a") WebElement clickSignoutButton;
	@FindBy(xpath="//input[@value='Reset']") WebElement clickResetButton;
	
	
	public void enterOrgId(String orgid) {
		implicitWaitPageLoad();
		//driver.findElement(By.id("userOrgId")).sendKeys("BLDRT");
		enterOrgId.sendKeys(orgid);
	}
	public void enterLoginId(String username) {
		enterUsername.sendKeys(username);
	}
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	public void enterLoginButton() {
		clickLoginButton.click();
		acceptAlert();
	}
	public void clickLogoutButton() {
		clickLogoutButton.click();
	}
	public void clickSignoutButton() {
		clickSignoutButton.click();
		implicitWaitPageLoad();
	}
	public void enterResetButton() {
		clickResetButton.click();
	}
}
