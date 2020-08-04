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

	/*
	 * @Test(priority = 3) public void checkHeading() {
	 * super.testLoggerLog4j().info("Running checkHeading");
	 * Assert.assertTrue(lp.checkHeading()); }
	 * 
	 * @Test(priority = 4) public void checkLoginBoxMsg() {
	 * super.testLoggerLog4j().info("Running checkLoginBoxMsg");
	 * Assert.assertTrue(lp.checkLoginMsg()); }
	 * 
	 * @Test(priority = 5) public void checkNavigationBetRegPageAndLogin() {
	 * super.testLoggerLog4j().info("Running checkNavigationBetRegPageAndLogin");
	 * Assert.assertTrue(lp.navigateToLoginFromReg()); }
	 * 
	 * @Test(priority = 6) public void validateInvalidLoginCred() {
	 * super.testLoggerLog4j().info("Running validateInvalidLoginCred ");
	 * lp.clickLoginButton(); Assert.assertTrue(lp.checkErrorMessage()); }
	 * 
	 * @Test(priority = 7) public void validateValidLoginCred() {
	 * super.testLoggerLog4j().info("Running validateValidLoginCred ");
	 * lp.NavigateToDashboard(); Assert.assertTrue(lp.checkTitleOfDashBoard()); }
	 * 
	 * @Test(priority = 8) public void checkNavigationBetDashboardAndLogin() {
	 * super.testLoggerLog4j().info("Running checkNavigationBetDashboardAndLogin");
	 * lp.navigationBetDashboardAndLogin();
	 * Assert.assertTrue(lp.navigateToLoginFromDashboard()); }
	 */

	

}