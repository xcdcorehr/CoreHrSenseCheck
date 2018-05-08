package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class ChangeCompensationPage extends TestBase {

	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;

	@FindBy(id = "j_id0:reward_lbl")
	WebElement rewardTab;

	@FindBy(xpath = "//*[contains(@value,'Change current compensation')]")
	WebElement changeCompensationButton;
	
/*	@FindBy(xpath = "//*[@id='j_id0:rewardHelp:CompensationBlock:j_id1096']/input[1]")
	WebElement changeCompensationButton;*/

	@FindBy(xpath = "//*[text()='Effective from']//following::input[1]")
	WebElement changeCompenSationEffectiveFrom;
	
	/*@FindBy(xpath = "//*[@id='j_id0:j_id3:j_id12:j_id59:j_id72:0:j_id73:2:j_id74']")
	WebElement changeCompenSationEffectiveFrom*/;

	@FindBy(xpath = "//*[text()='Regular pay']//following::input[1]")
	WebElement changeCompenSationRegularPay;

	@FindBy(xpath = "//*[text()='Period']//following::select[1]")
	WebElement period;
	
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement changeCompenSationSaveButton;

	@FindBy(xpath = "//div[@id='j_id0:popup1']/center/form/span/span/span[2]/span/input[1]")
	WebElement changeCompenSationClickOK;

	@FindBy(id = "phSearchInput")
	WebElement searchBox;

	@FindBy(id = "phSearchButton")
	WebElement searchButton;
	                
	              
	@FindBy(xpath = "//div[1]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement clickSecondCompensation;
	
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement joinerEmployee2;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ")
	WebElement joinerEmployee3;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ")
	WebElement joinerEmployee4;
	
	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement seconCompensatioAnnualSalaryMatches;
	
	public ChangeCompensationPage(WebDriver driver) {
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

	public void enterEmployeeNameForMonthlyPeriod() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}

	public void enterEmployeeNameForAnnualPeriod() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	public void enterEmployeeNameForWeeklyPeriod() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	
	
	
	
	
	public boolean verifyEmployeeNameForMonthlyPeriod() {
		try {
			joinerEmployee2.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee2.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeForMonthlyPeriod() {
		joinerEmployee2.click();

	}
     
	
	public boolean verifyEmployeeNameForAnnualPeriod() {
		try {
			joinerEmployee3.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee2.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeForAnnualPeriod() {
		joinerEmployee3.click();

	}
	
	public boolean verifyEmployeeNameForWeeklyPeriod() {
		try {
			joinerEmployee4.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee4.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeForWeeklyPeriod() {
		joinerEmployee4.click();

	}
	

	
	public boolean verifyRewardTab() {
		try {
			rewardTab.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickRewardTab() throws InterruptedException {
		rewardTab.click();
		Thread.sleep(4000);

	}

	public boolean verifyChangeCompButton() {
		try {
			changeCompensationButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickChangeCompButton() {
		changeCompensationButton.click();
	}

	public boolean verifyChangeCompensationPage() {
		try {
			changeCompenSationEffectiveFrom.isDisplayed();
			log.info("Change job role effective from field is displayed"
					+ changeCompenSationEffectiveFrom.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void setupChangeCompensationWithMonthlyPeriod(String effectiveFrom,String regularPay) throws InterruptedException {

		changeCompenSationEffectiveFrom.sendKeys(effectiveFrom);
		Thread.sleep(5000);
		changeCompenSationRegularPay.clear();
		changeCompenSationRegularPay.sendKeys(regularPay);
		Thread.sleep(5000);
		changeCompenSationSaveButton.click();
		Thread.sleep(7000);
		changeCompenSationClickOK.click();
		Thread.sleep(7000);
		
	}
	
	public void setupChangeCompensationWithPeriodAnnualAndWeekly(String effectiveFrom,String regularPay,String regularPeriod) throws InterruptedException {

		changeCompenSationEffectiveFrom.sendKeys(effectiveFrom);
		Thread.sleep(5000);
		changeCompenSationRegularPay.clear();
		changeCompenSationRegularPay.sendKeys(regularPay);
		Thread.sleep(5000);
		Select selectByValueforPeriod = new Select(period);
		log.info("ssssssssssssssss" + selectByValueforPeriod);
		selectByValueforPeriod.selectByValue(regularPeriod);
		Thread.sleep(5000);
		changeCompenSationSaveButton.click();
		Thread.sleep(5000);
		changeCompenSationClickOK.click();
		Thread.sleep(5000);
		
	}
	
	
	
	
	public boolean verifySecondCompensation (){
		try {
			clickSecondCompensation.isDisplayed();
			log.info("Second compesation is displayed and object is"+clickSecondCompensation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickSecondCompensation() {
		clickSecondCompensation.click();

	}
		
	public String SecondCompensationAnnualSalaryMatches() {
		try {
			String actualSecondCompSalary = "";

			actualSecondCompSalary = seconCompensatioAnnualSalaryMatches.getText();
			log.info("Annual salary of second compensation=====" + actualSecondCompSalary);
			return actualSecondCompSalary;

		} catch (Exception e) {
			return "lets see";
		}

	}
	
	}





