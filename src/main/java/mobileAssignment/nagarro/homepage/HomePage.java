package mobileAssignment.nagarro.homepage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.nagarro.testCases.TC001_Mobile_Homepage;
import io.appium.java_client.android.AndroidDriver;

/**
 * verify user is in homepage
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-29
 */
public class HomePage extends TC001_Mobile_Homepage {

	@FindBy(id = "android:id/button1")
	WebElement popoupButton;

	@FindBy(id = "android:id/title")
	WebElement homepageTitle;

	@FindBy(id = "io.selendroid.testapp:id/buttonTest")
	WebElement enButton;

	@FindBy(id = "android:id/button2")
	WebElement EndActivityNoButton;

	@SuppressWarnings("unchecked")
	public HomePage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify popup if present and homepage title
	 * 
	 */
	public void commonBase() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		if (popoupButton.isDisplayed()) {
			popoupButton.click();
		}

		log.info("Homepage title is - " + homepageTitle.getText());
		assertEquals("selendroid-test-app", homepageTitle.getText());

	}

	/**
	 * Click on EN button and perform required action
	 * 
	 */
	public void enButtonVerify() {

		enButton.click();

		EndActivityNoButton.click();

		assertEquals("selendroid-test-app", homepageTitle.getText());

	}
}
