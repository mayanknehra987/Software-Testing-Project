package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.web.DriverInitiate;

public class HomePage{
	
	//2. option:- passing webdriver object in all methods same as passing in below method without inherited and making static
	/*public void var(String a){
		System.out.println(a);
		public void search(WebDriver driver){
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("samsung");
	}
	}*/
	//3. option making constructure and webdriver global veriable
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	// making input as a dynamic
	public void search(String searchKey){
	//	driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("samsung");
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(searchKey);
	}
	public void searchButton(){
		driver.findElement(By.cssSelector("button[class='btn btn-light btn-lg']")).click();
	}

}
