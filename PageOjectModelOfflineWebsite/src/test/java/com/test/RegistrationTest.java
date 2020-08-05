package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
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
		super.testcaseLogs().info("checkRegistrationLink");
		Assert.assertTrue(register.validateRegistraionLink(extentTest));

	}

	@Test(priority = 2)
	public void checkHeading() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkHeading");
		super.testcaseLogs().info("checkHeading");
		Assert.assertTrue(register.getTextOfHeading(extentTest));
	}

	@Test(priority = 3)
	public void checkTitle() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkTitle");
		super.testcaseLogs().info("checkTitle");
		Assert.assertTrue(register.getTitleOfRegistrationPage(extentTest));
	}

	@Test(priority = 4)
	public void checkTextBoxCounting() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkTextBoxCounting");
		super.testcaseLogs().info("checkTextBoxCounting");
		Assert.assertTrue(register.validateNoOfTextBoxes(extentTest));
	}

	@Test(priority = 5)
	public void checkIfUserAdded() throws Throwable {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkIfUserAdded");
		super.testcaseLogs().info("checkIfUserAdded");
		register.EnterName();
		register.EnterMobile();
		register.EnterEmail();
		register.EnterPassword();
		Assert.assertTrue(register.validateAlertMessage(extentTest));
	}

	@Test(priority = 6)
	public void checkIfMembershipExist() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkIfMembershipExist");
		super.testcaseLogs().info("checkIfMembershipExist");
		Assert.assertTrue(register.validationOfMembership(extentTest));
	}

}
