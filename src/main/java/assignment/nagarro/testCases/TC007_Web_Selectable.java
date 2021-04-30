package assignment.nagarro.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import assignment.nagarro.base.ExtentTestManager;
import assignment.nagarro.base.TestBase;
import webAssignment.nagarro.selectable.Selectable;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC007_Web_Selectable extends TestBase {

	public static final Logger log = Logger.getLogger(TC007_Web_Selectable.class.getName());

	public static ExtentTest child;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		init();
	}

	public TC007_Web_Selectable() {

	}

	@Test(priority = 1)
	@Parameters({ "itemList" })
	public void selectable(String itemList) throws Exception {

		child = ExtentTestManager.startTest("Web - verify multiple select", "verify multiple select");
		child.log(Status.INFO, "Verify multiple select in jqueryui");

		Selectable selectable = new Selectable(webDriver);
		selectable.selectItemTab(itemList);

		child.log(Status.INFO, "Sleected multiple elements successfully");
	}

	@AfterMethod
	public void endTest() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
