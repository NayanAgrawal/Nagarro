package webAssignment.nagarro.droppable;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import assignment.nagarro.base.ExtentTestManager;

import org.testng.Assert;
import assignment.nagarro.testCases.TC006_Web_Droppable;

/**
 * Drag and Drop in jqueryui
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-28
 */
public class Droppable extends TC006_Web_Droppable {

	@FindBy(xpath = "//li/a[@href='https://jqueryui.com/demos/']")
	WebElement verifyHomePage;

	@FindBy(xpath = "//a[contains(text(),'Droppable')]")
	WebElement droppableButton;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement verifyDroppabletitle;

	@FindBy(xpath = "//iframe[@src='/resources/demos/droppable/default.html']")
	WebElement dragDropFrame;

	@FindBy(id = "draggable")
	WebElement dragSource;

	@FindBy(id = "droppable")
	WebElement dragDestination;

	@FindBy(xpath = "//div[@id='droppable']/p")
	WebElement verifyDroppedSuccess;

	public Droppable(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Drag and Drop element in jquery ui and verify
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void dragDropDroppableTab() throws IOException, InterruptedException {

		explicatWait(webDriver, verifyHomePage);

		Assert.assertEquals("Demos", verifyHomePage.getText());

		droppableButton.click();

		Assert.assertEquals("Droppable", verifyDroppabletitle.getText());

		webDriver.switchTo().frame(dragDropFrame);

		scrollView(webDriver, dragSource);

		Actions act = new Actions(webDriver);
		act.dragAndDrop(dragSource, dragDestination).build().perform();

		Assert.assertEquals("Dropped!", verifyDroppedSuccess.getText());

		Thread.sleep(5000);

		log.info("Dragged and Dropped successfully");
		child.log(Status.INFO, "Dragged and Dropped successfully");

		child.log(Status.INFO, "Dragged and Dropped - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(webDriver, "DraggedDropped")).toString());

	}

}
