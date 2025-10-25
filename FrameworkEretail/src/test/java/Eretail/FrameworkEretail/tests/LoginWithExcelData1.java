package Eretail.FrameworkEretail.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.pages.LoginWithExcelData;
import Eretail.FrameworkEretail.utils.ExcelUtils;

public class LoginWithExcelData1 extends DriverInitiate{
	Object[][] allData;
	@DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/configfile/Testdata1.xlsx";
        allData = ExcelUtils.readExcelData(filePath, "Sheet1");
        return allData;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String orgid, String username, String password) {
        System.out.println("Testing login with Orgid: "+ orgid +" username: " + username + " and password: " + password);
        LoginWithExcelData loginPage = PageFactory.initElements(driver, LoginWithExcelData.class);
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
