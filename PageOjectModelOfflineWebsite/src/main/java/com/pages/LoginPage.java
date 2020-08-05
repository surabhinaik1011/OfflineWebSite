package com.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage {
	// All WebElements.
	@FindBy(id = "email")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='I already have a membership']")
	private WebElement alreadymember;

	@FindBy(xpath = "//a[text()='Register a new membership']")
	private WebElement regLink;

	@FindBy(tagName = "b")
	private WebElement websiteName;

	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement LoginMsg;

	@FindBy(xpath = "//a[text()='LOGOUT']")
	private WebElement logout;

	@FindBy(xpath = "//p[text()='Logout successfully']")
	private WebElement LogoutMsg;

	@FindBy(xpath = "//div[text()='Please enter email.']")
	private WebElement ErrorMsgForInvalidMail;

	public  WebDriver driver;
	Properties prop = null;
	FileInputStream fis = null;

	public String geturl() {
		return driver.getCurrentUrl();
	}

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String typeUserName(String uName) {
		username.clear();
		username.sendKeys(uName);
		return uName;
	}

	public void typePassword(String pass) {
		password.clear();
		password.sendKeys(pass);

	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public LoginPage clickLogoutButton() {
		logout.click();
		return new LoginPage(driver);
	}

	public DashBoardPage NavigateToDashboard() {
		typeUserName("kiran@gmail.com");
		typePassword("123456");
		loginButton.click();
		return new DashBoardPage(driver);
	}

	public DashBoardPage VerifyCorrectLoginCred() {
		typeUserName("kiran@gmail.com");
		typePassword("123456");
		loginButton.click();
		return new DashBoardPage(driver);
	}

	public RegistrationPage clickOnRegLink() {
		regLink.click();
		return new RegistrationPage(driver);
	}

	public LoginPage clickOnalreadymemberLink() {
		alreadymember.click();
		return new LoginPage(driver);
	}

	public boolean navigateToLoginFromReg(ExtentTest extenttest) {
		clickOnRegLink();
		clickOnalreadymemberLink();
		extenttest.log(Status.INFO, "navigateToLoginFromReg..");
		if (driver.getTitle().equals("JavaByKiran | Log in")) {
			super.pageLogger().info("Navigated to login page from registration page.");
			System.out.println("Navigated to login page from registration page.");
			return true;
		} else
			super.pageLogger().info("Should navigate to login page from registration page.");
		System.out.println("Should navigate to login page from registration page.");
		return false;
	}

	public boolean checkTitle(ExtentTest extenttest) {
		extenttest.log(Status.INFO, "Checking Title..");
		if (driver.getTitle().equals("JavaByKiran | Log in")) {
			super.pageLogger().info("We are on Login Page!!");
			extenttest.log(Status.PASS, "We are on Login Page!!");
			return true;
		} else {
			super.pageLogger().info("We should be on Login Page!!");
			extenttest.log(Status.PASS, "We should be on Login Page!!");
			return false;
		}
	}

	public boolean checkTitleOfDashBoard(ExtentTest testlogger) {
		if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
			super.pageLogger().info("Login successfully-----We are on Dashboard!!");
			System.out.println("Login successfully-----We are on Dashboard!!");
			return true;
		} else {
			super.pageLogger().info("We Should be on Dashboard!!");
			System.out.println("We Should be on Dashboard!!");
			return false;
		}
	}

	public boolean checkURL(ExtentTest extenttest) {
			extenttest.log(Status.INFO, "URL is checking...");
		if (geturl().equals("D:/website/Offline Website/index.html")) {
			super.pageLogger().info("URL is correct");
			extenttest.log(Status.PASS, "URL is correct");

			return true;
		} else {
			super.pageLogger().info("Please Enter Valid URL");
			extenttest.log(Status.FAIL, "URL is incorrect");
			return false;
		}
	}

	public boolean checkHeading(ExtentTest extenttest) {
		String actHeading = websiteName.getText();
		if (actHeading.equals("Java By Kiran")) {
			extenttest.log(Status.INFO, "Checking Heading");
			super.pageLogger().info("Heading is -Java By Kiran ");
			System.out.println("Heading is -Java By Kiran ");
			extenttest.log(Status.PASS, "Heading -Java By Kiran is correct");
			return true;
		} else {
			super.pageLogger().info("Heading is invalid. It should be- Java By Kiran");
			System.out.println("Heading is invalid. It should be- Java By Kiran");
			extenttest.log(Status.FAIL, "Heading -Java By Kiran is incorrect");
			return false;
		}

	}

	public boolean checkLoginMsg(ExtentTest extenttest) {
		String loginmsg = LoginMsg.getText();
		if (loginmsg.equals("Sign in to start your session")) {
			extenttest.log(Status.INFO, "Checking LoginMSG");
			super.pageLogger().info("Login msg- Sign in to start your session is displayed correctly.");
			System.out.println("Login msg- Sign in to start your session is displayed correctly.");
			extenttest.log(Status.PASS, "Login msg- Sign in to start your session is displayed correctly.");
			return true;
		}else{
			super.pageLogger().info("Loginmsg should display as- 'Sign in to start your session'");
			System.out.println("Loginmsg should display as- 'Sign in to start your session'");
			extenttest.log(Status.FAIL, "Loginmsg should display as- 'Sign in to start your session'");
			return false;
		}
	}

	public boolean navigateToLoginFromDashboard(ExtentTest testlogger) {

		if (LogoutMsg.getText().equals("Logout successfully")) {
			super.pageLogger().info("Navigation between login and Dashboard page is proper!");
			System.out.println("Navigation between login and Dashboard page is proper!");
			return true;
		} else {
			super.pageLogger().info("check navigation between login and Dashboard page!!");
			System.out.println("check navigation between login and Dashboard page!!");
			return false;
		}

	}

	// NavigationBetDashboardAndLogin
	public void navigationBetDashboardAndLogin() {
		if (driver.getTitle().equals("JavaByKiran | Log in")) {
			super.pageLogger().info("Now on login Page.");
			super.pageLogger().info("Should navigate to Dashboard Page And then click on Logout Button");
			typeUserName("kiran@gmail.com");
			typePassword("123456");
			loginButton.click();
			clickLogoutButton();

		} else if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
			super.pageLogger().info("click on Logout Button");
			clickLogoutButton();

		}

	}

	DownloadPage navigateToDownLoapPage() {
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[6]/a/span")).click();
		return new DownloadPage(driver);
	}

	public boolean checkErrorMessage(ExtentTest extenttest) {

		if (ErrorMsgForInvalidMail.getText().equals("Please enter email.")) {
			super.pageLogger().info("Invalid login Cred entered.");
			System.out.println("Invalid login Cred entered.");
			return true;
		} else {
			super.pageLogger().info("Error msg should be displayed as--'Please enter email.'");
			System.out.println("Error msg should be displayed as--'Please enter email.'");
			return false;
		}
	}

}
