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
	//	testLoggerLog4j().info( "Browser Closed");
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
	//	super.setReport(extentReprtName, hostName, environment, uName, docTitle, reportName);
	}

	@AfterTest
	public void afterTest() {
		super.endReport();
	}

	
}
