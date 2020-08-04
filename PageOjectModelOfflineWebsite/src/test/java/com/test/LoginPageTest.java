package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.DownloadPage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lp = null;
	
	// Extent Report Variables
		String pageName = "Login PAGE TESTCASES";
		String extentReprtName = "LoginPageExtentReport";
		String hostName = "Offline Website";
		String environment = "Login Page Testing";
		String uName = "Surabhi";
		String docTitle = "LoginPage";
		String reportName = "LoginPageExtentReport ";

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

		driver=super.launchApplication();
		lp = new LoginPage(driver);
	}
	
	
	
	@Test(priority = 1)
	public void checkURL() {
		super.testLogger().info("Running checkURL");
		super.passTest("checkURL", pageName);
		Assert.assertTrue(lp.checkURL(testlogger));
	}

	@Test(priority = 2)
	public void checkTitle() {
		super.testLogger().info("Running checkTitle");
		super.passTest("checkTitle", pageName);
		Assert.assertTrue(lp.checkTitle(testlogger));
	}

	@Test(priority = 3)
	public void checkHeading() {
		super.testLogger().info("Running checkHeading");
		super.passTest("checkHeading", pageName);
		Assert.assertTrue(lp.checkHeading(testlogger));
	}

	@Test(priority = 4)
	public void checkLoginBoxMsg() {
		super.testLogger().info("Running checkLoginBoxMsg");
		super.passTest("checkLoginBoxMsg", pageName);
		Assert.assertTrue(lp.checkLoginMsg(testlogger));
	}

	@Test(priority = 5)
	public void checkNavigationBetRegPageAndLogin() {
		super.testLogger().info("Running checkNavigationBetRegPageAndLogin");
		super.passTest("checkNavigationBetRegPageAndLogin", pageName);
		Assert.assertTrue(lp.navigateToLoginFromReg(testlogger));
	}

	@Test(priority = 6)
	public void validateInvalidLoginCred() {
		super.testLogger().info("Running validateInvalidLoginCred ");
		super.passTest("validateInvalidLoginCred", pageName);
		lp.clickLoginButton();
		Assert.assertTrue(lp.checkErrorMessage(testlogger));
	}

	@Test(priority = 7)
	public void validateValidLoginCred() {
		super.testLogger().info("Running validateValidLoginCred ");
		super.passTest("validateValidLoginCred", pageName);
		lp.NavigateToDashboard();
		Assert.assertTrue(lp.checkTitleOfDashBoard(testlogger));
	}
	//
	@Test(priority = 8)
	public void checkNavigationBetDashboardAndLogin() {
		super.testLogger().info("Running checkNavigationBetDashboardAndLogin");
		super.passTest("checkNavigationBetDashboardAndLogin", pageName);
		lp.navigationBetDashboardAndLogin();
		Assert.assertTrue(lp.navigateToLoginFromDashboard(testlogger));
	}
	@AfterMethod
	public void closeBrowser() {
		super.CloseLaunchApplication();
		super.passTest("closeBrowser", pageName);
		//super.testlogger.log(Status.INFO, "Browser Closed");
		
	}

}