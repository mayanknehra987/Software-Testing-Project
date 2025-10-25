package ArchitectureofSelenium.SeleniumFramework.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ArchitectureofSelenium.SeleniumFramework.base.CommonToAllTest;
import ArchitectureofSelenium.SeleniumFramework.drivers.DriverManager;
import ArchitectureofSelenium.SeleniumFramework.listners.RetryAnalzser;
import ArchitectureofSelenium.SeleniumFramework.pages.Login;
import ArchitectureofSelenium.SeleniumFramework.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import static org.assertj.core.api.Assertions.*;

import java.util.logging.LogManager;

@Test(retryAnalyzer= RetryAnalzser.class)
public class VwoTest extends CommonToAllTest{

	//private static final Logger logger = LogManager.getLogger(VwoTest.class);

	@Owner("Mayank Nehra")
	@Description("Verify that the Token is created")
	@Test(priority=1)
	public void testLoginnegativeVWO(){
	//	logger.info("Starting the Testcases");
		Login lgn = new Login(DriverManager.getDriver());
	//	logger.info("Opening The URL");
		String error_msg_text = lgn.loginToInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
	//	logger.info("Varifying The Username in Dashboard" + error_msg_text);
		assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
		Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
		
		//adding extra word for faling testcases
		//Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));
	}
	
}
