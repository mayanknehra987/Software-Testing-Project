package pages.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.web.DriverInitiate;

public class SearchPage extends DriverInitiate {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public static void handleSelectClass(String selectPath, WebDriver driver, String name) {
		Select s = new Select(driver.findElement(By.cssSelector(selectPath)));
		s.selectByVisibleText(name);
	}

	public void search(String searchKey) {
		// driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("samsung");
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(searchKey);

	}

	public void searchButton() {
		driver.findElement(By.cssSelector("button[class='btn btn-light btn-lg']")).click();
	}

	public void selectCategory(String sort) {
		// Select s = new Select(driver.findElement(By.cssSelector("select[id='input-category']")));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='input-category']")));
		SearchPage.handleSelectClass("select[id='input-category']", driver, sort);
		// SearchPage.handleSelectClass(new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='input-category']"))),driver, sort);
	}

	public void clickSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='button-search']"))).click();
		// driver.findElement(By.cssSelector("button[id='button-search']")).click();
	}

	public void gridList() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("button[id='button-grid']")).click();
		driver.findElement(By.cssSelector("button[id='button-list']")).click();
		File f = new File("D:/pricelist.txt");
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,550)", "");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).perform();
//			WebElement element = driver.findElement(By.xpath("//div[@class='description']//div//span[1]"));
//			js.executeScript("arguments[0].scrollIntoView();", element);
			WebElement pickPriceValue = driver.findElement(By.xpath("//div[@class='description']//div//span[1]"));
			String price = pickPriceValue.getText();
			bw.write("Price: " + price);
			bw.newLine();
		} catch (Exception E) {
			E.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void selectSortBy(String sort) {
		// Select s = new Select(driver.findElement(By.cssSelector("select[id='input-sort']")));
		// s.selectByVisibleText("Name (A - Z)");
		SearchPage.handleSelectClass("select[id='input-sort']", driver, sort);
	}

	public void addToCart() {
		driver.findElement(By.xpath("//form[@data-oc-target='#header-cart']//div//button[1]")).click();
		try {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		     WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@class='alert alert-success alert-dismissible']")));
		     String Text = alert.getText();
		        System.out.println("Appeared with message: " + Text);
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public void addToWishList() throws InterruptedException {
		driver.findElement(By.xpath("//form[@data-oc-target='#header-cart']//div//button[2]")).click();
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement alert = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@class='alert alert-success alert-dismissible']")));
	        String Text = alert.getText();
	        System.out.println("Appeared with message: " + Text);
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public void compareThisProduct() {
		driver.findElement(By.xpath("//form[@data-oc-target='#header-cart']//div//button[3]")).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@class='alert alert-success alert-dismissible']")));
	        String Text = alert.getText();
	        System.out.println("Appeared with message: " + Text);
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
}
