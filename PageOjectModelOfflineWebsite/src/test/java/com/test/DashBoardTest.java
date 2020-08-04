package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.DownloadPage;
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

	@Test(priority = 1)
	public void checkTitle() {
		super.testLoggerLog4j().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage());
	}

	@Test(priority = 2)
	public void checkLogoutLabel() {
		super.testLoggerLog4j().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel());
	}

	@Test(priority = 3)
	public void checkPageHeaderText() {
		super.testLoggerLog4j().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader());
	}

	@Test(priority = 4)
	public void checkAllCoursesHeaderText() {
		super.testLoggerLog4j().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders());
	}

	@Test(priority = 5)
	public void checkNumberOfCourses() {
		super.testLoggerLog4j().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses());
	}

	@Test(priority = 6)
	public void checkAllCourseslinksClickable() {
		super.testLoggerLog4j().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable());
	}

	@Test(priority = 7)
	public void checkAllCoursesNames() {
		super.testLoggerLog4j().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames());
	}
	
	
	
}
