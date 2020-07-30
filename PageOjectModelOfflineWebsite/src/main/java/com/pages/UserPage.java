package com.pages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UserPage {
	
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

	public String validateAdduser() throws InterruptedException {
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
		System.out.println(driver.switchTo().alert().getText());
		String sucessString = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return sucessString;
	}

	public boolean countStateTest() {
		cityData = driver.findElements(By.xpath("//select //option"));
		System.out.println(cityData.size());
		if (cityData.size() == 5) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateAddUserButtonEnabled(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'users.html')]")).click();
		Thread.sleep(1000);
		WebElement addButton = driver.findElement(By.xpath("//a[contains(@href,'add_user.html')] //button"));
		if (addButton.isEnabled()) {
			 addButton.click();
			return true;
		} else {
			return false;
		}

	}

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

	public boolean validateAddUserTitle(WebDriver driver2) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("JavaByKiran | Add User")) {
			return true;
		} else {
			return false;
		}
	}

	List<WebElement> sizeButton = new ArrayList<>();

	public boolean countAddUserTableData() {
		Cancel();
		int count = 0;
		int size = driver.findElements(By.xpath("//table//tbody//tr")).size();
		
		for (int i = 0; i < size; i++) {			
			if (driver.findElements(By.xpath("//table//tbody//tr["+i+"]//td//a")).contains("Delete")) {
				count++;
			}
		}
		if (count == 5) {
			System.out.println("Return True");
			return true;
		} else {
			System.out.println("Return false");
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
