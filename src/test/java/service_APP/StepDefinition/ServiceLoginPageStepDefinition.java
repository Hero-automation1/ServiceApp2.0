package service_APP.StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import service_APP.Utility.BaseTest;
import service_APP.Utility.Library;

public class ServiceLoginPageStepDefinition extends BaseTest {

//	private Actions action;
	public static String tokenNo;
	public static String bikenumber;
	public static String ownerName;
	public static String bikeModel;
	public static String ownernumber;
	public static String todayTokenNumber;

	@Given("user on the login screen of the app")
	public void launchApp() throws Throwable {
//		slp.allowLocationPermission();
	}

	@When("user enters the valid {string}")
	public void enterCredentails(String username) {
		slp.enterCrdentails(username);

	}
	
	@And("Click on Remeber Me CheckBox to ucheck")
	public void ClickRemeberMe1() {
		Library.threadSleep(5000);
		slp.clickRemeberMeChkBx();
	}
	
	
	@And("Click on Remeber Me CheckBox")
	public void ClickRemeberMe() {
		driver.navigate().back();
		slp.clickRemeberMeChkBx();
	}

	@And("Get the resend text")
	public void getResendTime() {
		otp.getResendOTPtext();
	}
	@And("user click on signIn button")
	public void clickLoginButton() {
		slp.clickSendOTPBttn();
	}

	@And("verify the toast {string} at y-axis Start {int} and {int}")
	public void verifyToastMessage(String message, int starty, int endy) throws InterruptedException {
		if (!message.isBlank()) {
			slp.verifyToastMessage(message, starty, endy);
		}
	}

	@Then("Verify userID it showing {string}")
	public void verifyUserId(String userId) {
		slp.verifyUserId(userId);
	}

	@And("User reaches to the OTP page")
	public void verifyOTPPage() {
		otp.verifyOTPText();
		otp.verifyHeroImage();
//		verify Otp is disable
		otp.getSubmitButtonState();
		Library.threadSleep(4000);
	}

	@And("Enter the {string} OTP")
	public void enterOTP(String otpType) {
		if (otpType.equalsIgnoreCase("valid")) {
			otp.enterValidOTP();
			Library.threadSleep(1000);
//			validate the Submit button is enabled
			otp.getSubmitButtonState();
		} else if (otpType.equalsIgnoreCase("invalid")) {
			otp.enterInvalidOTP("1");
			Library.threadSleep(1000);
//			validate the Submit button is enabled
			otp.getSubmitButtonState();
		}
	}

	@And("Enter the Submit button")
	public void clcikSubmitBtn() {
		otp.clickSubmitButton();
	}

	@Then("verify it navigate to the TokenCreation page")
	public void verifyTokenCreationPage() {
		tokenCreation.verifyTokenCreationText();
		tokenCreation.verifyScanToProceedText();
		Library.threadSleep(1000);
	}
	
	@And("Get the todays token number")
	public void GetTodaysTokenNUmber() {
		todayTokenNumber = tokenCreation.getTodaysTokenNumber();
	}

	@And("Click on Todays Token link and get todays information")
	public void GetTodaysTokenInfo() {
		if (Integer.valueOf(todayTokenNumber)> 0) {
			tokenCreation.ClickTodaysTokenLinkLink();
			Library.threadSleep(1000);
			tokenCreation.TodaysTokenInfo();
		}
		else {
			log.info("There is no token for Today");
		}
	
	}
	
	@And("user click on Scan button and take picture of registration plate")
	public void takeRegsitrationPlatePic() {
		tokenCreation.clickScanButton();
		tokenCreation.clickAllowPicPermission();
		try {
			tokenCreation.clickCameraPic();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Library.threadSleep(1000);
		tokenCreation.clickCameraDone();
		Library.threadSleep(1000);
	}

	@And("user enter the bike registration number {string} and click Next")
	public void enterRegistraionNumber(String regNumber) {
		tokenCreation.enterBikeRegistration(regNumber);
		Library.threadSleep(1000);
		tokenCreation.clickNextBtn();
	}

	@And("verify user ticket information")
	public void verifyTicketInfo() {
		Library.threadSleep(3000);
		bikenumber = tokenCreation.getBikeRegNumber();
		bikeModel = tokenCreation.getBikeModel();
		ownerName = tokenCreation.getOwnerName();
		ownernumber = tokenCreation.getOwnerMobileNumber();
		Library.threadSleep(2000);
	}

	@And("Select the ticket and Assign it")
	public void assignTicket() {
		tokenCreation.selectTheToken();
		tokenCreation.clickNextBtn1();
		Library.threadSleep(1000);
		tokenCreation.assignToken();
		Library.threadSleep(1000);
	}

	@And("get the token information and Click ok")
	public void getTokenInfo() {
		try {
			if (tokenCreation.getTokenNu().isDisplayed()) {
				tokenNo = tokenCreation.getTokenNUmber();
				tokenCreation.getAssignedBikeNumber();
				tokenCreation.getAssignedBikeModel();
				tokenCreation.clickOkBtn1();
				verifyTokenInfo();
				clickLogout1();
				clickVerifyLogout();
			} else {
				log.info("Token Already assigned!!!");
				clickLogout();
				clickVerifyLogout();
			}

		} catch (Exception e) {
			log.info("Token Already assigned!!!");
			clickLogout();
			clickVerifyLogout();
		}

	}

	@And("Click on logout button")
	public void clickLogout() {
		Library.threadSleep(10000);
		tokenCreation.clickLogoutButton();
		Library.threadSleep(5000);
	}

	@And("Click on Confirm button")
	public void clickVerifyLogout() {
		tokenCreation.clickLogoutVerificationButton();
		Library.threadSleep(1000);
	}

	@And("Click on No registration number link")
	public void clickOnNoRegistrationLink() {
		Library.threadSleep(10000);
		tokenCreation.ClickOnNoRegistrationLink();
		Library.threadSleep(10000);
	}

	@And("Enter the customer mobile number as {string}")
	public void enterCustomerMobileNu(String mobilenu) {
		tokenCreation.enterCustomerMobileNu(mobilenu);
		Library.threadSleep(5000);

	}

	@And("Click on BackBtn")
	public void ClcikBackButton() {
		driver.navigate().back();
	}

	@And("verify submit button is disable")
	public void verifySubmitButtonDisabled() {
		otp.verifySubmitButtonState();
	}

	@Then("verify invalid OTP message")
	public void verifyInvalidOTPmsg() {
		otp.verifyInvalidOTPmsg();
	}

	@And("Tap on back button")
	public void clickBackButton() {
		otp.clickOnBackButton();
	}

	@And("Click on todays token logout button")
	public void clickLogout1() {
		Library.threadSleep(10000);
		todaysToken.clickLogoutButton();
		Library.threadSleep(5000);
	}

	@And("click on Todays Token and verify token info")
	public void verifyTokenInfo() {
		tokenCreation.ClickTodaysTokenLinkFooterLink();
		// verify Token and bike number
		String actualTokeNumber = tokenCreation.getTicketNumber();
		String actualBikeModel = tokenCreation.getTicketBikeModel();
		String actualBikeRegNumber = tokenCreation.getTicketBikeRegNumber();
		String actualOwnerMobile = tokenCreation.getTicketOwnerMobileNumber();
		String actualOwnerName = tokenCreation.getTicketOwnerName();
		
//		System.out.println("actualTokeNumber :" + actualTokeNumber + "tokenNo : "+ tokenNo);
//		System.out.println("actualBikeModel :" + actualBikeModel + "bikeModel : "+ bikeModel);
//		System.out.println("actualBikeRegNumber :" + actualBikeRegNumber + "bikenumber : "+ bikenumber);
//		System.out.println("actualOwnerMobile : "+ actualOwnerMobile + "ownernumber : "+ ownernumber);
//		System.out.println("actualOwnerName : "+ actualOwnerName + "ownerName : "+ownerName);
			
		Assert.assertTrue(actualBikeRegNumber.equalsIgnoreCase(bikenumber), "Bike Registration number matched");
		Assert.assertTrue(actualBikeModel.equalsIgnoreCase(bikeModel), "Bike Model matched");
		Assert.assertTrue(actualOwnerMobile.equalsIgnoreCase(ownernumber), "Owner Mobile number matched");
		Assert.assertTrue(actualOwnerName.equalsIgnoreCase(ownerName), "Owner Name matched");
		
	}

	@And("Click Next")
	public void clickOnNext() {
		tokenCreation.clickNextBtn();
	}

	@And("user click on Scan button, allow permission, Click cancel button and scan it again")
	public void scanCancelScanAndScan() {
		tokenCreation.clickScanButton();
		tokenCreation.clickAllowPicPermission();
		tokenCreation.clickCancelBtn();
		Library.threadSleep(5000);
		tokenCreation.clickScanButton();
		try {
			tokenCreation.clickCameraPic();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Library.threadSleep(10000);
		tokenCreation.clickCameraDone();
	}

	@And("user click the scan again and take pic")
	public void scanAgain() {
		Library.threadSleep(2000);
		tokenCreation.clickScanAgainButton();
		try {
			tokenCreation.clickCameraPic();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Library.threadSleep(10000);
		tokenCreation.clickCameraDone();
	}

	@And("Click on online booking footer")
	public void ClickOnlineBookingFooter() {
		tokenCreation.ClickOnlineBookingsFooterLink();
	}

	@And("verify Online booking header")
	public void verifyOnlineBookingsHeader() {
		onlineBooking.verifyOnlieBookingHeader();
	}

	@And("verify there is no booking message {string}")
	public void verifyDisplayMessage(String text) {
		onlineBooking.verifyResultText(text);
	}

	@And("Click on Booking logout button")
	public void clickLogout2() {
		Library.threadSleep(10000);
		onlineBooking.clickLogout();
		Library.threadSleep(5000);
	}

	@And("Enter the {string} and verify it")
	public void searchWithOwnerName(String name) {
		onlineBooking.enterSearch(name);
		onlineBooking.verifyingSearchBoxText();
	}

}
