package webAssignment.nagarro.controlgroup;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import assignment.nagarro.base.ExtentTestManager;
import com.aventstack.extentreports.Status;

/**
 * Control group in jqueryui.
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-28
 */
public class Controlgroup extends assignment.nagarro.testCases.TC008_Web_Controlgroup {

	@FindBy(xpath = "//li/a[@href='https://jqueryui.com/demos/']")
	WebElement verifyHomepage;

	@FindBy(xpath = "//a[contains(text(),'Controlgroup')]")
	WebElement controlgroupButton;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement verifyControlgrouptitle;

	@FindBy(xpath = "//iframe[@src='/resources/demos/controlgroup/default.html']")
	WebElement selectControlgroupFrame;

	@FindBy(id = "car-type-button")
	WebElement compactCarDropDownButton;

	@FindBy(id = "horizontal-spinner")
	WebElement horizontalNumberOfCarsInput;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//span[@id='ui-id-8-button']")
	WebElement compactCarDropDownVerticalButton;

	@FindBy(id = "vertical-spinner")
	WebElement verticalNumberOfCarsInput;

	@FindBy(xpath = "//label[@for='insurance'][@class='ui-button ui-widget ui-checkboxradio-label ui-controlgroup-item']")
	WebElement HorizontalInsuranceCheckbox;

	@FindBy(xpath = "//label[@for='insurance-v'][@class='ui-button ui-widget ui-checkboxradio-label ui-controlgroup-item']")
	WebElement VerticalInsuranceCheckbox;

	@FindBy(id = "book")
	WebElement bookButton;

	public Controlgroup(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Fill rent car details in control group
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void controlgroupTab(String rentCar1, String transmissionType1, String numberofCar1, String rentCar2,
			String transmissionType2, String numberofCar2) throws InterruptedException, IOException {

		explicatWait(webDriver, verifyHomepage);

		controlgroupButton.click();

		Assert.assertEquals("Controlgroup", verifyControlgrouptitle.getText());

		webDriver.switchTo().frame(selectControlgroupFrame);

		scrollView(webDriver, compactCarDropDownButton);

		compactCarDropDownButton.click();

		String selectCompactCar = "//ul[@aria-labelledby='car-type-button']/li/div[contains(text(),'" + rentCar1
				+ "')]";
		webDriver.findElement(By.xpath(selectCompactCar)).click();

		String transmissionType = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[@class='ui-button ui-widget ui-checkboxradio-radio-label ui-checkboxradio-label ui-controlgroup-item'][contains(text(),'"
				+ transmissionType1 + "')]";
		webDriver.findElement(By.xpath(transmissionType)).click();

		if (isClickableWeb(HorizontalInsuranceCheckbox, webDriver)) {
			HorizontalInsuranceCheckbox.click();
		} else {
			log.info("Checkbox already clicked");
		}

		horizontalNumberOfCarsInput.sendKeys(numberofCar1);

		compactCarDropDownVerticalButton.click();

		String selectCompactCar1 = "//ul[@aria-labelledby='ui-id-8-button']/li/div[contains(text(),'" + rentCar2
				+ "')]";
		webDriver.findElement(By.xpath(selectCompactCar1)).click();

		String abc = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//label[@class='ui-button ui-widget ui-checkboxradio-radio-label ui-checkboxradio-label ui-controlgroup-item'][contains(text(),'"
				+ transmissionType2 + "')]";
		webDriver.findElement(By.xpath(abc)).click();

		if (isClickableWeb(VerticalInsuranceCheckbox, webDriver)) {
			VerticalInsuranceCheckbox.click();
		} else {
			log.info("Checkbox already clicked");
		}

		verticalNumberOfCarsInput.sendKeys(numberofCar2);

		bookButton.click();

		child.log(Status.INFO, "Contro group url - " + webDriver.getCurrentUrl());
		log.info("Current URL - " + webDriver.getCurrentUrl());

		child.log(Status.INFO, "Control group - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(webDriver, "ControlGroup")).toString());

	}

}
