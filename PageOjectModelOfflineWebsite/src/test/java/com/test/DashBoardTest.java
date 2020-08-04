package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashBoardTest extends TestBase {
	DashBoardPage dp;
	LoginPage lp;

	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeclass() {
		extenttestPerPage = testlogger.createNode("DashBoard TestCases");
	}
	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver=super.launchApplication();
		lp =new LoginPage(driver);

		dp=lp.NavigateToDashboard();
	}
	
	@Test(priority = 1)
	public void checkTitle() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkTitle");
		super.testcaseLogs().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage(extentTest));
	}

	@Test(priority = 2)
	public void checkLogoutLabel() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkLogoutLabel");
		super.testcaseLogs().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel(extentTest));
	}

	@Test(priority = 3)
	public void checkPageHeaderText() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkPageHeaderText");
		super.testcaseLogs().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader(extentTest));
	}

	@Test(priority = 4)
	public void checkAllCoursesHeaderText() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCoursesHeaderText");
		super.testcaseLogs().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders(extentTest));
	}

	@Test(priority = 5)
	public void checkNumberOfCourses() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkNumberOfCourses");
		super.testcaseLogs().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses(extentTest));
	}

	@Test(priority = 6)
	public void checkAllCourseslinksClickable() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCourseslinksClickable");
		super.testcaseLogs().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable(extentTest));
	}

	@Test(priority = 7)
	public void checkAllCoursesNames() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCoursesNames");
		super.testcaseLogs().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames(extentTest));
	}
	

	
}
