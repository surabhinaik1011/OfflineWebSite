package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp = null;

	// ExtentReport Methods

	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver = super.launchApplication();
		lp = new LoginPage(driver);
	}

	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("LoginPage TestCases");
	}

	@Test(priority = 1)
	public void checkURL() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkUrl");
		extenttest.log(Status.PASS, "I am in login page test..checkURL");
		Assert.assertTrue(lp.checkURL(extenttest));
	}

	@Test(priority = 2)

	public void checkTitle() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkTitle");
		extenttest.log(Status.PASS, "I am in login page test..checkTitle");
		Assert.assertTrue(lp.checkTitle(extenttest));
	}

	@Test(priority = 3)
	public void checkHeading() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkHeading");
		extenttest.log(Status.PASS, "I am in login page test..checkHeading");
		Assert.assertTrue(lp.checkHeading(extenttest));
	}

	@Test(priority = 4)
	public void checkLoginBoxMsg() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkLoginBoxMsg");
		extenttest.log(Status.PASS, "I am in login page test..checkLoginBoxMsg");
		Assert.assertTrue(lp.checkLoginMsg(extenttest));
	}

	@Test(priority = 5)
	public void checkNavigationBetRegPageAndLogin() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkNavigationBetRegPageAndLogin");
		extenttest.log(Status.PASS, "I am in login page test..checkNavigationBetRegPageAndLogin");
		Assert.assertTrue(lp.navigateToLoginFromReg(extenttest));
	}

	@Test(priority = 6)
	public void validateInvalidLoginCred() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: validateInvalidLoginCred");
		extenttest.log(Status.PASS, "I am in login page test..validateInvalidLoginCred");
		lp.clickLoginButton();
		Assert.assertTrue(lp.checkErrorMessage(extenttest));
	}

	@Test(priority = 7)
	public void validateValidLoginCred() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: validateValidLoginCred");
		extenttest.log(Status.PASS, "I am in login page test..validateValidLoginCred");
		lp.NavigateToDashboard();
		Assert.assertTrue(lp.checkTitleOfDashBoard(testlogger));
	}

	@Test(priority = 8)
	public void checkNavigationBetDashboardAndLogin() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: validateValidLoginCred");
		extenttest.log(Status.PASS, "I am in login page test..validateValidLoginCred");
		lp.navigationBetDashboardAndLogin();
		Assert.assertTrue(lp.navigateToLoginFromDashboard(testlogger));
	}

}