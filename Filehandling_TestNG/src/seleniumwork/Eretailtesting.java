package seleniumwork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Eretailtesting {
//	public boolean handleFrame(String a){
//		driver.switchTo().frame(driver.findElementByXPath("a"));
//		
//	}
	
	
	public static void main(String[] args) throws ElementNotInteractableException {
		String expectedTitle = "Welcome to eRetail";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mayank.nehra\\Downloads\\TestCases\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dynamic.vineretail.com/eRetailWeb/eRetailLogin.action?popup=true");
		driver.manage().window().maximize();
		String pageTitle=driver.getTitle();
		if(pageTitle.equals(expectedTitle)){
		driver.findElement(By.id("userOrgId")).sendKeys("vspl");
		driver.findElement(By.id("userName")).sendKeys("sa");
		driver.findElement(By.id("password")).sendKeys("sa@321");
		driver.findElement(By.name("Login")).click();

		try {
			driver.wait(1000);
		} catch (Exception e) {
			driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='childIFrame']"));
			driver.findElement(By.xpath("//*[@id='signin-button']")).click();
		}
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("mayank.nehra@vinculumgroup.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Welcome!@#$1234567890");
		driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/span")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().window(windowHandles.get(0));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//ul[@class='sidebar-menu']/li[2]"));
		action.moveToElement(driver.findElementByXPath("//a[contains(text(),'SKU Master')]"));
		action.click().build().perform();
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='SKUMaster_IFrame']"));
		driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@name='vendorCode']").click();
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='vendorDialogIFrame']"));
		WebElement vendorClick = driver.findElementByXPath("//input[@id='gs_vendorCode_pl']");
		vendorClick.sendKeys("ven1");
		vendorClick.sendKeys(Keys.ENTER);
		driver.findElementByCssSelector("td[title='ven1']").click();
		driver.findElementByCssSelector("button.btn.btn-primary.pull-right[type='button']").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElementByCssSelector("iframe[id='SKUMaster_IFrame']"));
		driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
		driver.findElementByXPath("//span[contains(text(),'YAD1')]").click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElementByCssSelector("iframe[id='SKUCreateEdit-YAD1_IFrame']"));
		driver.switchTo().frame(driver.findElementByCssSelector("iframe[id='SKUCreateEdit-YAD1_IFrame']"));
		driver.findElementByXPath("//*[@id='addNewSKU']").click();
	}
		else{
			System.out.println("Page does not contaion text");
		}
		
	}
	

}
