package Eretail.FrameworkEretail.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

public class VerifyHomePage extends DriverInitiate {
	@Owner("Mayank Nehra")
	@Description("Verify Dashboard")	
	@Test
	public void TC001(){
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	String actuelmessage = homepage.getWelcomeMessage();
	String expectedmessage = "Welcome to eRetail";
	assertThat(actuelmessage).isNotBlank().isNotNull().isNotEmpty();
	Assert.assertEquals(actuelmessage, expectedmessage);
	}

}
