package tablePrinting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

public class TableAutomate1 {
	WebDriver driver;

	@BeforeMethod
	public void Base() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://awesomeqa.com/webtable1.html");
	}

	@Description("Verify the table content is print")
	@Test
	public void taseCase() {
		WebElement element = driver.findElement(By.xpath("//table[@summary ='Sample Table']/tbody"));

		List<WebElement> row_data = element.findElements(By.tagName("tr"));
		for (int i = 0; i < row_data.size(); i++) {
			List<WebElement> col_data = row_data.get(i).findElements(By.tagName("td"));
			for (WebElement c: col_data) {
				//DO some following, preceding-sibling data print
				System.out.println(c.getText());
			}
		}
	}

	@AfterMethod
	public void Closing() {

	}

}
