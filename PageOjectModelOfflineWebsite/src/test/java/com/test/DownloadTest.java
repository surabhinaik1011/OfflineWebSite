package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.DashBoardPage;
import com.pages.DownloadPage;
import com.pages.LoginPage;

public class DownloadTest extends TestBase {

	WebDriver driver = null;
	DownloadPage dp = null;
	DownloadPage dwp = null;
	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("Downlaod TestCases");
	}

	@BeforeMethod
	public void loadUrl() throws Throwable {
		dp = loadLoginpage().NavigateToDashboard().navigateToDownloadPage();
		dwp = new DownloadPage(driver);
	}

	@Test(priority = 1)
	public void validateCounOfHeaderColumns() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateCounOfHeaderColumns");
		extentTest.info("Validate total numaber of headers:");
		testcaseLogs().info("validateCounOfHeaderColumns");
		Assert.assertTrue(dp.validateHeaderCount(extentTest));
	}

	@Test(priority = 2)
	public void validateNoOfRowColumn() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateNoOfRowColumn");
		extentTest.info("Validate total numaber of col and rows:");
		testcaseLogs().info("validateNoOfRowColumn");
		Assert.assertTrue(dp.checkTotalRowColNum(extentTest));
	}

	@Test(priority = 3)
	public void validateFollowVender() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateFollowVender");
		extentTest.info("Validate following vendor:");
		testcaseLogs().info("validateFollowVender");
		Assert.assertTrue(dp.checkFollowVender(extentTest));
	}

	@Test(priority = 4)
	public void check32bitLink() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: check32bitLink");
		extentTest.info("Validate 32bit link link clickable:");
		testcaseLogs().info("check32bitLink");
		Assert.assertTrue(dp.checkLink32bitClickable(extentTest));
	}

	@Test(priority = 5)
	public void check64bitLink() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: check64bitLink");
		extentTest.log(Status.INFO, "Validate 64bit link link clickable:");
		testcaseLogs().info("check64bitLink");
		Assert.assertTrue(dp.checkLink64bitClickable(extentTest));
	}

	@Test(priority = 6)
	public void checkOfficialWebsite() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: checkOfficialWebsite");
		extentTest.info("Validate official website link clickable:");
		testcaseLogs().info("checkOfficialWebsite");
		Assert.assertTrue(dp.checkOfficialWebsiteClickable(extentTest));
	}

	@Test(priority = 8)
	public void validateVendorsNumberListSequence() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateVendorsNumberListSequence");
		extentTest.info("Validate Name in ascending orderd:");
		testcaseLogs().info("validateVendorsNumberListSequence");
		Assert.assertFalse(dp.checkVendorListIsSort(extentTest));
	}

	@Test(priority = 9)
	public void validateSrNumberListSequence() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateSrNumberListSequence");
		extentTest.info("Validate total numabers in sequence:");
		testcaseLogs().info("validateSrNumberListSequence");
		Assert.assertTrue(dp.checkSrNumberListInSort(extentTest));
	}

	@Test(priority = 10)
	public void validateStartWithVendorName() {
		ExtentTest extentTest = extenttestPerPage.createNode("test case  :: validateStartWithVendorName");
		extentTest.info("Validate vendors name start with Google:");
		testcaseLogs().info("validateStartWithVendorName");
		Assert.assertTrue(dp.checkVendorStartWith(extentTest));
	}
}
