package assignment.nagarro.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import assignment.nagarro.base.ExtentTestManager;
import assignment.nagarro.base.TestBase;
import webAssignment.nagarro.controlgroup.Controlgroup;

public class TC008_Web_Controlgroup extends TestBase {

	public static final Logger log = Logger.getLogger(TC008_Web_Controlgroup.class.getName());

	public static ExtentTest child;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		init();
	}

	public TC008_Web_Controlgroup() {

	}

	@Test(priority = 1)
	@Parameters({ "rentCar1", "transmissionType1",  "numberofCar1", "rentCar2", "transmissionType2", "numberofCar2" })
	public void RentCarIncontrolgroup(String rentCar1, String transmissionType1, String numberofCar1, String rentCar2,
			String transmissionType2, String numberofCar2) throws Exception {

		child = ExtentTestManager.startTest("Web - Search Competitor", "Search Competitor");
		child.log(Status.INFO, "Search Competitor in true voice");

		Controlgroup controlgroup = new Controlgroup(webDriver);
		controlgroup.controlgroupTab(rentCar1, transmissionType1,  numberofCar1, rentCar2, transmissionType2, numberofCar2);

	}

	@AfterMethod
	public void endTest() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
