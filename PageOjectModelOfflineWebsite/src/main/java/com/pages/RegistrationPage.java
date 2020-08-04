package com.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class RegistrationPage extends BasePage {
	WebDriver driver;

	@FindBy(linkText = "Register a new membership")
	private WebElement registerMember;

	@FindBy(id = "name")
	private WebElement name;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button")
	public WebElement signinButton;

	@FindBy(xpath = "//b")
	private WebElement heading;

	@FindBy(linkText = "I already have a membership")
	private WebElement alreadyMember;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean validateRegistraionLink(ExtentTest logger) {
		super.pageLogger().info("validation of Registration Link");
		try {
			registerMember.click();
			logger.log(Status.PASS, "Registration Clickable");
			return true;
		} catch (Throwable e) {
			logger.log(Status.FAIL, "Registration UnClickable");
			return false;
		}
	}

	public void EnterName() {
		registerMember.click();
		name.sendKeys("ketaki");
	}

	public void EnterMobile() {
		mobile.sendKeys("9864376239");
	}

	public void EnterEmail() {
		email.sendKeys("ketaki@gmail.com");
	}

	public void EnterPassword() {
		password.sendKeys("12345");
	}

	public boolean validateAlertMessage(ExtentTest logger) {
		super.pageLogger().info("Enter the new member details and accept alert");
		try {
			signinButton.click();
			Alert al = driver.switchTo().alert();
			al.accept();
			logger.log(Status.PASS, "Signin successfully and accept alert");
			return true;
		} catch (Throwable e) {
			logger.log(Status.FAIL, "Failed to SignIn");
			return false;
		}
	}

	public boolean getTitleOfRegistrationPage(ExtentTest logger) {
		super.pageLogger().info("validation of Registration Page Title");
		try {
			registerMember.click();
			if (driver.getTitle().equals("JavaByKiran | Registration Page")) {
				logger.log(Status.PASS, "Title match");
			} else {
				logger.log(Status.FAIL, "Title mismatch");
			}
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean getTextOfHeading(ExtentTest logger) {
		super.pageLogger().info("validation of Heading of registration page");
		try{
			registerMember.click();
			if (heading.getText().equals("Java By Kiran")) {
				logger.log(Status.PASS, "Heading match");
			} else {
				logger.log(Status.FAIL, "Heading mismatch");
			}
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean validateNoOfTextBoxes(ExtentTest logger) {
		super.pageLogger().info("validation of Total No of Textbox on Registration page");
		try {
			registerMember.click();
			List<WebElement> textboxList = driver.findElements(By.tagName("input"));
			if (textboxList.size() == 4) {
				logger.log(Status.PASS, "Total no of text box is correct");
			} else {
				logger.log(Status.FAIL, "Total no of text box is Incorrect");
			}
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean validationOfAlreadyMemberLink(ExtentTest logger) {
		super.pageLogger().info("validation of I already have a memberhip link");
		try {
			alreadyMember.click();
			logger.log(Status.PASS, "Click successfully to I already have a membership");
			return true;
		} catch (Throwable t) {
			logger.log(Status.FAIL, "Unclickable to I already have a membership ");
			return false;
		}
	}

	public boolean validationOfMembership(ExtentTest logger) {
		super.pageLogger().info("validate if member already exist or not");
		try {
			registerMember.click();
			if (validationOfAlreadyMemberLink(logger) == true) {
				driver.getTitle().equals("JavaByKiran | Log in");
			} else {
				logger.log(Status.FAIL, "Not return to Login page");
			}
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
}
