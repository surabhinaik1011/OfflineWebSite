package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.RegistrationPage;

public class RegistrationTest extends TestBase {

	RegistrationPage register = null;
	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("RegistrationPage TestCases");
	}

	@BeforeMethod
	public void loadUrl() throws Throwable {
		super.launchApplication();
		register = new RegistrationPage(driver);
	}

	@Test(priority = 1)
	public void checkRegistrationLink() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkRegistrationLink");
		extentTest.log(Status.INFO, "I am in Registration page test...checkRegistrationLink");
		logger.info("checkRegistrationLink");
		Assert.assertTrue(register.validateRegistraionLink(extentTest));

	}

	@Test(priority = 2)
	public void checkHeading() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkHeading");
		extentTest.log(Status.INFO, "I am in Registration page test...checkHeading");
		logger.info("checkHeading");
		Assert.assertTrue(register.getTextOfHeading(extentTest));
	}

	@Test(priority = 3)
	public void checkTitle() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkTitle");
		extentTest.log(Status.INFO, "I am in Registration page test...checkTitle");
		logger.info("checkTitle");
		Assert.assertTrue(register.getTitleOfRegistrationPage(extentTest));
	}

	@Test(priority = 4)
	public void checkTextBoxCounting() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkTextBoxCounting");
		extentTest.log(Status.INFO, "I am in Registration page test...checkTextBoxCounting");
		logger.info("checkTextBoxCounting");
		Assert.assertTrue(register.validateNoOfTextBoxes(extentTest));
	}

	@Test(priority = 5)
	public void checkIfUserAdded() throws Throwable {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkIfUserAdded");
		extentTest.log(Status.INFO, "I am in Registration page test...checkIfUserAdded");
		logger.info("checkIfUserAdded");
		register.EnterName();
		register.EnterMobile();
		register.EnterEmail();
		register.EnterPassword();
		Assert.assertTrue(register.validateAlertMessage(extentTest));
	}

	@Test(priority = 6)
	public void checkIfMembershipExist() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkIfMembershipExist");
		extentTest.log(Status.INFO, "I am in Registration page test...checkIfMembershipExist");
		logger.info("checkIfMembershipExist");
		Assert.assertTrue(register.validationOfMembership(extentTest));
	}

}
