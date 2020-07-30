package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase {
	public WebDriver driver;
	UserPage u;
	DashBoardPage dp;
	LoginPage lp;
	// TestBase testbase = new TestBase();

	@BeforeTest
	public void setupBrowser() throws Throwable {
		/*
		 * System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		 * driver = new ChromeDriver();
		 * driver.get("file:///D:/website/Offline%20Website/index.html");
		 */
		// driver.manage().window().maximize();
		// testbase.launchApplication();
		driver = super.launchApplication();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		dp = lp.NavigateToDashboard();
		dp = new DashBoardPage(driver);
		u = dp.getDriver();

	}

	@Test()
	public void validateAddUserButtonEnabled() {
		try {
			Assert.assertTrue(u.validateAddUserButtonEnabled(driver));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)

	public void countAddUserfromTable() {
		Assert.assertTrue(u.countAddUserTableData());
	}

	@Test(priority = 2)
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

	
	  @AfterTest 
	  public void closeDriver() { driver.close(); }
	 

}
