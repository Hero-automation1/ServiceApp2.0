package service_APP.Page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import service_APP.Utility.Library;

public class ServiceLoginPage extends BasePage {

	public ServiceLoginPage(AndroidDriver driver) {
		super(driver);

	}

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
//	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement locationPermission;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement userId;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.View")
	private WebElement sendOTPBttn;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//com.horcrux.svg.GroupView/com.horcrux.svg.GroupView")
	private WebElement rememberMeChkBx;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Please Enter User ID']")
	private WebElement enterUserIdMsg;

	public void verifyEnterUserIdMsg() {
		Library.visible_link_gettext(driver, enterUserIdMsg, "Please Enter User ID");
	}

	public void allowLocationPermission() {
		Library.threadSleep(3000);
		try {
			
			boolean status = Library.visible_link(driver, locationPermission, "Allow Location permission btn");
			if (locationPermission.isDisplayed()) {
				Library.click(driver, locationPermission, "Allow Location permission btn");
			}
		} catch (Exception e) {
			System.out.println("Allow Location permission button is not present");
		}
	}

	public void enterCrdentails(String username) {
		if (!username.isBlank()) {
			Library.sendKeys(driver, userId, username, "User name");
		}
	}

	public void verifyUserId(String expecteduserId) {
		String actualUserId = Library.visible_link_gettext(driver, userId, "User Id");
		log.info("expecteduserId : "+ expecteduserId);
		log.info("actualUserId : "+ actualUserId);
		Library.assertEquals(driver, expecteduserId, actualUserId);
	}

	public void clickSendOTPBttn() {
		Library.click(driver, sendOTPBttn, "Send OTP Button");
	}

	public void clickRemeberMeChkBx() {
		Library.click(driver, rememberMeChkBx, "Remember Me Checkbox");
	}

	public void verifyToastMessage(String message, int starty, int endy) {
		Library.threadSleep(1200);
		if (message.equals("Please Enter User ID")) {
			verifyEnterUserIdMsg();
		} else {
			Library.OCRverification(driver, message, starty, endy);
		}

	}

}
