package Eretail.FrameworkEretail.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.listners.RetryAnalyser;
import Eretail.FrameworkEretail.pages.HomePage;
import Eretail.FrameworkEretail.pages.POM_Use_LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

@Test(retryAnalyzer = RetryAnalyser.class)
//@Listeners(Eretail.FrameworkEretail.listners.RetryListeners.class)
public class Pom_Retry_Analyser extends DriverInitiate{
	private static final Logger logger= LogManager.getLogger(EretailLogin.class);
	@Owner("Mayank Nehra")
	@Description("Verify loging successfully")
	@Test
	public void TC001(){
		POM_Use_LoginPage pomlgn = new  POM_Use_LoginPage();
		pomlgn.enterOrgId();
		pomlgn.enterLoginId();
		pomlgn.enterPassword();
		pomlgn.enterLoginButton();
//		HomePage homepage = new HomePage(driver);
//		String actuelmessage = homepage.getWelcomeMessage();
//		String expectedmessage = "Welcome to eRetail1";
	//	Assert.assertEquals(actuelmessage, expectedmessage);
		//Assert.assertTrue(driver.getTitle().matches("Welcome to eRetail1"),"login success");
		Assert.assertEquals(driver.getTitle(),"Welcome to eRetail", "login success");
	}
	@Test
	public void TC002(){
		System.out.println("hello");
		logger.info("Starting the Testcases");
		HomePage homepage = new HomePage(driver);
		String actuelmessage = homepage.getWelcomeMessage();
		String expectedmessage = "Welcome to eRetail";
		logger.info("Varifying The title of page" + actuelmessage);
		assertThat(actuelmessage).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(actuelmessage, expectedmessage);
	}
	

}
