package tablePrinting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

public class TableAutomate {
	WebDriver driver;

	@BeforeMethod
	public void Base() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://awesomeqa.com/webtable.html");
		//driver.get("https://awesomeqa.com/webtable1.html");
	}

	@Description("Verify the table content is print")
	@Test
	public void taseCase() {
		int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
		System.out.println(row);
		System.out.println(col);

		String first = "//table[@id='customers']/tbody/tr[";
		String second = "]/td[";
		String third = "]";
		for (int i = 2; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				String xpath = first + i + second + j + third;
				String data = driver.findElement(By.xpath(xpath)).getText();
				System.out.println(data);
				if (data.contains("Helen Bennett")) {
					String company_xpath = xpath + "/following-sibling::td";
					String country_xpath = xpath + "/preceding-sibling::td";

					String compnay_data = driver.findElement(By.xpath(company_xpath)).getText();
					String country_data = driver.findElement(By.xpath(country_xpath)).getText();

					System.out.println("Company for Helen Bennett is :" + compnay_data);
					System.out.println("Country for Helen Bennett is :" + country_data);

				}
			}
		}
	}

	@AfterMethod
	public void Closing() {

	}

}
