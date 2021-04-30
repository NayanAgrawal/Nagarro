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
import webAssignment.nagarro.droppable.Droppable;

public class TC006_Web_Droppable extends TestBase {

	public static final Logger log = Logger.getLogger(TC006_Web_Droppable.class.getName());
	public static ExtentTest child;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		init();
	}

	public TC006_Web_Droppable() {

	}

	@Test(priority = 1)
	public void dragAndDrop() throws Exception {

		child = ExtentTestManager.startTest("Web - verify drag and drop", "Verify drag and drop");
		child.log(Status.INFO, "Drag and drop from source to destination");

		Droppable droppable = new Droppable(webDriver);
		droppable.dragDropDroppableTab();
		
	}

	@AfterMethod
	public void endTest() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
