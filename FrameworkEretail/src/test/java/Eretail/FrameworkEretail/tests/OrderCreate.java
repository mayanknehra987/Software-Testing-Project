package Eretail.FrameworkEretail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Eretail.FrameworkEretail.driver.DriverInitiate;
import Eretail.FrameworkEretail.pages.OrderCreateByQuikShip;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

public class OrderCreate extends DriverInitiate{
	@Owner("Mayank Nehra")
	@Description("Verify Order Create successfully Done")	
	@Test
	public void TC001(){
		OrderCreateByQuikShip OrderCreateQuikShip = PageFactory.initElements(driver, OrderCreateByQuikShip.class);
		OrderCreateQuikShip.selectSalesMenu();
		OrderCreateQuikShip.selectOrderCreateEdit();
		OrderCreateQuikShip.selectOrderCreateEditFrame();
		OrderCreateQuikShip.customerPick();
		OrderCreateQuikShip.customerDialogFrame();
		OrderCreateQuikShip.enterCustomerName();
		OrderCreateQuikShip.clickSearchButton();
		OrderCreateQuikShip.pickCustomerFromTable();
		//OrderCreateQuikShip.clickOkButton();
		OrderCreateQuikShip.clickAddSkuButton();
		OrderCreateQuikShip.enterSkuCode();
		OrderCreateQuikShip.enterOrderQty();
		OrderCreateQuikShip.clickSkuAddButton();
		OrderCreateQuikShip.clickConfirmButton();
		OrderCreateQuikShip.clickConfirmMessage();
		OrderCreateQuikShip.acceptConfirmMessage();
		OrderCreateQuikShip.closeConfirmMessage();
		OrderCreateQuikShip.fetchOrderStatus();
		OrderCreateQuikShip.clickAllocateButton();
		OrderCreateQuikShip.clickQuickShipButton();
		OrderCreateQuikShip.selectQuickShipFrame();
		OrderCreateQuikShip.selectTransporter();
		OrderCreateQuikShip.selectTransporterDropdown();
		OrderCreateQuikShip.checkManualAwbUpdateCheckBox();
		OrderCreateQuikShip.enterTrackingNo();
		OrderCreateQuikShip.entertPackingType();
		OrderCreateQuikShip.selectPackingType();
		OrderCreateQuikShip.clickQuickShipOkBtn();
		//fetch data from db/ method called from ordercreatebyquickship classs
		OrderCreateQuikShip.fetchKey1FromDB();
	}

}
