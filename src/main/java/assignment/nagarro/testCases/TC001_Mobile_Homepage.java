package assignment.nagarro.testCases;

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

public class TC001_Mobile_Homepage extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_Mobile_Homepage.class.getName());

	public static ExtentTest child;

	@BeforeMethod
	public void init() throws IOException {
		Capabilities();
	}

	@Test(priority = 1)
	public void enButtonVerify() throws IOException, InterruptedException {

		child = ExtentTestManager.startTest("Mobile - verify selandroid homepage", "verify selandroid homepage");
		child.log(Status.INFO, "verify selandroid homepage");
		log.info("verify selandroid homepage");

		HomePage homepage = new HomePage(driver);
		homepage.commonBase();

		homepage.enButtonVerify();

		child.log(Status.INFO, "Successfully verified selandroid homepage");
		log.info("Successfully verified selandroid homepage");
	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
