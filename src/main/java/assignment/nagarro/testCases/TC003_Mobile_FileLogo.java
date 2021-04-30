package assignment.nagarro.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import assignment.nagarro.base.ExtentTestManager;
import assignment.nagarro.base.TestBase;
import mobileAssignment.nagarro.fileLogo.FileLogoPage;
import mobileAssignment.nagarro.homepage.HomePage;

public class TC003_Mobile_FileLogo extends TestBase {

	public static final Logger log = Logger.getLogger(TC003_Mobile_FileLogo.class.getName());

	public static ExtentTest child;

	@BeforeMethod
	public void init() throws IOException {
		Capabilities();
	}

	@Test(priority = 1)
	@Parameters({ "name", "password", "emailID" })
	public void fileLogo(String name, String password, String emailID)
			throws IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("Mobile - File Logo", "File Logo");
		child.log(Status.INFO, "Register in file logo page and verify");

		HomePage homepage = new HomePage(driver);
		homepage.commonBase();

		FileLogoPage fileLogoPage = new FileLogoPage(driver);
		fileLogoPage.fileLogoTab(name, password, emailID);

		child.log(Status.INFO, "Successfuflly Registered in file logo page and verified");

	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
