package Eretail.FrameworkEretail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.pages.HomePage;
import Eretail.FrameworkEretail.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import static org.assertj.core.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EretailLogin extends DriverInitiate{
	
	private static final Logger logger= LogManager.getLogger(EretailLogin.class);
	@Owner("Mayank Nehra")
	@Description("Verify loging successfully")	
	@Test
	public void TC001() {
		//LoginPage login = new LoginPage(driver);
		logger.info("Starting the Testcases");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.enterOrgId();
		login.enterLoginId();
		login.enterPassword();
		login.enterLoginButton();
	}

	@Test
	public void TC002() {
		//HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		logger.info("Starting the Testcases");
		HomePage homepage = new HomePage(driver);
		String actuelmessage = homepage.getWelcomeMessage();
		String expectedmessage = "Welcome to eRetail";
		logger.info("Varifying The title of page" + actuelmessage);
		assertThat(actuelmessage).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(actuelmessage, expectedmessage);
	}

}
