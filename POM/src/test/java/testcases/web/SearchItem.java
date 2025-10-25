package testcases.web;

import org.testng.annotations.Test;
import base.web.DriverInitiate;
import pages.web.HomePage;
import pages.web.SearchPage;

public class SearchItem extends DriverInitiate {

	@Test
	public void searchItem() throws InterruptedException {
		SearchPage page = new SearchPage(driver);
		page.search("iphone");
		page.searchButton();
		page.selectCategory("Desktops");
		page.clickSearchButton();
		page.gridList();
		
		page.addToCart();
		page.addToWishList();
		page.compareThisProduct();
		page.selectSortBy("Name (A - Z)");
	}

}
