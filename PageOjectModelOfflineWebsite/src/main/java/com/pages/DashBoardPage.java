package com.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jxl.Sheet;
import jxl.Workbook;

public class DashBoardPage  extends BasePage {
	WebDriver driver;
	//public static Logger log=Logger.getLogger(DashBoardPage.class);
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// all web element //section[@class='content']
	// all actions
	// all varifications
	// all navigations

	@FindBy(linkText = "LOGOUT")
	private WebElement logoutLable;

	@FindBy(xpath = "//div//child::h1//small[contains(text(),'Courses Offered')]")
	private WebElement dashboardHeader;

	@FindBy(xpath = "//section[@class='content']//a")
	private List<WebElement> courselinks;

	@FindBy(xpath = "//div//h3")
	private List<WebElement> courseHeaders; 

	@FindBy(xpath ="//div//h3//following::p")
	private List<WebElement> coursenames;
	
	public DashBoardPage navigateToDashBoardPage(WebDriver driver) {
		super.pageLogger().info("navigate to Dashboard page method is entered.");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		super.pageLogger().info("clicked");
		super.pageLogger().info("navigate to Dashboard page method is exiting...");
		return new DashBoardPage(driver);
	}

	public String getTitleofPage() {
		return driver.getTitle();

	}

	public boolean verifyTitleOfPage() {
		 //test1.log(Status.PASS,"test pass");
		//---
		try {
			super.pageLogger().info("Entering into verifytitleofpage method");
			if (getTitleofPage().equals("JavaByKiran | Dashboard")) {
				//test1.log(Status.PASS,"Verified title of page successfully");
				return true;

			} else {
				//test1.log(Status.FAIL,"VerifyTitleOfPage fails");
				return false;
			}
		} catch (Throwable t) {
			//test1.log(Status.FATAL,"VerifyTitleOfPage method fails due to exception");
			return false;
			
		}
		
	}

	public String getLabelLogout() {
		
		return logoutLable.getText();
	}

	public boolean verifyLogoutLabel() {
		
		super.pageLogger().info("Entering into LogoutLabel method");
		try {
			

			if (getLabelLogout().equals("LOGOUT")) {
			//	test1.log(Status.PASS,"checkLogoutLabel testcase is passed");
				return true;

			} else {
				//test1.log(Status.FAIL,"checkLogoutLabel testcase is failed");
				return false;
			}
		} catch (Throwable t) {
			//test1.log(Status.FATAL,"Verifylogoutlabel method failed due to exception");
			return false;
		}
		
	}

	public String getPageHeader() {
		return dashboardHeader.getText();

	}

	public boolean verifyHeader() {
		super.pageLogger().info("Entering into VerifyHeader method");

		//---
		try {
			if (getPageHeader().equals("Courses Offered")) {
				//test1.log(Status.PASS,"checkPageHeaderText testcase is passed");
				return true;
			} else {
				//test1.log(Status.FAIL, "checkPageHeaderText testcase is failed");
				return false;
			}
		} catch (Throwable t) {
			//test1.log(Status.FATAL, "verifyHeader method failed due to exception");
			return false;
		}
	}

	public boolean verifyCourseHeaders() {
		super.pageLogger().info("Entering into VerifyCourseHEaders method");

		//---
		boolean flag = true;
		// excel sheet
		try {
			ArrayList<String> expected = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/ExpectedData.xls");
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows=sheet.getRows();
			if (sheet.getCell(0, 0).getContents().equals("ExpectedHeaders")) {
				for (int i = 1; i < rows; i++) {
					expected.add((sheet.getCell(0, i).getContents()));
					// System.out.println(expected.get(i));
				}

				ArrayList<Boolean> flagList = new ArrayList<>();

				

				if (expected.size() == 0 && courseHeaders.size() > 0) {
					super.pageLogger().info("nothing is expected but seen some menu items");
					//test1.log(Status.FAIL,"checkAllCoursesHeaderText testcase failed");
					return false;
				}

				if (courseHeaders.size() != expected.size()) {
					super.pageLogger().info("count not matching..");
				}

				for (int i = 0; i < expected.size(); i++) {
					try {
						flag = courseHeaders.get(i).getText().equals(expected.get(i));/// false//false///false///true
						flagList.add(flag);
						if (!flag) {						
							super.pageLogger().info("THis menu is wrong .. " + expected.get(i)
									+ " > instead of this it is showing " + courseHeaders.get(i).getText());// Selenium111
						} else {
							super.pageLogger().info("matching >> " + courseHeaders.get(i).getText());
						}
					} catch (Throwable t) {
						super.pageLogger().info("THis is missing from website .. " + expected.get(i));
					}
				}
				if (flagList.contains(false)) {
					//test1.log(Status.FAIL,"checkAllCoursesHeaderText testcase failed");
					return false;
				}else if(!flagList.contains(false)){
					//test1.log(Status.PASS,"checkAllCoursesHeaderText testcase is pass");
				}
			}
		} catch (Throwable t) {
			//test1.log(Status.FATAL,"verifyCourseHeaders method failed due to exception");
			return false;
		}
		return flag;
	}


	public boolean verifyNumberOfCourses() {
		super.pageLogger().info("Entering into VerifyNumberofCourses method");

		//---
		try {
			//List<WebElement> list = driver.findElements(By.xpath("//div//h3"));
			
			if (courseHeaders.size() == 4) {
				//test1.log(Status.PASS,"checkNumberOfCourses testcase is pass");
				return true;
				
			} else {
				//test1.log(Status.FAIL,"checkNumberOfCourses testcase is failed");
				super.pageLogger().info("Count of courses is expected is 4 but found "+courseHeaders.size());
				return false;

			}
		} catch (Throwable t) {
		//	test1.log(Status.FATAL,"VerifyNumberOfCourses method fails due to exception");
			return false;
		}
		
	}

	public boolean verifyAllCourseslinksClickable() {
		super.pageLogger().info("Entering into VerifyAllCourseslinksClickable method");
        
		boolean flag = false;
		try {
			
			for (int i = 0; i < courselinks.size(); i++) {
				courselinks.get(i).click();
				flag=true;
			}
		} catch (Throwable t) {
			//test1.log(Status.FATAL,"VerifyAllCourselinksClickable method fails due to exception");
			return false;
		}if(flag==false){
			//test1.log(Status.FAIL,"CheckAllCourselinksClickable testcase is failed");
		}else if(flag==true){
			closeAllWindows();
			//test1.log(Status.PASS,"checkAllCourseslinksClickable testcase is pass");
		}
		return flag;

	}

	public boolean verifyCourseNames() {
		super.pageLogger().info("Entering into VerifyCourseNames method");

		boolean flag = true;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/ExpectedData.xls");
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows=sheet.getRows();
			if (sheet.getCell(1, 0).getContents().equals("ExpectedCourseNames")) {
				for (int i = 1; i < rows; i++) {
					expected.add((sheet.getCell(1, i).getContents()));
				}
				ArrayList<Boolean> flagList = new ArrayList<>();

				if (expected.size() == 0 && coursenames.size() > 0) {
				//	test1.log(Status.FAIL,"checkAllCoursesNames testcase fails");
					super.pageLogger().info("nothing is expected but seen some menu items");
					return false;
				}

				if (coursenames.size()!=expected.size()) {
					//test1.log(Status.FAIL,"checkAllCoursesNames testcase fails");
					super.pageLogger().info("count not matching..");
				}

				for (int i = 0; i < expected.size(); i++) {
					try {
						flag = coursenames.get(i).getText().equals(expected.get(i));/// f//false///false///true
						flagList.add(flag);
						if (!flag) {
							super.pageLogger().info("THis menu is wrong ..expected is " + expected.get(i)
									+ " > instead of this Actual is.. " + coursenames.get(i).getText());// Selenium111
						} else {
							super.pageLogger().info("matching >> " + coursenames.get(i).getText());
						}
					} catch (Throwable t) {
						super.pageLogger().info("THis is missing from website .. " + expected.get(i));
					}
				}
				if (flagList.contains(false)) {
				//	test1.log(Status.FAIL,"checkAllCoursesNames testcase fails");
					return false;
				}else if (!flagList.contains(false)) {
				//	test1.log(Status.PASS,"checkAllCoursesNames testcase is pass");
		}
			}
			}catch (Throwable t) {
			//	test1.log(Status.FATAL,"verifyAllCoursesNames method fails due to exception");
			return false;
		}
		return flag;
	}
	public void closeAllWindows(){
		String parent_win=driver.getWindowHandle();
		Set<String>allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		while(itr.hasNext()){
			String child_win=itr.next();
			if(!parent_win.equals(child_win)){
				driver.switchTo().window(child_win);
				driver.close();
			}
		}
		driver.switchTo().window(parent_win);
	}
	
	//Ashwini added code for Navigate to DownloadPage
	
	@FindBy(xpath = "//span[text()='Downloads']")
	public WebElement downloads;
	
	public DownloadPage navigateToDownloadPage() {
		DashBoardPage dp=new DashBoardPage(driver);
		DownloadPage dwp=new DownloadPage(driver);
		dp.navigateToDashBoardPage(driver);
		dwp.downloads.click();
		return new DownloadPage(driver);
	}
}
