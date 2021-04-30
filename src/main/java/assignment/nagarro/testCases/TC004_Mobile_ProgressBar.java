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
import mobileAssignment.nagarro.homepage.HomePage;
import mobileAssignment.nagarro.progressBar.ProgressBarPage;

public class TC004_Mobile_ProgressBar extends TestBase {

	public static final Logger log = Logger.getLogger(TC004_Mobile_ProgressBar.class.getName());

	public static ExtentTest child;

	@BeforeMethod
	public void init() throws IOException {
		capabilities();
	}

	@Test(priority = 1)
	public void verifyProgressBar() throws IOException, InterruptedException, AWTException {

		child = ExtentTestManager.startTest("Mobile - verify progress bar", "Verify progress bar");
		child.log(Status.INFO, "Verify progress bar");

		HomePage hoempage = new HomePage(driver);
		hoempage.commonBase();

		ProgressBarPage progressBarPage = new ProgressBarPage(driver);
		progressBarPage.progressBarTab();

		child.log(Status.INFO, "successfully verified progress bar and registartion page element");

	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
