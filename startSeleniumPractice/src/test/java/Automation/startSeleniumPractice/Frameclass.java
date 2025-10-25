package Automation.startSeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Frameclass {

		public static void main(String[] args) {

			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://ui.vision/demo/webtest/frames/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Webelement

			WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
			driver.switchTo().frame(frame1); // this will switch to on frame
			driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
			driver.switchTo().defaultContent(); // this will switch to main page

			// Index
			driver.switchTo().frame(1); // this will switch to 1 frame

			driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
			driver.switchTo().defaultContent();

			// frame3
			WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
			driver.switchTo().frame(frame2);
			driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
			// iframe inside the frame
			
			driver.switchTo().frame(0);

			WebElement displaybutton = driver.findElement(By.cssSelector("#i5"));
			if (displaybutton.isEnabled()) {
				displaybutton.click();
			}
			else {
				System.out.println("button is disabled");
			}
			driver.findElement(By.cssSelector("div[aria-label='Form Autofilling']")).click();
			// driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[1]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)", "");
			driver.findElement(By.cssSelector("div[jsname='LgbsSe']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//List<WebElement> element = driver.findElements(By.cssSelector("div[jsname='wQNmvb']"));
			List<WebElement>element=driver.findElements(By.xpath("//div[@jsname='wQNmvb' ]"));
			for(WebElement option : element){
				if(option.getText().equals("Well, now I know :-)")){
					option.click();
				}
			}
			System.out.println("Option Selected");
		}

	}

