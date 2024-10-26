package service_APP.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import service_APP.Utility.Library;
import service_APP.Utility.Log;

public class OnlineBookingPage extends BasePage{
	
	public static String searchstr; 
	
	public OnlineBookingPage(AndroidDriver driver) {
		super(driver);
		
	}
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.View[@content-desc='Online Bookings']")
	private WebElement onlineBookingsHeader;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='Online Bookings'])[1]/..//android.widget.EditText")
	private WebElement searchTextBox;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "((//android.widget.TextView[@text='Online Bookings'])[1]/..//android.widget.TextView)[3]")
	private WebElement resultText;
	
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "((//android.widget.TextView[@text='Online Bookings'])[1]/..//android.widget.ImageView)[2]")
	private WebElement searchBtn;
		
	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "((//android.widget.TextView[@text='Online Bookings'])[1]/../android.widget.TextView)[2]")
	private WebElement logoutBtn;

	public void verifyOnlieBookingHeader() {
		Library.threadSleep(10000);
		Library.visible_link(driver,onlineBookingsHeader, "Online Bookings Header");	
	}
	
	public void verifyResultText(String text) {
		
		String actualText = Library.visible_link_gettext(driver, resultText, "On Booking text");
		log.info("actualText : " + actualText);
		log.info("Expected Text : "+text);
		Library.assertEquals(driver, actualText, text);

	}
	
	public void clickLogout() {
		Library.click(driver,logoutBtn, "Logout Button");
	}
	
	
	public void enterSearch(String text) {
		searchstr = text;
		searchTextBox.clear();
		Library.threadSleep(1000);
		Library.sendKeys(driver,searchTextBox, text, "Enter in search box");
		driver.navigate().back();
		Library.click(driver,searchBtn, "Search Button");
		Library.threadSleep(1000);
		Library.visible_link_gettext(driver,resultText, "On Booking text");
	}
	
	public void verifyingSearchBoxText() {
		String actualString  = Library.visible_link_gettext(driver,searchTextBox, "Search box text");
		Library.assertEquals(driver, searchstr, actualString);
	}
}
