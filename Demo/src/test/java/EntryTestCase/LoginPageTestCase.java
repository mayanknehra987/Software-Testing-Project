package EntryTestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import Entry.HomePage;
import Entry.LoginPage;

public class LoginPageTestCase extends Base {

	
	LoginPage loginPage;
	HomePage homePage;
	LoginPageTestCase(){
		super();// it will call parent class constructor and super keyword always first statement after the constructor.
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginPage= new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitletest() {
	String title= loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Welcome to eRetail");
		
	}
	@Test(priority = 2)
	public void eRetailLogoImageTest() {
	boolean flag=loginPage.validateEretailImage();
	Assert.assertTrue(flag);
	
	 
	}
	@Test(priority = 3)
	public void loginTest() {
	homePage=loginPage.login(prop.getProperty("userOrgId"), prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
	
}
