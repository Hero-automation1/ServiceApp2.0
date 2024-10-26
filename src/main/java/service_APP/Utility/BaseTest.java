package service_APP.Utility;

/**
 * 
 * @author Prathmesh.Mahure
 * 
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.io.Files;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class BaseTest extends ConfigeDataProvider {

	static String userName = "randhir.kumarheromotocorp";
	static String accessKey = "bduH44LqYpsKBB4XN6tTZLzuIoczCKiqbpWCzsmpuRnFjPsnud";

//	@BeforeTest(alwaysRun = true)
//	@BeforeAll
	public static void configureApp() throws Exception {
		service_APP.Utility.Log.initialiseExtentReport(LOGGER);
		LOGGER.debug("====================================================================================");
		LOGGER.debug("   *********************   Launching Hero Service UI Test App    ******************");
		LOGGER.debug("====================================================================================");
		launchApp(Platform_name);
		System.out.println("Session ID:" + driver.getSessionId());
	}

//	@BeforeClass(alwaysRun = true)
	public void beforeClass() {

	}

	@SuppressWarnings("static-access")
//	@BeforeMethod(alwaysRun = true)
	public static void beforeMethod(Scenario method) {
		service_APP.Utility.Log.extentLogger = Log.extent.createTest(method.getName());
//		Log.extentLogger = Log.extent.createTest(result.getTestClass().getName() + "=" +method.getName());
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("                   Start -> Test -> " + method.getName() + "    ");
		LOGGER.debug("                   ===============================================");
	}

//	@AfterMethod(alwaysRun = true)
	public void afterMethod(Scenario method) throws Exception {
		service_APP.Utility.Log.afterMethodLogResultBDD(method, driver);
//		addScreenshot(method);
//		LOGGER.debug(" 1");
//		Library.threadSleep(1000);
//		LOGGER.debug(" End -> Test -> " + method.getName() + "    ");
//		LOGGER.debug("====================================================================================");
	}

//	@AfterClass(alwaysRun = true)
	public void afterClass() {
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("*******************        Next Class suite      ***********************");
		LOGGER.debug("====================================================================================");
//		reloadBrowser();
	}

//	@AfterTest(alwaysRun = true)
//	@AfterAll
	public static void tearDown() {
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("*******************         Driver Quit       ***********************");
		LOGGER.debug("====================================================================================");
		service_APP.Utility.Log.flushExtent(LOGGER);
		driver.quit();

	}

//=========================================================================================================================
//=========================================================================================================================
//=========================================================================================================================
	public static void launchApp(String Platform_name) throws MalformedURLException {
		URL url = null;
		DesiredCapabilities caps;

		switch (Platform_name) {
		case "emulator":
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, EmulatorDeviceName);
			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("appium:udid", "emulator-5554");// 0836731257071990 //emulator-5554 //0526532038000424
			caps.setCapability("appium:avd", EmulatorDeviceName);// if u connect real device comment this line
			caps.setCapability("appium:avdLaunchTimeout", 600000);
			caps.setCapability("newCommandTimeout", 1200);
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("appPackage", "com.service_app");
			caps.setCapability("appActivity", "com.service_app.MainActivity");
			caps.setCapability("appium:noReset", "false");

			url = new URL(Url);
			driver = new AndroidDriver(url, caps);
			break;

		case "realdevice":
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PVUOJRLR4LVOZ9IB");
//			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("appium:udid", RealDeviceName);// 0836731257071990 //emulator-5554 //0526532038000424
			caps.setCapability("appium:avdLaunchTimeout", 600000);
			caps.setCapability("newCommandTimeout", 1200);
			caps.setCapability("autoGrantPermissions", true);
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("appPackage", "com.service_app");
			caps.setCapability("appActivity", "com.service_app.MainActivity");
			caps.setCapability("appium:noReset", "false");
			try {
				url = new URL(Url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Real device issue");
			}
			driver = new AndroidDriver(url, caps);
			if (driver != null) {
				System.out.println("RealDevice Driver has been started!!!");
			}
			break;

		case "cloud":

			try {
				//// Lambda Start code part =============
//               caps = new DesiredCapabilities();
//              HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//              ltOptions.put("w3c", true);
//              ltOptions.put("platformName", "android");
//              ltOptions.put("deviceName", "Pixel.*");
//              ltOptions.put("platformVersion", "1[234]");
//              ltOptions.put("app", "lt://APP10160502001723537798506439");
//              ltOptions.put("devicelog", true);
//              ltOptions.put("visual", true);
//              ltOptions.put("video", true);
//              ltOptions.put("console", true);
//              ltOptions.put("isRealMobile", true);
//              ltOptions.put("autoGrantPermissions", true);     // for permission
//              ltOptions.put("unicodeKeyboard", true);
//              ltOptions.put("resetKeyboard", true);
//              ltOptions.put("noReset", false);
//              ltOptions.put("appiumVersion", "2.0.0");//
//              ltOptions.put("project_Name", "GB App");
//              ltOptions.put("build", "2.4");
//              ltOptions.put("name", "GB App");
//              caps.setCapability("lt:options", ltOptions);
//              driver = new AndroidDriver(
//                      new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
//                      caps);
//             driver.activateApp("com.hero.gbcustomer");	
//              ((JavascriptExecutor) driver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a sample remark for failed test \"}} ");	

				/// Lambda end code part =============

				// Pcloudy Start code part =============
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appium:newCommandTimeout", 600);
				capabilities.setCapability("appium:launchTimeout", 90000);
				capabilities.setCapability("appium:platformVersion", "13.0.0");
				capabilities.setCapability("appium:platformName", "Android");
				capabilities.setCapability("appium:automationName", "uiautomator2");
				capabilities.setCapability("appium:autoGrantPermissions", true);
				capabilities.setCapability("appium:appPackage", "com.service_app");
				capabilities.setCapability("appium:appActivity", "com.service_app.MainActivity");
				HashMap<String, Object> pcloudyOptions = new HashMap<String, Object>();
				pcloudyOptions.put("pCloudy_Username", "anil1.singh@heromotocorp.com");
				pcloudyOptions.put("pCloudy_ApiKey", "gb2hycp3rd35mt73jy4vc85f");
				pcloudyOptions.put("pCloudy_DurationInMinutes", 20);
				pcloudyOptions.put("pCloudy_DeviceManufacturer", "SAMSUNG");
				pcloudyOptions.put("pCloudy_DeviceVersion", "13.0.0");
				pcloudyOptions.put("pCloudy_ApplicationName", "ServiceApp2.apk");
				pcloudyOptions.put("pCloudy_WildNet", false);
//				pcloudyOptions.put("pCloudy_autoGrantPermissions", true);
				pcloudyOptions.put("pCloudy_EnableVideo", false);
				pcloudyOptions.put("pCloudy_EnablePerformanceData", true);
				pcloudyOptions.put("pCloudy_EnableDeviceLogs", true);
				pcloudyOptions.put("appiumVersion", "2.0.0");
				capabilities.setCapability("pcloudy:options", pcloudyOptions);
				driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"),
						capabilities);
//				driver = new AndroidDriver(url, capabilities);
				// Pcloudy end code part =============
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Pcloudy device issue");
			}
			if (driver != null) {
				System.out.println("Pcloudy Driver has been started!!!");
			}

			break;

		default:
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, EmulatorDeviceName);
			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("newCommandTimeout", 600);
			try {
				url = new URL(Url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver = new AndroidDriver(url, caps);
			break;
		}

		Library.threadSleep(3000);

	}

//=========================================================================================================================
	public static void launchBrowser() throws Exception {

		String browser = ConfigeDataProvider.browser;

		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
			HashMap<String, Object> profile = new HashMap<String, Object>();
			HashMap<String, Object> prefs = new HashMap<String, Object>();

			contentSettings.put("notifications", 2);// 0 is ask , 1 is allow , 2 is block
			contentSettings.put("geolocation", 1);
			contentSettings.put("media_stream", 1);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			co.setExperimentalOption("prefs", prefs);
			co.addArguments("--remote-allow-origins=*");
			co.addArguments("--disable-blink-features=AutomationControlled");
			co.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			co.addArguments("--incognito");
			co.addArguments("disable-infobars");
			co.addArguments("disable-extensions");
			co.addArguments("disable-gpu");
			co.addArguments("disable-dev-shm-usage");
			co.addArguments("no-sandbox");
			co.addArguments("disable-notifications");
			co.addArguments("--force-device-scale-factor=0.9");
			webDriver = new ChromeDriver(co);
			// driver.get(hero_hub_url);
			webDriver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			break;
		default:
			webDriver = null;
			break;

		}
		Library.passmsg("BaseTest -> launchBrowser() -> Browser launched successfully");

	}

//	co.addArguments("--headless");   //   Hiding chrome browser
//	co.addArguments("start-maximized");
//=========================================================================================================================
	public static void quitBrowser() {
		Library.threadSleep(1000);
		driver.quit();
	}

//=========================================================================================================================
	public static void reloadBrowser() {
		driver.get(hero_hub_url);
	}

//=========================================== Screenshot area ==============================================================================
	public static String getscreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}

//=========================================================================================================================	
	public static String takeScreenshot() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-hhmmss");
		String strDate = formatter.format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//Reports//ChromeTestScreenShots//" + strDate + "_"
				+ RandomString.make(5) + "_" + ".jpg";
		try {
			Files.copy(srcFile, new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

//=========================================================================================================================	
//	@AfterStep add screenshot to scenario
	public static void addScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			byte[] screenshot = java.util.Base64.getDecoder().decode(screenshotBase64);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

	}

//=========================================================================================================================		
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void HomePageActivity() {

		try {
			Activity activity = new Activity("com.service_app", "com.service_app.MainActivity");
			activity.setStopApp(false);
			((AndroidDriver) driver).startActivity(activity);
			// Log.info("Service app activity start");
		} catch (Exception e) {
			// Log.error("Unable to start Service app activity");
		}
	}
//=========================================================================================================================	

}
