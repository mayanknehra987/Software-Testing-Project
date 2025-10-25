package ArchitectureofSelenium.SeleniumFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ArchitectureofSelenium.SeleniumFramework.base.CommonToAllPages;
import ArchitectureofSelenium.SeleniumFramework.utils.PropertyReader;

public class Login extends CommonToAllPages{
	// page locators
	// page action
	WebDriver driver;
	public Login(WebDriver driver){
		this.driver = driver;
	}
	
	private By username = By.id("login-username");
	private By password = By.id("login-password");
	private By signButton = By.id("js-login-btn");
	private By error_message = By.id("js-notificaton-box-msg");
	
	public String loginToInvalidCreds(String name,String pass){
		driver.get(PropertyReader.readKey("url"));
		driver.findElement(username).sendKeys(name);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signButton).click();
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		}
		WebElement error_msg = driver.findElement(By.className(".notification-box-description"));
		String error_msg_text = error_msg.getText();
		String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
		return error_msg_text;
		
		
	}

}
