package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;

public class RegistrationTest extends TestBase {

	RegistrationPage register = null;

	// Extent Report Variables
	String pageName = "REGISTRATION PAGE TESTCASES";
	String extentReprtName = "RegistrationPageExtentReport";
	String hostName = "Offline Website";
	String environment = "Registration Page Testing";
	String uName = "ketaki chalse";
	String docTitle = "RegistrationPage";
	String reportName = "RegistrationPageExtentReport ";

}
