package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashBoardTest extends TestBase {
	DashBoardPage dp;
	LoginPage lp;

	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver=super.launchApplication();
		lp =new LoginPage(driver);

		dp=lp.NavigateToDashboard();
	}
	@AfterMethod
	public void closeBrowser() {
		testLogger().info( "Browser Closed");
		super.CloseLaunchApplication();
	}
	// Extent Report Variables
	String pageName = "DASHBOARD PAGE TESTCASES";
	String extentReprtName = "DashboardPageExtentReport";
	String hostName = "Offline Website";
	String environment = "QA";
	String uName = "utkarsh";
	String docTitle = "DashboardPage";
	String reportName = "DashboardpageExtentReport ";

	// ExtentReport Methods..
	@BeforeTest()
	public void beforeTest() {
		super.setReport(extentReprtName, hostName, environment, uName, docTitle, reportName);
	}

	@AfterTest
	public void afterTest() {
		super.endReport();
	}


	@Test(priority = 1)
	public void checkTitle() {
		super.passTest("checkTitle", pageName);
		super.testLogger().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage(testlogger));
	}

	@Test(priority = 2)
	public void checkLogoutLabel() {
		super.passTest("checkLogoutLabel", pageName);
		super.testLogger().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel(testlogger));
	}

	@Test(priority = 3)
	public void checkPageHeaderText() {
		super.passTest("checkPageHeaderText", pageName);
		super.testLogger().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader(testlogger));
	}

	@Test(priority = 4)
	public void checkAllCoursesHeaderText() {
		super.passTest("checkAllCoursesHeaderText", pageName);
		super.testLogger().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders(testlogger));
	}

	@Test(priority = 5)
	public void checkNumberOfCourses() {
		super.passTest("checkNumberOfCourses", pageName);
		super.testLogger().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses(testlogger));
	}

	@Test(priority = 6)
	public void checkAllCourseslinksClickable() {
		super.passTest("checkAllCourseslinksClickable", pageName);
		super.testLogger().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable(testlogger));
	}

	@Test(priority = 7)
	public void checkAllCoursesNames() {
		super.passTest("checkAllCoursesNames", pageName);
		super.testLogger().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames(testlogger));
	}
	
	
	
}
