package service_APP.Utility;

/**
 * @author Prathmesh.Mahure
 * 
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import service_APP.ExcelDataProvider.excelTestData;
import service_APP.Page.DocumentPage;
import service_APP.Page.LoginPage;
import service_APP.Page.MyProfilePage;
import service_APP.Page.OTPPage;
import service_APP.Page.OnlineBookingPage;
import service_APP.Page.ServiceLoginPage;
import service_APP.Page.TodaysTokenPage;
import service_APP.Page.TokenCreationPage;

public class PageClassObject {

	public static AppiumDriverLocalService service;
	public static Logger LOGGER = LogManager.getLogger("Log");
	public static Log log;
	public static AndroidDriver driver;
	public static WebDriver webDriver;
	public static excelTestData exceldata;
	public static LoginPage loginPg;
	public static MyProfilePage myp;
	public static DocumentPage DP;
	
	public static OnlineBookingPage onlineBooking;
	public static OTPPage otp;
	public static ServiceLoginPage slp;
	public static TodaysTokenPage todaysToken;
	public static TokenCreationPage tokenCreation;
	
	
//	@BeforeMethod(alwaysRun = true)
	public static void getObject() {

		exceldata = new excelTestData();
		log = new Log();
		loginPg = new LoginPage(driver);
		myp = new MyProfilePage(driver);
		DP = new DocumentPage(driver);
		
		
		onlineBooking = new OnlineBookingPage(driver);
		otp = new OTPPage(driver);
		slp = new ServiceLoginPage(driver);
		todaysToken = new TodaysTokenPage(driver);
		tokenCreation = new TokenCreationPage(driver);
		
		
		
		
	}

}
