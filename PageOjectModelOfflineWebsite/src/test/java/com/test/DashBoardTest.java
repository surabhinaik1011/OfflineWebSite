package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.DashBoardPage;

public class DashBoardTest extends TestBase {
	DashBoardPage dp;
	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeclass() {
		extenttestPerPage = testlogger.createNode("DashBoard TestCases");
	}
	@BeforeMethod
	public void loadUrl() throws Throwable {
		dp = loadLoginpage().NavigateToDashboard();
		dp = new DashBoardPage(driver);
	}
	
	@Test(priority = 1)
	public void checkTitle() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkTitle");
		extentTest.info("checkTitle testcase is up and running");
		testcaseLogs().info("Running checkTitle");
		Assert.assertTrue(dp.verifyTitleOfPage(extentTest));
	}

	@Test(priority = 2)
	public void checkLogoutLabel() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkLogoutLabel");
		extentTest.info("checkLogoutLabel testcase is up and running");
		testcaseLogs().info("Running checkLogoutLabel");
		Assert.assertTrue(dp.verifyLogoutLabel(extentTest));
	}

	@Test(priority = 3)
	public void checkPageHeaderText() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkPageHeaderText");
		extentTest.info("checkPageHeaderText testcase is up and running");
		testcaseLogs().info("Running checkPageHeaderText");
		Assert.assertTrue(dp.verifyHeader(extentTest));
	}

	@Test(priority = 4)
	public void checkAllCoursesHeaderText() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCoursesHeaderText");
		extentTest.info("checkAllCoursesHeaderText testcase is up and running");
		testcaseLogs().info("Running checkAllCoursesHeaderText");
		Assert.assertTrue(dp.verifyCourseHeaders(extentTest));
	}

	@Test(priority = 5)
	public void checkNumberOfCourses() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkNumberOfCourses");
		extentTest.info("checkNumberOfCourses testcase is up and running");
		testcaseLogs().info("Running checkNumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses(extentTest));
	}

	@Test(priority = 6)
	public void checkAllCourseslinksClickable() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCourseslinksClickable");
		extentTest.info("checkAllCourseslinksClickable testcase is up and running");
		testcaseLogs().info("Running checkAllCourseslinksClickable");
		Assert.assertTrue(dp.verifyAllCourseslinksClickable(extentTest));
	}

	@Test(priority = 7)
	public void checkAllCoursesNames() {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: checkAllCoursesNames");
		extentTest.info("checkAllCoursesNames testcase is up and running");
		testcaseLogs().info("Running checkAllCoursesNames");
		Assert.assertTrue(dp.verifyCourseNames(extentTest));
	}
	
}
