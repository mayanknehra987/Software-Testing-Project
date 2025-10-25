package ArchitectureofSelenium.SeleniumFramework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ArchitectureofSelenium.SeleniumFramework.drivers.DriverManager;

public class CommonToAllTest {
	
	@AfterMethod
	public void tearDown(){
		DriverManager.Down();
	}
	@BeforeMethod
	public void setUp(){
		DriverManager.inIt();
	}

}
