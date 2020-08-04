package com.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.DashBoardPage;
import com.pages.DownloadPage;
import com.pages.LoginPage;

public class DownloadTest extends TestBase {

	WebDriver driver = null;
	DownloadPage dp = null;
	DownloadPage dwp=null;
	DashBoardPage dashPage=null;
	
	
	
	ExtentTest extenttestPerPage = null;

	@BeforeClass()
	public void beforeTest() {
		extenttestPerPage = testlogger.createNode("Downlaod TestCases");
	}
	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver=super.launchApplication();
		LoginPage llp=new LoginPage(driver);
		dp=llp.NavigateToDashboard().navigateToDownloadPage();
		dp = new DownloadPage(driver);
	}


	@Test(priority = 1)
	public void validateCounOfHeaderColumns() throws Exception {
		ExtentTest extentTest=extenttestPerPage.createNode("test case  :: validateCounOfHeaderColumns");														// Test Create
		Assert.assertTrue(dp.validateHeaderCount(extentTest));
		Thread.sleep(3000);
	}

/*	@Test(priority = 2)
	public void validateNoOfRowColumn() throws Exception {
		ExtentTest extentTest=testlogger.createNode("test case  :: validateNoOfRowColumn");														// Test Create
		Assert.assertTrue(dp.checkTotalRowColNum(extentTest));
		Thread.sleep(3000);
	}*/
/*
	@Test(priority = 3)
	public void validateFollowVender() throws Exception {
		//super.passTest("validateFollowVender", pageName);
		Assert.assertTrue(dp.checkFollowVender(testlogger));
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void check32bitLink() throws Exception {
		//super.passTest("check32bitLink", pageName);
		Assert.assertTrue(dp.checkLink32bitClickable(testlogger));
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void check64bitLink() throws Exception {
		//super.passTest("check64bitLink", pageName);
		Assert.assertTrue(dp.checkLink64bitClickable(testlogger));
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void checkOfficialWebsite() {
		//super.passTest("CheckOfficialWebsite", pageName);
		Assert.assertTrue(dp.checkOfficialWebsiteClickable(testlogger));
	}

	@Test(priority = 8)
	public void validateVendorsNumberListSequence() {
		//super.passTest("ValidateVendorsNumberListSequence", pageName);
		Assert.assertTrue(dp.checkVendorListIsSort(testlogger));
	}

	@Test(priority = 9)
	public void validateSrNumberListSequence() {
		//super.passTest("ValidateSrNumberListSequence", pageName);
		Assert.assertTrue(dp.checkSrNumberListInSort(testlogger));
	}

	@Test(priority = 10)
	public void validateStartWithVendorName() {
		//super.passTest("ValidateStartWithVendorName", pageName);
		Assert.assertTrue(dp.checkVendorStartWith(testlogger));
	}*/
}
