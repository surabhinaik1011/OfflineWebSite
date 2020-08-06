package com.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.LoginPage;

public class TestBase {

	public static WebDriver driver;
	Properties prop = null;
	FileInputStream fis = null;

	// Globle variables for ExtentReport

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest testlogger;
	ITestResult result;
	// Extent Report Variables
	String extentReprtName = "ExtentReportForOfflineWebSite";
	String hostName = "Offline Website";
	String environment = "QA";
	String uName = "Kiran";
	String docTitle = "Test results";
	String reportName = "ProjectsExtentReport ";

	static Logger logger;

	String readAnyProperty(String propFileName, String propName) {
		String val = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/config.properties");
			prop = new Properties();
			prop.load(fis);
			val = prop.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	public WebDriver launchApplication() throws Throwable {
		String URL = readAnyProperty("config.properties", "url");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}

	public void CloseLaunchApplication() {
		driver.close();
	}

	// Ashwini code started for extent report.
	// 28 july 2020
	@BeforeSuite
	public void setReport() {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/" + extentReprtName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", hostName);
		extent.setSystemInfo("Environment", environment);
		extent.setSystemInfo("User Name", uName);

		htmlReporter.config().setDocumentTitle(docTitle);
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

	@BeforeTest
	public void beforeTest1() {
		testlogger = extent.createTest("ALl Pages", "All Pages Test Cases");
	}

	@AfterTest
	public void afterTest() {
	}
	@AfterMethod
	public void closeBrowser() {
		 CloseLaunchApplication();
	}
	/*
	 * Log4j and loadloginpage method added by Utkarsh on 6/08/20
	 */
	public Logger testcaseLogs(){
		logger = Logger.getLogger(this.getClass());
	    String path = (System.getProperty("user.dir")+"/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return logger;
	}

	public LoginPage loadLoginpage(){
		try {
			driver=launchApplication();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
}
