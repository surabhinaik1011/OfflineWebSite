package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest extends TestBase {

	RegistrationPage register = null;

	// Extent Report Variables
	String pageName = "REGISTRATION PAGE TESTCASES";
	String extentReprtName = "RegistrationPageExtentReport";
	String hostName = "Offline Website";
	String environment = "Registration Page Testing";
	String uName = "ketaki chalse";
	String docTitle = "RegistrationPage";
	String reportName = "RegistrationPageExtentReport ";

	// ExtentReport Methods
	@BeforeTest()
	public void beforeTest() {
		super.setReport(extentReprtName, hostName, environment, uName, docTitle, reportName);
	}

	@AfterTest
	public void afterTest() {
		super.endReport();
	}

	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver = super.launchApplication();
		register = new RegistrationPage(driver);
	}

	@Test(priority = 1)
	public void checkRegistrationLink() {
		super.passTest("check Registration Link", pageName);
		Assert.assertTrue(register.validateRegistraionLink(testlogger));
	}

	@Test(priority = 2)
	public void checkHeading() {
		super.passTest("check heading of Registration page", pageName);
		Assert.assertTrue(register.getTextOfHeading(testlogger));
	}

	@Test(priority = 3)
	public void checkTitle() {
		super.passTest("check Title of Registration page", pageName);
		Assert.assertTrue(register.getTitleOfRegistrationPage(testlogger));
	}

	@Test(priority = 4)
	public void checkTextBoxCounting() {
		super.passTest("check Total no of Tex Box of Registration page", pageName);
		Assert.assertTrue(register.validateNoOfTextBoxes(testlogger));
	}

	@Test(priority = 5)
	public void checkIfUserAdded() throws Throwable {
		super.passTest("Enter the new member details and accept alert", pageName);
		register.EnterName();
		register.EnterMobile();
		register.EnterEmail();
		register.EnterPassword();
		Assert.assertTrue(register.validateAlertMessage(testlogger));
	}

	@Test(priority = 6)
	public void checkIfMembershipExist() {
		super.passTest("check if the member is already exist", pageName);
		Assert.assertTrue(register.validationOfMembership(testlogger));
	}

	@AfterMethod
	public void closeApplication() {
		super.testLogger().info("Browser Closed");
		super.CloseLaunchApplication();
	}

}
