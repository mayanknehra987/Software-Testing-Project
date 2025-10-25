package testcases.web;

import org.testng.annotations.Test;
import base.web.DriverInitiate;
import pages.web.HomePage;


public class HomePageSearchItem extends DriverInitiate{
	
   @Test
    public void searchItem(){
      HomePage page = new HomePage(driver);
      // 2 option used in below line for passing driver in pages
      //page.search(driver);
      page.search("iphone");
      page.searchButton();
    }

   
}
