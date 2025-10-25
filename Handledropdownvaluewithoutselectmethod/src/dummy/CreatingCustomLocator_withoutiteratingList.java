package dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingCustomLocator_withoutiteratingList {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		driver.findElement(By.xpath("//select")).click();
		String option = "Highest to lowest";
		WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));
		dropdown.click();
		System.out.println("clicked");

		}
		
	}
	


