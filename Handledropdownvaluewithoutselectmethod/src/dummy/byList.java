package dummy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class byList {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select1")));
       // dropdown.click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//System.out.println("clicked1");
		List<WebElement> allOptions = driver.findElements(By.cssSelector("select1 option"));
		String option = "Highest to lowest";
		for (int i = 0; i < allOptions.size(); i++) {
			if (allOptions.get(i).getText().contains(option)) {
				allOptions.get(i).click();
				System.out.println("clicked2");
				break;
			}
		}
	}

}
