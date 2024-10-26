package service_APP.Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import jdk.internal.org.jline.utils.Log;
import service_APP.Utility.Library;

public class OTPPage extends BasePage {

	public OTPPage(AndroidDriver driver) {
		super(driver);

	}

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Verification')]")
	private WebElement otpText;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Resend OTP']/..")
	private WebElement resendOTPText;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//*[@class='com.horcrux.svg.PathView'])[1]")
	private WebElement heroImg;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='-'])")
	private List<WebElement> otpDigits;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Submit']/..")
	private WebElement submitBtn;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[@text='OTP Verification']/..//android.widget.TextView)[1]")
	private WebElement backBtn;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Resend OTP, in 60s']")
	private WebElement resendOTPBtn;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Invalid OTP']")
	private WebElement invalidOTPmsg;

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "//android.widget.TextView[@text='Resend OTP']")
	private WebElement resendOTP;

	public void getSubmitButtonState() {
		String state = Library.visible_element_attribute(driver, submitBtn, "enabled", "SubmitButtonState");
		if (state.equalsIgnoreCase("false")) {
			log.info("Submit button is Disabled"); 
		}else if(state.equalsIgnoreCase("true")) {
			log.info("Submit button is Enabled"); 
		}		
	}
	
	public void verifySubmitButtonState() {
		Library.visible_link(driver, submitBtn, "Submit Button");
	}

	public void verifyInvalidOTPmsg() {
		Library.visible_link(driver, invalidOTPmsg, "Invalid OTP");
//		Library.threadSleep(2000);
	}

	public void clickOnBackButton() {
		Library.click(driver, backBtn, "Back Button");
	}

	public void verifyOTPText() {
		Library.visible_link(driver, otpText, "OTP text");

	}

	public void verifyHeroImage() {
		Library.visible_link(driver, heroImg, "Hero Image");
	}

//	public void enterValidOTP() {
//		Library.EnterOtp( driver);
//
//	}

	public void enterValidOTP() {
		int i = 1;
		Actions action;
		if (driver == null) {
			System.out.println("Driver is null!!!");
		}
//		Actions action = new Actions(driver);
		try {
			action = new Actions(driver);
			for (WebElement otp : otpDigits) {
				otp.click();
				action.sendKeys("" + i).perform();
				log.info("Enter the OTP Digit as :" + i);
//				ExtentCucumberAdapter.getCurrentStep().pass("Enter the OTP Digit as :" + i);

				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Enter the  OTP Failed ");
//				ExtentCucumberAdapter.getCurrentStep().fail("Enter the  OTP Failed ");
//				takeScreenshot();
		}

	}
//	public void clearOTP() {
//		for (WebElement otp : otpDigits) {
//			System.out.println("Keys.BACK_SPACE");
//			EnterKeys(Keys.BACK_SPACE);
//			
//		}
//		Sleep(1000);
//	try {
//		for (WebElement otp : otpDigits) {
//			otp.clear();
//		}
//	}catch(Exception e) {
//			e.printStackTrace();
//		}
//		testResultUtilities.logger.log(LogStatus.PASS, "Clear the OTP");
//	}

	public void getResendOTPtext() {
		String text = Library.visible_element_attribute(driver, resendOTPText, "content-desc", "content decs");
//		System.out.println("text : " + text);
		String resendTime = text.substring(text.length() - 3, text.length() - 1);
//		System.out.println("Resend time : " + text.substring(text.length() - 3, text.length() - 1));
		if (text.length() > 15) {
			log.info("Resend Time : " + resendTime);
			Assert.assertTrue(Integer.valueOf(resendTime)>50);
		}

	}

	public void enterInvalidOTP(String otpDigit) {
		Actions action;
		if (driver == null) {
			System.out.println("Driver is null!!!");
		}
		try {
			action = new Actions(driver);
			for (WebElement otp : otpDigits) {
//				otp.clear();
				otp.click();
				action.sendKeys("" + otpDigit).perform();
				log.info("Enter the OTP Digit as :" + otpDigit);
//				ExtentCucumberAdapter.getCurrentStep().pass("Enter the OTP Digit as :" + otpDigit);

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Enter the  OTP Failed ");
			log.AddScreenshot();
		}

	}

	public void clickSubmitButton() {
		otp.verifyHeroImage();
		Library.click(driver, heroImg, "Hero Image");
		Library.threadSleep(1000);
		Library.click(driver, submitBtn, "Submit Button");
	}

}
