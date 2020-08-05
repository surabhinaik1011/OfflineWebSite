package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.pages.DashBoardPage;
import com.pages.DownloadPage;
import com.pages.LoginPage;

public class DownloadTest extends TestBase {

	WebDriver driver = null;
	DownloadPage dp = null;
	DownloadPage dwp = null;
	DashBoardPage dashPage = null;
	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("Downlaod TestCases");
	}

	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver = super.launchApplication();
		LoginPage llp = new LoginPage(driver);
		dp = llp.NavigateToDashboard().navigateToDownloadPage();
		dp = new DownloadPage(driver);
	}

	@Test(priority = 1)
	public void validateCounOfHeaderColumns() throws Exception {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateCounOfHeaderColumns"); // Test
																											// Create
		Assert.assertTrue(dp.validateHeaderCount(extentTest));
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void validateNoOfRowColumn() throws Exception {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateNoOfRowColumn"); // Test
																										// Create
		Assert.assertTrue(dp.checkTotalRowColNum(extentTest));
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void validateFollowVender() throws Exception {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateFollowVender");
		Assert.assertTrue(dp.checkFollowVender(extentTest));
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void check32bitLink() throws Exception {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: check32bitLink");
		Assert.assertTrue(dp.checkLink32bitClickable(extentTest));
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void check64bitLink() throws Exception {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: check64bitLink");
		Assert.assertTrue(dp.checkLink64bitClickable(extentTest));
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void checkOfficialWebsite() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkOfficialWebsite");
		Assert.assertTrue(dp.checkOfficialWebsiteClickable(extentTest));
	}

	@Test(priority = 8)
	public void validateVendorsNumberListSequence() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateVendorsNumberListSequence");
		Assert.assertTrue(dp.checkVendorListIsSort(extentTest));
	}

	@Test(priority = 9)
	public void validateSrNumberListSequence() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateSrNumberListSequence");
		Assert.assertTrue(dp.checkSrNumberListInSort(extentTest));
	}

	@Test(priority = 10)
	public void validateStartWithVendorName() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateStartWithVendorName");
		Assert.assertTrue(dp.checkVendorStartWith(extentTest));
	}
}
