package Eretail.FrameworkEretail.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Eretail.FrameworkEretail.base.CommonToAllPages;
import Eretail.FrameworkEretail.utils.PropertyReader;

public class OrderCreateByQuikShip extends CommonToAllPages{
	WebDriver driver;
	String shipmsg = "Duplicate Tracking No entered for the Transporter";
	public OrderCreateByQuikShip(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='sidebar-menu']/li[4]") WebElement SalesMenu;
    @FindBy(xpath="//section[@class='sidebar']/ul/li[4]/div/div[2]/ul/li[2]") WebElement OrderCreateOption;
    @FindBy(xpath="//iframe[@id='OrderCreateEdit_IFrame']") WebElement OrderCreateEditFrame;
    @FindBy(xpath="//iframe[@id='Dashboard_IFrame']/following-sibling::iframe") WebElement OrderCreateEditFrame1;
    @FindBy(xpath="//button[@id='custDialog']") WebElement CustomerPickList;
    @FindBy(xpath="//iframe[@id='custCodeDialogIFrame']") WebElement CustomerDialogBoxFrame;
    @FindBy(xpath="//input[@name='customerDTO.customerCode']") WebElement CustomerCode;
    @FindBy(xpath="//button[@name='searchCustomer']") WebElement SearchButton;
    @FindBy(xpath="//table[@id='customerList']/tbody/tr[3]/td[3]") WebElement CustomerPickFromTable;
    @FindBy(xpath="//button[@id='selectCustomer']") WebElement OkButton;
    @FindBy(xpath="//button[@id='addSKUBtn']") WebElement AddSku;
    @FindBy(xpath="//input[@name='displaySkuScan']") WebElement SkuCode;
    @FindBy(id="OrderQty") WebElement OrderQty;
    @FindBy(xpath="//button[@name='skuAddinG']") WebElement SkuAddButton;
    @FindBy(xpath="//button[@id='confirmButtonOrderMaintaintance']") WebElement OrderConfirmButton;
    @FindBy(xpath="//*[@id='messageLabel']") WebElement ConfirmMesg;
    @FindBy(css="#mesgParentDiv #messageLabel") WebElement messageLabel;
    @FindBy(xpath="//*[@id='mesgParentDiv']/i") WebElement closeButton;
    @FindBy(xpath="//label[@id='status_lbl']") WebElement OrderStatus;
    @FindBy(xpath="//button[@id='allocateButtonOrderMaintaintance']") WebElement AllocateButton;
    @FindBy(xpath="//*[@id='orderDetailList']/tbody/tr[2]/td[24]/div/div[2]/span[2]") WebElement CommitedQty;
    @FindBy(xpath="//input[@id='externOrderNo']") WebElement ExternalOrderNo;
    @FindBy(xpath="//button[@id='quickShipOrderBtn']") WebElement QuickShipBtn;
    
    @FindBy(xpath="//iframe[@id='quickShipDialogIFrame']") WebElement QuickshipFrame;
    @FindBy(xpath="//span[@id='select2-transporterCode-container']") WebElement SelectTransporter;
    @FindBy(xpath="//ul[@id='select2-transporterCode-results']/li[3]") WebElement TransporterDropdown;
    @FindBy(xpath="//input[@name='quickShipDTO.awbNo']") WebElement trackingno;
    @FindBy(xpath="//input[@id='manualAWB']") WebElement manualawbupdate;
    @FindBy(xpath="//span[@id='select2-packagingType-container']") WebElement PackagingTypeSelect;
    @FindBy(xpath="//ul[@id='select2-packagingType-results']/li[2]") WebElement SelectPackagingType;
    @FindBy(xpath="//button[@id='quickShip_OkButton']") WebElement QuickShipOk;
	
    public void selectSalesMenu() {
    	implicitWaitPageLoad();
    	//driver.switchTo().parentFrame();
    	switchToparentFrame();
    	moveToElement(SalesMenu, driver);
	}
	public void selectOrderCreateEdit() {
		moveToElement(OrderCreateOption, driver);
	}
	public void selectOrderCreateEditFrame() {
		orderCreateEditFrame(OrderCreateEditFrame, driver);
	}
	public void customerPick() {
		CustomerPickList.click();
	}
	public void customerDialogFrame() {
		orderCreateEditFrame(CustomerDialogBoxFrame, driver);
	}
	public void enterCustomerName(){
		CustomerCode.sendKeys(PropertyReader.readKey("customercode"));
	}
	public void clickSearchButton(){
		SearchButton.click();
	}
	public void pickCustomerFromTable(){
		//CustomerPickFromTable.click();
		moveToElement(CustomerPickFromTable, driver);
		switchToparentFrame();
	}
//	public void clickOkButton(){
//		OkButton.click();
//	}
	public void clickAddSkuButton(){
		AddSku.click();
	}
	public void enterSkuCode(){
		SkuCode.sendKeys(PropertyReader.readKey("skucode"));
		pressEnter(SkuCode);
	}
	public void enterOrderQty(){
		OrderQty.click(); // Ensure focus
		OrderQty.sendKeys(Keys.CONTROL + "a");
		OrderQty.sendKeys(Keys.DELETE);
		OrderQty.sendKeys(PropertyReader.readKey("orderqty"));
		implicitWaitPageLoad();
	}
	public void clickSkuAddButton(){
		SkuAddButton.click();
	}
	public void clickConfirmButton(){
		OrderConfirmButton.click();
		acceptAlert();
		switchToDefaultContent();
	}
	public void clickConfirmMessage(){
		visibilityOfElement(messageLabel);
		ConfirmMesg.click();
	}
	public void acceptConfirmMessage(){
		WebElement messageElement = visibilityOfElement(messageLabel);
        String messageText = messageElement.getText().trim();
        System.out.println("Order Confirmation Message: " + messageText);
		messageLabel.click();
	}
	public void closeConfirmMessage(){
		closeButton.click();
	}
	public void fetchOrderStatus(){
		orderCreateEditFrame(OrderCreateEditFrame, driver);
		String odrstatus=OrderStatus.getText();
		System.out.println("Order Status is: " + odrstatus);
	}

	public void clickAllocateButton() {
		AllocateButton.click();
		implicitWaitPageLoad();
		switchToDefaultContent();
		WebElement messageElement = visibilityOfElement(messageLabel);
		String messageText = messageElement.getText().trim();
		System.out.println("Order Allocation Message: " + messageText);
		closeButton.click();
		orderCreateEditFrame(OrderCreateEditFrame, driver);
		String odrstatus = OrderStatus.getText();
		System.out.println("Order Status is: " + odrstatus);
		try {
			String orderNo = ExternalOrderNo.getAttribute("value");
		    System.out.println("Order No: " + orderNo);
		} catch (Exception e) {
		    System.out.println("Error while fetching order number: " + e.getMessage());
		}
		double commitQty = Double.parseDouble(CommitedQty.getText().trim());
		System.out.println("Committed Quantity: " + commitQty);
	}
	public void clickQuickShipButton(){
		QuickShipBtn.click();
	}
	public void selectQuickShipFrame(){
		switchToQuickShipFrame(QuickshipFrame);
	}
	public void selectTransporter(){
		SelectTransporter.click();
	}
	public void selectTransporterDropdown(){
		TransporterDropdown.click();
	}
	public void checkManualAwbUpdateCheckBox(){
		manualawbupdate.click();
	}
	public void enterTrackingNo(){
		trackingno.sendKeys(PropertyReader.readKey("trackingno"));
	}
	public void entertPackingType(){
		PackagingTypeSelect.click();
	}
	public void selectPackingType(){
		SelectPackagingType.click();
		//QuickShipOk.click();
	}
	public void clickQuickShipOkBtn(){
		QuickShipOk.click();
//		//DriverInitiate.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		switchToDefaultContent();
//		orderCreateEditFrame(OrderCreateEditFrame, driver);
//		
//		String odrstatus=OrderStatus.getText();
//		System.out.println("Order Status is: " + odrstatus);
//		WebElement messageElement = visibilityOfElement(messageLabel);
//		String messageText = messageElement.getText().trim();
//        System.out.println("Order Shipped/DuplicateTrackingno Message: " + messageText);
//		if(messageText.equalsIgnoreCase(shipmsg)){
//			trackingno.sendKeys(PropertyReader.readKey("gh8f57dtukf"));
//			QuickShipOk.click();
//		}
//		orderCreateEditFrame(OrderCreateEditFrame, driver);
//		String odrstatus=OrderStatus.getText();
//		System.out.println("Order Status is: " + odrstatus);
	}
	public void fetchKey1FromDB() {
        String query = "SELECT key1 FROM USERPARAMS WHERE PARAMCODE = 'UNIQUESLNO'";
        Integer key1 = executeQueryAndFetchIntValue(query);

        if (key1 == null) {
            System.out.println("Key1 is NULL in the database.");
        } else {
            System.out.println("Key1 Value: " + key1);
        }
    }
}
