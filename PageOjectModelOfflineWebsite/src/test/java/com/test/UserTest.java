package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase {
	public WebDriver driver;
	UserPage u;
	DashBoardPage dpage;
	LoginPage lp;
	TestBase testbase = new TestBase();

	@BeforeMethod
	public void setupBrowser() throws Throwable {
		driver = super.launchApplication();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		dpage = lp.NavigateToDashboard();
		dpage = new DashBoardPage(driver);
		u = dpage.navigateDriver();
		u.validateAddUserButtonEnabled(driver);
	}

	@Test()
	public void validateAddUserButtonEnabled() {
		try {
			Assert.assertTrue(u.validateAddUserButtonEnabled(driver));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void validateAddUserTitle() {
		try {
			Assert.assertTrue(u.validateAddUserTitle(driver));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void validateAddUserTest() throws InterruptedException {
		Assert.assertEquals("User Added Successfully. You can not see added user.", u.validateAdduser());
	}

	@Test(priority = 4)
	public void countStateTest() {
		Assert.assertTrue(u.countStateTest());
	}

	@Test(priority = 5)

	public void countAddUserfromTable() throws InterruptedException {
		Assert.assertTrue(u.countAddUserTableData());
	}

	@AfterMethod
	public void closeDriver() {
		super.CloseLaunchApplication();
	}

}
