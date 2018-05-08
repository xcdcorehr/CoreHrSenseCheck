package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.xcdhr.Core_HR_Sense_Check.ProcessLeaver.TC001_ProcessLeaver;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class ProcessLeaverPage extends TestBase {

	WebDriver driver;
	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;
	@FindBy(id = "phSearchInput")
	WebElement searchBox;

	@FindBy(id = "phSearchButton")
	WebElement searchButton;

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ")
	WebElement joinerEmployee;

	@FindBy(xpath = "//*[contains(@value,'Process leaver')]")
	WebElement leaverButton;

	@FindBy(xpath = "//*[text()='Date notice of termination given']/following::input[1]")
	WebElement noticeDateOfTermination;

	@FindBy(xpath = "//*[text()='Leaving date']/following::input[1]")
	WebElement leavingDate;

	@FindBy(xpath = "//*[text()='Last working day']/following::input[1]")
	WebElement lastWorkingDate;

	@FindBy(xpath = "//*[text()='Reason for leaving']/following::select[1]")
	WebElement reasonForLeaving;

	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td/form/div[1]/div/div/div/div[1]/div[2]/div/table/tbody/tr[6]/td[1]/div/span/input")
	WebElement lastPayRunDate;

	
	
	@FindBy(xpath = "//*[contains(@value,'Process leaver')]")
	WebElement processLeverButton;

	@FindBy(xpath = "//*[contains(@value,'Complete process')]")
	WebElement completeProcessButton;
	               
	@FindBy(xpath = "//*[text()='Leaver']")
	WebElement leaverSection;
	                  
	@FindBy(xpath = "//*[text()='Others']")
	WebElement reasonForChange;
	
	@FindBy(xpath = "//*[text()='Leaving date']/following::table[1]/tbody[1]/tr[3]/td[2]/span[1]")
	WebElement leavingDateOnEmployment;
	
	@FindBy(xpath = "//*[text()='Last working day']/following::table[1]/tbody[1]/tr[4]/td[1]/span[1]")
	WebElement lastWorkingDayOnEmployment;

	public ProcessLeaverPage(WebDriver driver) {
        this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	public void loginToApplication(String username, String password) {

		enterUserName.sendKeys(username);
		log.info("Entere user name = " + username + " and object is"
				+ enterUserName.toString());
		enterPassword.sendKeys(password);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}

	public boolean verifySeacrchBox() {
		try {
			searchBox.isDisplayed();
			log.info("Employment Status field is diplayed and object is "
					+ searchBox.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void enterEmployeeName() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}

	public boolean verifyEmployeeName() {
		try {
			joinerEmployee.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployee() {
		joinerEmployee.click();

	}

	public boolean verifyLeaverButton() {
		try {
			leaverButton.isDisplayed();
			log.info("Leaver butto is displayed and object is"
					+ leaverButton.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickLeaverButton() {
		leaverButton.click();

	}

	public boolean verifyLeavePage() {
		try {
			noticeDateOfTermination.isDisplayed();
			log.info("Now system is on leaver page"
					+ noticeDateOfTermination.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void processsLeaver(String noticeDate, String dateOfLeaving,
			String lastWorkingDay, String leavingReason,String lastPayRun)
			throws InterruptedException {
		

		try {
			noticeDateOfTermination.sendKeys(noticeDate);
			Thread.sleep(2000);
			leavingDate.sendKeys(dateOfLeaving);
			Thread.sleep(2000);
			lastWorkingDate.sendKeys(lastWorkingDay);
			Thread.sleep(2000);
			Select selectReasonForLeaving = new Select(reasonForLeaving);
			log.info("+++++++" + selectReasonForLeaving);
			selectReasonForLeaving.selectByValue(leavingReason);
			Thread.sleep(5000);
			lastPayRunDate.sendKeys(lastPayRun);
			Thread.sleep(5000);
			processLeverButton.click();
			Thread.sleep(5000);
			completeProcessButton.click();
			Alert simpleAlert = driver.switchTo().alert();
			String alertText = simpleAlert.getText();
			System.out.println("Alert text is " + alertText);
			simpleAlert.accept();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public String leaverSectionMatch() {
		try {
			String actualLeaverSection = "";

			actualLeaverSection = leaverSection.getText();
			log.info("Leaver section is diplayed =====" + actualLeaverSection);
			return actualLeaverSection;

		} catch (Exception e) {
			return "lets see";
		}

	}

	public String leavingDateMatches() {
		try {
			String actualLeavingDte = "";

			actualLeavingDte = leavingDateOnEmployment.getText();
			log.info("leaving date=====" + actualLeavingDte);
			return actualLeavingDte;

		} catch (Exception e) {
			return "lets see";
		}
	}

	public String lastWorkingDateMatches() {
		try {
			String actualLastWorkingDate = "";

			actualLastWorkingDate = leavingDateOnEmployment.getText();
			log.info("leaving date=====" + actualLastWorkingDate);
			return actualLastWorkingDate;

		} catch (Exception e) {
			return "lets see";
		}

	}

}
