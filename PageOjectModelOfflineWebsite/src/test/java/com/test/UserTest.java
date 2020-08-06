package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.DashBoardPage;
import com.pages.DownloadPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase {

	UserPage u = null;
	ExtentTest extenttestPerPage = null;
	// DashBoardPage dpage;
	// LoginPage lp;
	// TestBase testbase = new TestBase();

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("UserTest TestCases");
	}

	@BeforeMethod
	public void loadUrl() throws Throwable {
		u = loadLoginpage().NavigateToDashboard().navigateDriver();
		u = new UserPage(driver);
	}

	@Test(priority = 1)
	public void validateAddUserTitle() {
		try {
			ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateAddUserTitle");
			extentTest.info("validateAddUserTitle testcase is up and running");
			testcaseLogs().info("Running validateAddUserTitle");
			Assert.assertTrue(u.validateAddUserTitle(driver, extentTest));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void validateAddUserTest() throws InterruptedException {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateAddUserTest");
		extentTest.info("validateAddUserTest testcase is up and running");
		testcaseLogs().info("Running validateAddUserTest");
		Assert.assertTrue(u.validateAdduser(extentTest));
	}

	@Test(priority = 3)
	public void countStateTest() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: countStateTest");
		extentTest.info("countStateTest testcase is up and running");
		testcaseLogs().info("Running countStateTest");
		Assert.assertTrue(u.countStateTest(extentTest));
	}

	@Test(priority = 4)
	public void countAddUserfromTable() throws InterruptedException {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: countAddUserfromTable");
		extentTest.info("countAddUserfromTable testcase is up and running");
		testcaseLogs().info("Running countAddUserfromTable");
		Assert.assertTrue(u.countAddUserTableData(extentTest));
	}

	/*
	 * @Test() public void validateAddUserButtonEnabled() { try {
	 * Assert.assertTrue(u.validateAddUserButtonEnabled(driver)); } catch
	 * (InterruptedException e) { e.printStackTrace(); } }
	 */

	// @BeforeMethod
	// public void setupBrowser() throws Throwable {
	// driver = super.launchApplication();
	// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// lp = new LoginPage(driver);
	// dpage = lp.NavigateToDashboard();
	// dpage = new DashBoardPage(driver);
	// u = dpage.navigateDriver();
	// u.validateAddUserButtonEnabled(driver);
	// }

}
