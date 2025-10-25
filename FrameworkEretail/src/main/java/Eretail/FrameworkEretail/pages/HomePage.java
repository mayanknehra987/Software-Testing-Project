package Eretail.FrameworkEretail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Eretail.FrameworkEretail.base.CommonToAllPages;

public class HomePage extends CommonToAllPages {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Dashboard_IFrame") WebElement enterIFrame;
	@FindBy(xpath="//*[@id=\"mainBody\"]/table/tbody/tr/td/font") WebElement locateElement;
	
	public String getWelcomeMessage(){
		try{
		//switch to ifarme where contain welcome message
		WebElement iframe = enterIFrame;
		driver.switchTo().frame(iframe);
		// these line called by method form common to all page
		/*WebElement iframe = enterIFrame;
		dashboardFrame(iframe);*/
		WebElement welcomeElement = locateElement;
		String messageText = welcomeElement.getText();
		//switch to back main content(frame)
		driver.switchTo().parentFrame();
		System.out.println("Login Successful! Message: " + messageText);
		return messageText;
		
		}catch(Exception e){
			System.out.println("Login failed: " + e.getMessage());
            return "Login Failed";
		}
	}
	

}
