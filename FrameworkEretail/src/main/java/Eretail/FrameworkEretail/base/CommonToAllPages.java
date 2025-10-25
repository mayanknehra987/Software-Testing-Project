package Eretail.FrameworkEretail.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.utils.DatabaseConnection;
import io.netty.handler.timeout.TimeoutException;

public class CommonToAllPages {

	public void implicitWaitPageLoad() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		DriverInitiate.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	public void acceptAlert() {
		try {
	        WebDriverWait wait = new WebDriverWait(DriverInitiate.getDriver(), Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = DriverInitiate.getDriver().switchTo().alert();
	        System.out.println("Alert appeared: " + alert.getText());
	        alert.accept();
	    } catch (TimeoutException | NoAlertPresentException e) {
	        System.out.println("No alert appeared. Continuing without accepting alert.");
	    } catch (Exception e) {
	        System.out.println("Unexpected error while handling alert: " + e.getMessage());
	    }
	}

	public void dashboardFrame(WebElement frame) {
		DriverInitiate.getDriver().switchTo().frame(frame);
	}

	public static void verifyPageTitle() {
		String expectedTitle1 = "Welcome to eRetail";
		String pageTitle1 = DriverInitiate.getDriver().getTitle();
		try {
			if (pageTitle1.equalsIgnoreCase(expectedTitle1)) {
				DriverInitiate.getDriver().manage().window().maximize();
			}
		} catch (Exception e) {
			System.out.println("Login verification failed: " + e.getMessage());
		}
	}
	public static void orderCreateEditFrame(WebElement ordercreateframe, WebDriver driver) {
		driver.switchTo().frame(ordercreateframe);
	}
	public void switchToDefaultContent() {
		DriverInitiate.getDriver().switchTo().parentFrame();
	}
	public void switchToparentFrame() {
		DriverInitiate.getDriver().switchTo().parentFrame();
	}
	public void switchToQuickShipFrame(WebElement quickshipframe) {
		DriverInitiate.getDriver().switchTo().frame(quickshipframe);
	}
	public void moveToElement(WebElement movetolement, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(movetolement);
		// action.click().build().perform();
		action.doubleClick().build().perform();
	}
	public void pressEnter(WebElement locator) {
		WebElement element = (locator);
		element.sendKeys(Keys.ENTER);
	}
	public WebElement visibilityOfElement(WebElement elementLocation) {
        return new WebDriverWait(DriverInitiate.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(elementLocation));
    }
	protected Integer executeQueryAndFetchIntValue(String query) {
        Integer result = null;
        try (
                PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

               if (resultSet.next()) {
                   int value = resultSet.getInt(1);
                   if (!resultSet.wasNull()) {
                       result = value;
                   }
               }
           } catch (SQLException e) {
               System.out.println("SQL Exception: " + e.getMessage());
           }
        return result;
    }
}
