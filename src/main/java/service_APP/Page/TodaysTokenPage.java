package service_APP.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import service_APP.Utility.Library;

public class TodaysTokenPage extends BasePage{

	public TodaysTokenPage(AndroidDriver driver) {
		super(driver);
		
	}

	@iOSXCUITFindBy(xpath = "")
	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'Token')])[1]/../android.widget.TextView[2]")
	private WebElement logoutButton;
	
	
	public void clickLogoutButton() {
		Library.click(driver, logoutButton, "logout Button");
	}
}
