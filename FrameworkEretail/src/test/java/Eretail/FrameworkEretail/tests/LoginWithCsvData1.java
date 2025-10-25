package Eretail.FrameworkEretail.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.pages.LoginWithCsvData;
import Eretail.FrameworkEretail.pages.LoginWithExcelData;
import Eretail.FrameworkEretail.utils.CsvUtils;
import Eretail.FrameworkEretail.utils.ExcelUtils;

public class LoginWithCsvData1 extends DriverInitiate{
	Object[][] allData;
	@DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
		allData =  CsvUtils.readCSVData(System.getProperty("user.dir")+ "/configfile/CsvTestData.csv"); // provide full path if needed
		return allData;
    }
    
    @Test(dataProvider = "loginData")
    public void testLogin(String orgid, String username, String password) {
        System.out.println("Testing login with Orgid: "+ orgid +" username: " + username + " and password: " + password);
        LoginWithCsvData loginPage = PageFactory.initElements(driver, LoginWithCsvData.class);
        loginPage.enterOrgId(orgid);
        loginPage.enterLoginId(username);
        loginPage.enterPassword(password);
        loginPage.enterLoginButton();
     // Only sign out if not the last set of credentials
        int currentIndex = getCurrentTestIndex(orgid, username, password);
        if (currentIndex < allData.length - 1) {
            loginPage.clickLogoutButton();
            loginPage.clickSignoutButton();
        }
    }
    private int getCurrentTestIndex(String orgid, String username, String password) {
        for (int i = 0; i < allData.length; i++) {
            if (allData[i][0].equals(orgid) &&
                allData[i][1].equals(username) &&
                allData[i][2].equals(password)) {
                return i;
            }
        }
        return -1; // fallback
    }

}
