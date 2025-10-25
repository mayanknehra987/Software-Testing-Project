package seleniumwork;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Screenshotcode {
	 
		public static void main(String[] args) throws InterruptedException, IOException {		
		
			 //Note: Following statement is required since Selenium 3.0, 
	    		//optional till Selenium 2.0
	    		//Set system properties for geckodriver 
	    		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mayank.nehra\\Downloads\\New folder\\geckodriver.exe");
		 
			WebDriver driver = new FirefoxDriver();
			 
			String URL = "https://demoqa.com/droppable/";
			 
			driver.get(URL);
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			//Saving the screenshot in desired location
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			//Path to the location to save screenshot
			FileUtils.copyFile(source, new File("C:\\Users\\mayank.nehra\\Downloads\\Screen.png"));
			System.out.println("Screenshot is captured");
			
			File dest= new File("");
			TakesScreenshot tc = (TakesScreenshot)driver;
			File sc = tc.getScreenshotAs(OutputType.FILE);
			org.openqa.selenium.io.FileHandler.copy(sc, dest);
			 
			// It is always advisable to Maximize the window before performing DragNDrop action		 
			driver.manage().window().maximize();
			 
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			
			//Actions class method to drag and drop		
			Actions builder = new Actions(driver);
			 
			WebElement from = driver.findElement(By.id("draggable"));
			 
			WebElement to = driver.findElement(By.id("droppable"));	 
			//Perform drag and drop
			builder.dragAndDrop(from, to).perform();
			
			//verify text changed in to 'Drop here' box 
			String textTo = to.getText();
			System.out.println(textTo);

//			if(textTo.equals("Dropped!")) {
//				System.out.println("PASS: Source is dropped to target as expected");
//			}else {
//				System.out.println("FAIL: Source couldn't be dropped to target as expected");
//			}
		
			//driver.close();
			
//			//Here, getting x and y offset to drop source object on target object location
//			//First, get x and y offset for from object
//			int xOffset1 = from.getLocation().getX();
//			
//			int yOffset1 =  from.getLocation().getY();
//			
//			System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
//			
//			//Secondly, get x and y offset for to object
//			int xOffset = to.getLocation().getX();
//					
//			int yOffset =  to.getLocation().getY();
//			
//			System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);
//			
//			//Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
//			xOffset =(xOffset-xOffset1)+10;
//			yOffset=(yOffset-yOffset1)+20;
//			
//
//			//Perform dragAndDropBy 
//			builder.dragAndDropBy(from, xOffset,yOffset).perform();

		}	
	 
	}

