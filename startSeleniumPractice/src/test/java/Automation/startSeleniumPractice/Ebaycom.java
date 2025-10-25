package Automation.startSeleniumPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebaycom {
	
	ChromeDriver driver;
	@Test
	public void search() throws InterruptedException{
//		 String text="asdfgh";
//		WebDriverManager.chromedriver().clearDriverCache().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
////		String bodyText = driver.findElement(By.tagName("body")).getText();
////		Assert.assertEquals("Text not found!", bodyText.contains(text));
//		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search for anything']")).sendKeys("minimac");
//		driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
//		List <WebElement> element = driver.findElements(By.xpath("//div[@class='srp-river-results clearfix']//li[@class='s-item s-item__pl-on-bottom']//span[@role='heading']"));
//		System.out.println(element);
//		for (WebElement check : element) {
//			System.out.println(check.getText());
//			
//		}
//		Thread.sleep(2000);
//		List <WebElement> element1 = driver.findElements(By.xpath("//div[@class='srp-river-results clearfix']//li[@class='s-item s-item__pl-on-bottom']//span[@class='s-item__price']"));
//		System.out.println(element1);
//		for (WebElement check : element1) {
//			System.out.println(check.getText());
//			
//		}
		// by iterator
//		Iterator <WebElement>tittleoption=element.iterator();
//		Iterator <WebElement>priceoption=element1.iterator();
//		while (tittleoption.hasNext() && priceoption.hasNext()){
//			WebElement tittle =tittleoption.next();
//			WebElement price =priceoption.next();
//		System.out.println(tittle.getText());
//			System.out.println(price.getText());
//		}
		Thread.sleep(1000);
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search for anything']")).sendKeys("minimac");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
		List <WebElement> element = driver.findElements(By.cssSelector(".s-item__title"));//div.s-item__title span
		List <WebElement> element1 = driver.findElements(By.cssSelector(".s-item__price"));//div.s-item__title span
		int size = Math.min(element.size(),element1.size());
		double minPrice = Double.MAX_VALUE;
		String minPriceTitle = "";
		for(int i=0; i<size; i++){
			String title = element.get(i).getText();
            String priceText = element1.get(i).getText();

            // Extract numeric price
            double price = extractPrice(priceText);

            // Check for minimum price
            if (price < minPrice) {
                minPrice = price;
                minPriceTitle = title;
            }
//			System.out.println("");
//			System.out.println(element.get(i).getText() + " " + element1.get(i).getText());
			
		}
	}
	private double extractPrice(String priceText) {
		// TODO Auto-generated method stub
		return 0;
	}

}
