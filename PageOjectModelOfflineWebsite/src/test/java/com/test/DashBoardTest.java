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
		testLoggerLog4j().info( "Browser Closed");
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
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage());
=======
		super.passTest("checkTitle", pageName);
		super.testLogger().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 2)
	public void checkLogoutLabel() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel());
=======
		super.passTest("checkLogoutLabel", pageName);
		super.testLogger().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 3)
	public void checkPageHeaderText() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader());
=======
		super.passTest("checkPageHeaderText", pageName);
		super.testLogger().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 4)
	public void checkAllCoursesHeaderText() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders());
=======
		super.passTest("checkAllCoursesHeaderText", pageName);
		super.testLogger().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 5)
	public void checkNumberOfCourses() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses());
=======
		super.passTest("checkNumberOfCourses", pageName);
		super.testLogger().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 6)
	public void checkAllCourseslinksClickable() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable());
=======
		super.passTest("checkAllCourseslinksClickable", pageName);
		super.testLogger().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}

	@Test(priority = 7)
	public void checkAllCoursesNames() {
<<<<<<< HEAD
		super.testLoggerLog4j().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames());
=======
		super.passTest("checkAllCoursesNames", pageName);
		super.testLogger().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames(testlogger));
>>>>>>> branch 'master' of https://github.com/surabhinaik1011/OfflineWebSite
	}
	
	
	
}
