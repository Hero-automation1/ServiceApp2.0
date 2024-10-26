package service_APP.Page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import service_APP.Utility.Library;

public class TokenCreationPage  extends BasePage{

	public TokenCreationPage(AndroidDriver driver) {
		super(driver);
		
	}
	public static String Platform_name = Library.getStringConfigData("Platform_name");
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Token creation']")
	private WebElement tokenCreationText;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Scan To Proceed']")
	private WebElement scanToProceedText;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Scan']/..")
	private WebElement scanBtn;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Scan again']/..")
	private WebElement scanAgainBtn;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@content-desc='no_scan_label']")
	private WebElement noRegNumberLink;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.View[@content-desc='Online Bookings']")
	private WebElement onlineBookingsFooter;
	
	 
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.View[@content-desc='Home']")
	private WebElement homeLinkFooter;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='token_no_label, reg_no_value, ']/android.widget.TextView[3]")
	private WebElement todaysTokenLink;
	
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.View[@content-desc=\"Today's Tokens\"]")
	private WebElement todaysTokenLinkFooter;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement customerMobileNumber;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='View Online Bookings']")
	private WebElement viewOnlineBookings;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Online Bookings']")
	private WebElement onlineBookingsHeader;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'no booking available')]")
	private WebElement noBookingAvailableText;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Online Bookings']/..//com.horcrux.svg.PathView)[2]")
	private WebElement onLinePageClose;
	
	
	@iOSXCUITFindBy(id = "")
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement allowPicturePermission;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'Tokens')])[1]/../android.widget.TextView[2]")
	private WebElement todaysTokenNumber;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='']")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Token Creation']/following-sibling::android.widget.TextView[1]")
	private WebElement logoutButton;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Logout']/..")
	private WebElement logoutVerificationButton;

	@iOSXCUITFindBy(id = "")
	@FindBy(id = "com.android.camera:id/shutter_button")
	private WebElement cameraShutterBtn;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.sec.android.app.camera:id/normal_center_button']")
	private WebElement cameraShutterBtn_cloud;
	
	@iOSXCUITFindBy(id = "")
	@FindBy(id = "com.android.camera:id/done_button")
	private WebElement cameraDoneBtn;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.sec.android.app.camera:id/okay']")
	private WebElement cameraDoneBtn_cloud;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement registrationNumber;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='btn_next_active']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
//	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
	private WebElement nextBtn;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='btn_next2']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
	private WebElement nextBtn1;
	
///----------
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Reg No'])[1]/following-sibling::android.widget.TextView[2]")
	private WebElement bikeReg_Number;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Model'])[1]/following-sibling::android.widget.TextView[2]")
	private WebElement bikeModel;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Name'])[1]/following-sibling::android.widget.TextView[2]")
	private WebElement ownerName;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Mobile'])[1]/following-sibling::android.widget.TextView[1]")
	private WebElement ownerMobileNumber;
	
//	-------------------------------------
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Reg No']/..//com.horcrux.svg.CircleView)[2]")
	private WebElement tokenSelection;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Assign Token']")
	private WebElement assignToken;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Assigned to']")
	private WebElement assignTo;
//	---------------------------------
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'token_no_value'])[1]")
	private WebElement tokenNu;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'reg_no_value'])[1]")
	private WebElement bikeRegistrationNumber;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'model_no_value'])[1]")
	private WebElement assignedBikeModel;
	
	//--------------------------------------------------------------------------------
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'reg_no_value'])[1]")
	private WebElement ticket_bikeRegNumber;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'model_value'])[1]")
	private WebElement ticket_bikeModel;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'token_no'])[1]")
	private WebElement ticket_No;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'name_value'])[1]")
	private WebElement ticket_ownerName;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@content-desc = 'mobile_value'])[1]")
	private WebElement ticket_ownerMobileNumber;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='OK']")
	private WebElement okBtn;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ok_btn']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
	private WebElement okBtn1;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.camera:id/cancel_button']")
	private WebElement cancelBtn;
	
	
	
	
	public void clickCancelBtn() {
//		System.out.println("EXECUTION_ENV : " + EXECUTION_ENV);
		if(Platform_name.equals("cloud")) {
			Library.threadSleep(3000);
			driver.navigate().back();
			log.info("Click Camera Cancel button");
		}else {
			Library.click(driver,cancelBtn, "Cancel button");
		}
	}
	
	public void clickOkBtn() {
		Library.click(driver,okBtn, "Ok button");
	}
	
	public void clickOkBtn1() {
		Library.click(driver,okBtn1, "Ok button");
	}
	
	public String getAssignedBikeModel() {
		return Library.visible_link_gettext(driver,assignedBikeModel, "Assigned Bike Model");
	}
	public String getAssignedBikeNumber() {
		String bikeNumber = Library.visible_link_gettext(driver,bikeRegistrationNumber, "Assigned Bike Registration Number");
		return bikeNumber;
	}
	
	public String getTokenNUmber() {
	String token = 	Library.visible_link_gettext(driver,tokenNu, "Assigned Token Number");
	return token;
	}
	
	public WebElement getTokenNu() {
		return tokenNu;
	}

	public void verifyAssignTo() {
		Library.visible_link(driver,assignTo, "Assign To");
	}
	
	public void assignToken() {
		Library.click(driver,assignToken, "Assign Token");
	}
	public void selectTheToken() {
		Library.click(driver,tokenSelection, "Token Selection");
	}
	
	public void ClickOnlineBookingsFooterLink() {
		Library.click(driver,onlineBookingsFooter, "online Bookings Footer Link");
		
	}
	public void ClickHomeLinkFooterLink() {
		Library.click(driver,homeLinkFooter, "Home Link Footer Link");
		
	}
	
	public void ClickTodaysTokenLinkLink() {
		Library.click(driver,todaysTokenLink, "Todays Token Link Link");
		
	}
	
	public void ClickTodaysTokenLinkFooterLink() {
		Library.click(driver,todaysTokenLinkFooter, "Todays Token Link Footer Link");
		
	}
	public void enterCustomerMobileNu(String mobilenu) {
		Library.sendKeys(driver,customerMobileNumber, mobilenu, "Customer mobile Number");
		driver.navigate().back();
		verifyCustomerMobileNu();
	}
	
	public void verifyCustomerMobileNu() {
		String number = Library.visible_link_gettext(driver,customerMobileNumber, "Customer mobile Number");
		if(!number.isBlank()) {
			log.info("Entered Customer mobile number is :" + number + " and its length is :" + number.length());
//			ExtentCucumberAdapter.getCurrentStep().pass("Entered Customer mobile number is :" + number + " and its length is :" + number.length());
			Assert.assertTrue(number.length()==10);
		}else {
			log.info("Not able Entered Customer mobile number");
//			ExtentCucumberAdapter.getCurrentStep().pass("Not able Entered Customer mobile number");
		}
	}
	
	public void verifyonlineBookingsHeader() {
		Library.visible_link(driver,onlineBookingsHeader, "online Bookings Header");
	}
	
	
	public void verifyNoBookingAvailableText() {
		Library.visible_link(driver,noBookingAvailableText, "No Booking Available Text");
	}
	
	public void clickAllowPicPermission() {
//		Library.click(driver,allowPicturePermission, "Allow while using the App");
	}
	
	public void ClickOnNoRegistrationLink() {
		Library.click(driver,noRegNumberLink, "No Registration Number? Link");
		Library.threadSleep(5000);
		
	}
	
	public String getOwnerMobileNumber() {
		return Library.visible_link_gettext(driver,ticket_ownerMobileNumber, "Bike Owner Mobile Number");
	}
	
	public String getOwnerName() {
		return Library.visible_link_gettext(driver,ticket_ownerName, "Bike Owner Name");
	}
	
	public String getBikeModel() {
		return Library.visible_link_gettext(driver,ticket_bikeModel, "Bike Model");
	}
	
	public String getBikeRegNumber() {
		return Library.visible_link_gettext(driver,ticket_bikeRegNumber, "Bike Registration Number");
	}
	
	
	public void TodaysTokenInfo() {
		List<WebElement> tokenNums = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='token_no']"));
		List<WebElement> bikeRegistrations = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='reg_no_value']"));
		List<WebElement> bikeModels = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='model_value']"));
		List<WebElement> bikeOwners = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='name_value']"));
		List<WebElement> bikeOwnerNames = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='mobile_value']"));
		
		int i =0 ;
		
		for(WebElement token : tokenNums) {
			log.info("Token Number :" +tokenNums.get(i).getText());
			log.info("Token Bike Registration :" +bikeRegistrations.get(i).getText());
			log.info("Token Bike Model :" +bikeModels.get(i).getText());
			log.info("Token Bike Owner :" + bikeOwners.get(i).getText());
			log.info("Token Bike Owner Name :" +bikeOwnerNames.get(i).getText());
			i++;
			if(i==3) break;
		}
	}
	
	public void clickNextBtn() {
		Library.click(driver,nextBtn, "Next Button");
//		System.out.println("Next button clicked");
	}
	public void clickNextBtn1() {
		Library.click(driver,nextBtn1, "Assign Next Button");
//		System.out.println("Next button clicked");
	}

	public void enterBikeRegistration(String regNumber) {
		Library.sendKeys(driver,registrationNumber, regNumber, "Bike Registration Numer");
	}

	public void clickCameraPic() throws IOException {
//		System.out.println("EXECUTION_ENV : " + EXECUTION_ENV);
		if(Platform_name.equals("cloud")) {
			Library.threadSleep(3000);
			Library.click(driver,cameraShutterBtn_cloud, "Camera Shutter Button");
		}else {
			Library.click(driver,cameraShutterBtn, "Camera Shutter Button");
		}
		
	}

	public void clickCameraDone() {
//		System.out.println("EXECUTION_ENV : " + EXECUTION_ENV);
		if(Platform_name.equals("cloud")) {
//			System.out.println("clickCameraDone : "+ EXECUTION_ENV);
			Library.click(driver,cameraDoneBtn_cloud, "Camera Shutter Button");
		}else {
			Library.click(driver,cameraDoneBtn, "Camera Done Button");
		}
		
	}

	public void verifyTokenCreationText() {
		Library.visible_link(driver,tokenCreationText, "Token Creation");

	}

	public void verifyScanToProceedText() {
		Library.visible_link(driver,scanToProceedText, "Scan To Procced Text");

	}

	public void clickScanButton() {
		Library.click(driver,scanBtn, "Scan Button");
	}
	
	public void clickScanAgainButton() {
		Library.click(driver,scanAgainBtn, "Scan Again Button");
	}

	public void clickLogoutButton() {
		Library.click(driver,logoutButton, "logout Button");
		log.info("Clicked on logout Button");
	}

	public void clickLogoutVerificationButton() {
		Library.click(driver,logoutVerificationButton, "Logout verification Button");

	}
	public String getTicketOwnerMobileNumber() {
		return Library.visible_link_gettext(driver,ticket_ownerMobileNumber, "Bike Owner Mobile Number");
	}
	
	public String getTicketOwnerName() {
		return Library.visible_link_gettext(driver,ticket_ownerName, "Bike Owner Name");
	}
	public String getTicketNumber() {
		return Library.visible_link_gettext(driver,ticket_No, "ticket Number");
	}
	
	public String getTicketBikeModel() {
		return Library.visible_link_gettext(driver,ticket_bikeModel, "Bike Model");
	}
	
	public String getTicketBikeRegNumber() {
		return Library.visible_link_gettext(driver,ticket_bikeRegNumber, "Bike Registration Number");
	}
	

	public String getTodaysTokenNumber() {
		String tokenNumber = Library.visible_link_gettext(driver,todaysTokenNumber, "TokeNumber");
		log.info("Today's Token number are :" + tokenNumber);
		return tokenNumber;
	}
	
}
