package cookie.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookieprogram1 {
	static WebDriver driver; 
	public static void main(String[] args){
		//WebDriver driver; 
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		//Enter Email id and Password if you are already Registered user 
		driver.findElement(By.name("username")).sendKeys("your_username"); 
		driver.findElement(By.name("password")).sendKeys("your_password"); 
		driver.findElement(By.name("submit")).click(); 
		// Create a file to store Login Information 
		File file = new File("Cookiefile.data"); 
		try{ 
		// Delete old file if already exists
		file.delete(); 
		file.createNewFile(); 
		FileWriter file1 = new FileWriter(file); 
		BufferedWriter Bwritecookie = new BufferedWriter(file1); //Getting the cookie information 
		for(Cookie ck : driver.manage().getCookies()) { 
		Bwritecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); 
		Bwritecookie.newLine(); 
		} 
		Bwritecookie.close(); 
		file1.close(); 
		}
		catch(Exception ex) 
		{ 
		ex.printStackTrace(); 
		} 
		}
}
