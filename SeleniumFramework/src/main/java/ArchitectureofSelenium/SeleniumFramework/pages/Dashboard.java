package ArchitectureofSelenium.SeleniumFramework.pages;

import org.openqa.selenium.By;

import ArchitectureofSelenium.SeleniumFramework.base.CommonToAllPages;

public class Dashboard extends CommonToAllPages {

	public Dashboard(){
		
	}
	
	private By userNameOnDashBoard = By.cssSelector("[data-qa='lufexuloga']");
	
	public String loggedInUsername(){
		presenceOfElement(userNameOnDashBoard);
		return getElement(userNameOnDashBoard).getText();
		
	}
}
