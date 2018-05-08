package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class AddAwardPage extends TestBase {
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

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement joinerEmployee;

	@FindBy(id = "j_id0:reward_lbl")
	WebElement rewardTab;

	@FindBy(xpath = "//*[contains(@value,'Add award')]")
	WebElement addAwardButton;

	@FindBy(xpath = "//*[text()='Select award type']//following::select[1]")
	WebElement selectTypeOfAward;

	@FindBy(xpath = "//*[text()='Type']/following::select[1]")
	WebElement awardType;

	@FindBy(xpath = "//*[text()='Date of award']/following::input[1]")
	WebElement dateOfAward;

	@FindBy(xpath = "//*[text()='Earliest payment date']/following::input[1]")
	WebElement earliestPayment1;

	@FindBy(xpath = "//*[text()='Payment amount']/following::input[1]")
	WebElement paymentAmount;

	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickSave;

	@FindBy(xpath = "//table/tbody/tr[2]/td[5]/table/tbody/tr/td/span/span[2]/form/div[5]/div/div[2]/table/tbody/tr/td[1]/a")
	WebElement awardRecordForBonus;

	@FindBy(xpath = "//table/tbody/tr[2]/td[5]/table/tbody/tr/td/span/span[2]/form/div[5]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement awardRecordForCommission;

	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement regularPaymentAmountForBonus;

	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div")
	WebElement recordTypeForBonus;

	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement regularPaymentAmountForCommission;

	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div")
	WebElement recordTypeForCommission;

	public AddAwardPage(WebDriver driver) {
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
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ");
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

	}

	public boolean VerifyAddAwardButton() {
		try {
			addAwardButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAwardButton() throws InterruptedException {
		addAwardButton.click();

	}

	public boolean verifyAwardTypePage() {
		try {
			selectTypeOfAward.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setupAwardForBunus(String typeAward, String awardDate,
			String earliestPaymentDate, String amountOfPayment)
			throws InterruptedException {
		Thread.sleep(3000);
		Select selectByValueforAward = new Select(selectTypeOfAward);
		log.info("+++++++" + selectByValueforAward);
		selectByValueforAward.selectByVisibleText("Bonus");
		Thread.sleep(8000);

		Select typeOfAwardForBunus = new Select(awardType);
		log.info("+++++++" + typeOfAwardForBunus);
		typeOfAwardForBunus.selectByValue(typeAward);
		Thread.sleep(2000);

		dateOfAward.sendKeys(awardDate);
		earliestPayment1.sendKeys(earliestPaymentDate);
		Thread.sleep(2000);
		paymentAmount.sendKeys(amountOfPayment);
		Thread.sleep(8000);
		clickSave.click();
		Thread.sleep(7000);
	}

	public void setupAwardForCommission(String typeAward, String awardDate,
			String amountOfPaymentString, String earliestPaymentDate)
			throws InterruptedException {
		Thread.sleep(3000);
		Select selectByValueforAward = new Select(selectTypeOfAward);
		log.info("+++++++" + selectByValueforAward);
		selectByValueforAward.selectByVisibleText("Commission");
		Thread.sleep(8000);

		Select typeOfAwardForBunus = new Select(awardType);
		log.info("+++++++" + typeOfAwardForBunus);
		typeOfAwardForBunus.selectByValue(typeAward);
		Thread.sleep(2000);

		dateOfAward.sendKeys(awardDate);
		Thread.sleep(2000);
		paymentAmount.sendKeys(amountOfPaymentString);
		Thread.sleep(2000);
		earliestPayment1.sendKeys(earliestPaymentDate);
		Thread.sleep(5000);
		clickSave.click();
		Thread.sleep(7000);

	}

	public boolean verifyAwardRecordForBonus() {
		try {
			awardRecordForBonus.isDisplayed();
			log.info("Award record  record is showing" + awardRecordForBonus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAwardRecordForBonus() {
		awardRecordForBonus.click();

	}

	public boolean verifyAwardRecordForCommission() {
		try {
			awardRecordForCommission.isDisplayed();
			log.info("Award record  record is showing"
					+ awardRecordForCommission);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAwardRecordForCommision() {
		awardRecordForCommission.click();

	}

	public String paymentAmountMatchesForAwardBonus() {
		try {
			String actualPaymentAmountForBonus = "";

			actualPaymentAmountForBonus = regularPaymentAmountForBonus
					.getText();
			log.info("regular payment smount====="
					+ actualPaymentAmountForBonus);
			return actualPaymentAmountForBonus;

		} catch (Exception e) {
			return "lets see";
		}

	}

	public String recordTypeMatchesForAwardBonus() {
		try {
			String actualRecordTypeForBonus = "";

			actualRecordTypeForBonus = recordTypeForBonus.getText();
			log.info("Record type=====" + actualRecordTypeForBonus);
			return actualRecordTypeForBonus;

		} catch (Exception e) {
			return "lets see";
		}

	}

	public String paymentAmountMatchesForAwardCommission() {
		try {
			String actualPaymentAmountForCommission = "";

			actualPaymentAmountForCommission = regularPaymentAmountForCommission
					.getText();
			log.info("regular payment smount====="
					+ actualPaymentAmountForCommission);
			return actualPaymentAmountForCommission;

		} catch (Exception e) {
			return "lets see";
		}

	}

	public String recordTypeMatchesForAwardCommission() {
		try {
			String actualRecordTypeForCommission = "";

			actualRecordTypeForCommission = recordTypeForCommission.getText();
			log.info("Record type=====" + actualRecordTypeForCommission);
			return actualRecordTypeForCommission;

		} catch (Exception e) {
			return "lets see";
		}

	}

}
