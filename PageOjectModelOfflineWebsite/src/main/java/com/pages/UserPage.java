package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UserPage extends BasePage {

	public static WebDriver driver;
	List<WebElement> cityData;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	@FindBy(id = "mobile")
	private WebElement mobile;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Java/J2EE']")
	private WebElement course;
	@FindBy(id = "Male")
	private WebElement gender;
	@FindBy(xpath = "//div[@class='form-group']//select")
	private WebElement SelectSate;
	@FindBy(xpath = "//select //option")
	private WebElement city;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//a[contains(@href,'add_user.html')] //button")
	private WebElement adduser;
	@FindBy(id = "submit")
	private WebElement submit;
	@FindBy(xpath = "//div[@class='box-footer']//span[1]")
	private WebElement Cancel;

	public void userNames() {
		userName.sendKeys(getnames());
	}

	public void mobile() {
		mobile.sendKeys(getMobile());
	}

	public void email() {
		email.sendKeys(getEmail());
	}

	public void course() {
		course.sendKeys(getCourse());
	}

	public void gender() {
		gender.click();
	}

	public void SelectSate() {
		SelectSate.click();
	}

	public void password() {
		password.sendKeys(getPassword());
	}

	public void submit() {
		submit.click();
	}

	public void Cancel() {
		Cancel.click();
	}

	public void city(WebDriver driver) throws InterruptedException {
		cityData = driver.findElements(By.xpath("//select //option"));
		System.out.println(cityData.size());
		for (int i = 0; i < cityData.size() - 1; i++) {
			if (cityData.get(i).getText().equalsIgnoreCase("HP")) {
				Thread.sleep(2000);
				cityData.get(i).click();
				break;
			}
		}
	}

	public boolean validateAdduser(ExtentTest extentTest) throws InterruptedException {
		super.pageLogger().info("Enter the validateAdduser Method");
		Thread.sleep(1000);
		userNames();
		mobile();
		email();
		course();
		gender();
		SelectSate();
		city(driver);
		password();
		submit();
		
		String sucessString = driver.switchTo().alert().getText();
		//System.out.println(sucessString);
		if (sucessString.equalsIgnoreCase("User Added Successfully. You can not see added user.")) {
			driver.switchTo().alert().accept();
			super.pageLogger().info("User Add Sucessfully testcase is passed");
			extentTest.log(Status.PASS, "User Add Sucessfully testcase is passed");
			return true;
		} else {
			super.pageLogger().info("User Add Sucessfully testcase is Failed");
			extentTest.log(Status.FAIL, "User Add Sucessfully testcase is Failed");
			return false;
		}

	}

	/*
	 * public boolean validateAddUserButtonEnabled(WebDriver driver) throws
	 * InterruptedException { // Thread.sleep(4000);
	 * //driver.findElement(By.xpath("//a[contains(@href,'users.html')]")).click();
	 * Thread.sleep(4000); WebElement addButton =
	 * driver.findElement(By.xpath("//a[contains(@href,'add_user.html')] //button"))
	 * ; if (addButton.isEnabled()) { addButton.click(); return true; } else {
	 * return false; }
	 * 
	 * }
	 */
	public String getnames() {
		return "mayur talan";
	}

	public String getMobile() {
		return "887788888";
	}

	public String getEmail() {
		return "kk@gmail.com";
	}

	public String getCourse() {
		return "Java";
	}

	public String getPassword() {
		return "1813344";
	}

	public boolean validateAddUserTitle(WebDriver driver2, ExtentTest extentTest) throws InterruptedException {
		Thread.sleep(5000);
		super.pageLogger().info("Enter the validateAddUserTitle Method");
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("JavaByKiran | Add User")) {
			super.pageLogger().info("Valid the JavaByKiran | Add User Title");
			extentTest.log(Status.PASS, "Validate AddUser Title test is passed");
			return true;
		} else {
			super.pageLogger().info("InValid Add user");
			extentTest.log(Status.FAIL, "Validate AddUser Title test is Failed");
			return false;
		}
	}

	List<WebElement> sizeButton = new ArrayList<>();

	public boolean countAddUserTableData(ExtentTest extentTest) throws InterruptedException {
		super.pageLogger().info("Enter the countAddUserTableData Method");
		Cancel();
		Thread.sleep(2000);
		int count = 0;
		int size = driver.findElements(By.xpath("//table//tbody//tr")).size();

		for (int i = 0; i < size; i++) {
			if (driver.findElements(By.xpath("//table//tbody//tr[" + i + "]//td//a")).contains("Delete")) {
				count++;
			}
		}
		if (count == 5) {
			super.pageLogger().info("Count AddUserTableData is Valid");
			extentTest.log(Status.PASS, "Count AddUser TableData is passed");
			return true;
		} else {
			super.pageLogger().info("Count AddUserTableData is Invalid");
			extentTest.log(Status.FAIL, "Count AddUser TableData is Failed");
			return false;
		}

	}

	public boolean countStateTest(ExtentTest extentTest) {
		super.pageLogger().info("Enter the countStateTest Method");
		cityData = driver.findElements(By.xpath("//select //option"));
		System.out.println(cityData.size());
		if (cityData.size() == 5) {
			super.pageLogger().info("Count StateTest is Passed");
			extentTest.log(Status.PASS, "Count StateTest is passed");
			return true;
		} else {
			super.pageLogger().info("Count StateTest is Failed");
			extentTest.log(Status.FAIL, "Count StateTest is Failed");
			return false;
		}
	}

	/*
	 * public boolean navigateToDashboard() throws InterruptedException {
	 * driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	 * driver.findElement(By.id("password")).sendKeys("123456");
	 * driver.findElement(By.xpath("//button[text()='Sign In']")).click(); return
	 * navigateToUserPage(driver); }
	 * 
	 */

}
