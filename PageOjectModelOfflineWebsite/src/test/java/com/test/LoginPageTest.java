package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp = null;

	// ExtentReport Methods

	@BeforeMethod
	public void loadUrl() throws Throwable {
		loadLoginpage();
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
		extenttest.info("I am in login page test..checkURL");
		testcaseLogs().info("checkURL");
		Assert.assertTrue(lp.checkURL(extenttest));
	}

	@Test(priority = 2)

	public void checkTitle() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkTitle");
		extenttest.info("I am in login page test..checkTitle");
		testcaseLogs().info("checkTitle");
		Assert.assertTrue(lp.checkTitle(extenttest));
	}

	@Test(priority = 3)
	public void checkHeading() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkHeading");
		extenttest.info("I am in login page test..checkHeading");
		testcaseLogs().info("checkHeading");
		Assert.assertTrue(lp.checkHeading(extenttest));
	}

	@Test(priority = 4)
	public void checkLoginBoxMsg() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkLoginBoxMsg");
		extenttest.info("I am in login page test..checkLoginBoxMsg");
		testcaseLogs().info("checkLoginBoxMsg");
		Assert.assertTrue(lp.checkLoginMsg(extenttest));
	}

	@Test(priority = 5)
	public void checkNavigationBetRegPageAndLogin() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkNavigationBetRegPageAndLogin");
		extenttest.info("I am in login page test..checkNavigationBetRegPageAndLogin");
		testcaseLogs().info("checkNavigationBetRegPageAndLogin");
		Assert.assertTrue(lp.navigateToLoginFromReg(extenttest));
	}

	@Test(priority = 6)
	public void validateInvalidLoginCred() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: validateInvalidLoginCred");
		extenttest.info("I am in login page test..validateInvalidLoginCred");
		testcaseLogs().info("validateInvalidLoginCred");
		lp.clickLoginButton();
		Assert.assertTrue(lp.checkErrorMessage(extenttest));
	}

	@Test(priority = 7)
	public void validateValidLoginCred() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: validateValidLoginCred");
		extenttest.info("I am in login page test..validateValidLoginCred");
		testcaseLogs().info("validateValidLoginCred");
		lp.NavigateToDashboard();
		Assert.assertTrue(lp.checkTitleOfDashBoard(extenttest));
	}

	@Test(priority = 8)
	public void checkNavigationBetDashboardAndLogin() {
		ExtentTest extenttest = extenttestPerPage.createNode("test case  :: checkNavigationBetDashboardAndLogin");
		extenttest.info("I am in login page test..checkNavigationBetDashboardAndLogin");
		testcaseLogs().info("checkNavigationBetDashboardAndLogin");
		lp.navigationBetDashboardAndLogin(extenttest);
		Assert.assertTrue(lp.navigateToLoginFromDashboard(extenttest));
	}

}