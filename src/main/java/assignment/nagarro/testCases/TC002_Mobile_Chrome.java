package assignment.nagarro.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import assignment.nagarro.base.ExtentTestManager;
import assignment.nagarro.base.TestBase;
import mobileAssignment.nagarro.chromeLogo.ChromeLogoPage;
import mobileAssignment.nagarro.homepage.HomePage;

public class TC002_Mobile_Chrome extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_Mobile_Chrome.class.getName());
	public static ExtentTest child;

	@BeforeMethod
	public void init() throws IOException {
		capabilities();
	}

	@Test(priority = 1)
	public void addNameChrome() throws IOException, InterruptedException, AWTException {

		child = ExtentTestManager.startTest("Mobile - Add details in chrome", "Add details in chrome");
		child.log(Status.INFO, "Add name and car in chrome and verify");
		HomePage homepage = new HomePage(driver);
		homepage.commonBase();

		ChromeLogoPage chromeLogoPage = new ChromeLogoPage(driver);
		chromeLogoPage.chromeLogoTab("Nayan", "Mercedes");

		child.log(Status.INFO, "successfully added name and car in chrome and verified");
	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
