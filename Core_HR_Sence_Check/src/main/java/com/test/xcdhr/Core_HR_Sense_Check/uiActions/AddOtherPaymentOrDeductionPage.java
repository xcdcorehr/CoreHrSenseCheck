package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class AddOtherPaymentOrDeductionPage extends TestBase {
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
	
	
	@FindBy(xpath = "//*[contains(@value,'Add other payment or deduction')]")
	WebElement addOtherPaymentDeductionButton;
	
	                //*[@id='j_id0:theform:j_id2:sec:item:List']
	@FindBy(xpath = "//div[2]/div/div[2]/table/tbody/tr[1]/td/select")
	WebElement selectPaymentDeduction;
	//*[@id='j_id0:theform:j_id24:sec:item:List']
	
	@FindBy(xpath = "//*[text()='Regular pay']//following::input[1]")
	WebElement changeCompenSationRegularPay;
	
	
	
	@FindBy(xpath = "//*[text()='Type']//following::select[1]")
	WebElement typeOfPaymentDeductionForAllowance;
	/*
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id75:j_id79:type']")
	WebElement typeOfPaymentDeductionForBenefit;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id89:j_id93:type']")
	WebElement typeOfPaymentDeductionForDeduction;*/
	
	
	@FindBy(xpath = "//*[text()='Payment frequency']//following::select[1]")
	WebElement paymentFrequencyForAllowance;
	
/*	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id75:j_id83:0:j_id84']")
	WebElement paymentFrequencyForBenefit;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id89:j_id97:1:j_id98']")
	WebElement paymentFrequencyForDeduction;*/
	
	
	@FindBy(xpath = "//*[text()='Regular payment amount']//following::input[1]")
	WebElement regularPaymentAmountForAllowance;
	
	
	/*@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id89:j_id97:0:j_id98']")
	WebElement regularPaymentAmountForDeduction;*/
	
	@FindBy(xpath = "//*[text()='Effective from']//following::input[1]")
	WebElement effectveFromForAllowance;
	
	/*@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id75:j_id83:2:j_id84']")
	WebElement effectveFromForBenefit;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id24:j_id60:0:j_id89:j_id97:2:j_id98']")
	WebElement effectveFromForDeduction;*/
	
	
	@FindBy(xpath = "//*[text()='Employer contribution']//following::input[1]")
	WebElement employerContributionForBenefit;
	
	@FindBy(xpath = "//*[text()='Employee contribution']//following::input[1]")
	WebElement employeeContributionForBenefit;
	
	@FindBy(xpath = "//*[text()='Membership number']//following::input[1]")
	WebElement membershipNumber;
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickSave;
	
	
	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[4]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement clickOtherPaymentDeductionAllowance;
	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[4]/div/div[2]/table/tbody/tr[2]/td[1]/a")
	WebElement clickOtherPaymentDeductionBenefit;
	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[4]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	WebElement clickOtherPaymentDeductionDeduction;

	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement regularPaymentAmountMatch;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[4]/td[2]/div")
	WebElement annualBenefitAmountMatch;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[4]/td[4]/div")
	WebElement totalAnnualContributionMatch;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement regularPaymentAmountMatchForDeduction;
	
	
	
	public AddOtherPaymentOrDeductionPage(WebDriver driver) {
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
		Thread.sleep(4000);

	}
	

	public boolean verifyAddOtherPaymentDeductionButton() {
		try {
			addOtherPaymentDeductionButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickAddOtherPaymentDeductionButton() throws InterruptedException {
		addOtherPaymentDeductionButton.click();
		

	}
	public boolean verifyBenefitTypePage() {
		try {
			selectPaymentDeduction.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/*public void selectBenefitType () throws InterruptedException{
		Select selectByValueforOtherPaymentDedution = new Select(selectPaymentDeduction);
		log.info("+++++++" + selectByValueforOtherPaymentDedution);
		selectByValueforOtherPaymentDedution.selectByValue("Allowance");
		Thread.sleep(4000);
	}*/

	public void setupOtherPaymentDeductionForAllowance (String paymentDeductionType,String frequencyPayment,String regularAmountOfPayment,String effectiveFromDate) throws InterruptedException{
		
		Select selectByValueforOtherPaymentDedutionAllowance = new Select(selectPaymentDeduction);
		log.info("+++++++" + selectByValueforOtherPaymentDedutionAllowance);
		selectByValueforOtherPaymentDedutionAllowance.selectByVisibleText("Allowance");
		Thread.sleep(4000);
		
		Select typeOfAllowance = new Select(typeOfPaymentDeductionForAllowance);
		log.info("+++++++" + typeOfAllowance);
		typeOfAllowance.selectByValue(paymentDeductionType);
		Thread.sleep(2000);
		Select typeOfPaymentFrequency = new Select (paymentFrequencyForAllowance);
		log.info("+++++++" + typeOfPaymentFrequency);
		typeOfPaymentFrequency.selectByValue(frequencyPayment);
		Thread.sleep(2000);
		regularPaymentAmountForAllowance.sendKeys(regularAmountOfPayment);
		effectveFromForAllowance.sendKeys(effectiveFromDate);
		Thread.sleep(2000);
		membershipNumber.sendKeys("xyz");
		Thread.sleep(8000);
		clickSave.click();
		Thread.sleep(5000);
	}
	
public void setupOtherPaymentDeductionForBenefit (String paymentDeductionType,String frequencyPayment,String effectiveFromDate,String employerContribution,String employeeContribution) throws InterruptedException{
		
		Select selectByValueforOtherPaymentDedutionBenefit = new Select(selectPaymentDeduction);
		log.info("+++++++" + selectByValueforOtherPaymentDedutionBenefit);
		selectByValueforOtherPaymentDedutionBenefit.selectByVisibleText("Benefit");
		Thread.sleep(4000);
		
		Select typeOfAllowance = new Select(typeOfPaymentDeductionForAllowance);
		log.info("+++++++" + typeOfAllowance);
		typeOfAllowance.selectByValue(paymentDeductionType);
		Thread.sleep(2000);
		Select typeOfPaymentFrequency = new Select (paymentFrequencyForAllowance);
		log.info("+++++++" + typeOfPaymentFrequency);
		typeOfPaymentFrequency.selectByValue(frequencyPayment);
		Thread.sleep(2000);
		effectveFromForAllowance.sendKeys(effectiveFromDate);
		Thread.sleep(2000);
		employerContributionForBenefit.sendKeys(employerContribution);
		Thread.sleep(2000);
		employeeContributionForBenefit.sendKeys(employeeContribution);
		
		Thread.sleep(8000);
		clickSave.click();
		Thread.sleep(5000);
	
	}
	
public void setupOtherPaymentDeductionForDeduction (String paymentDeductionType,String regularAmountOfPayment,String frequencyPayment,String effectiveFromDate) throws InterruptedException{
	
	Select selectByValueforOtherPaymentDedutionDeduction = new Select(selectPaymentDeduction);
	log.info("+++++++" + selectByValueforOtherPaymentDedutionDeduction);
	selectByValueforOtherPaymentDedutionDeduction.selectByValue("Deduction");
	Thread.sleep(4000);
	
	Select typeOfAllowance = new Select(typeOfPaymentDeductionForAllowance);
	log.info("+++++++" + typeOfAllowance);
	typeOfAllowance.selectByValue(paymentDeductionType);
	Thread.sleep(2000);
	regularPaymentAmountForAllowance.sendKeys(regularAmountOfPayment);
	Thread.sleep(2000);
	Select typeOfPaymentFrequency = new Select (paymentFrequencyForAllowance);
	log.info("+++++++" + typeOfPaymentFrequency);
	typeOfPaymentFrequency.selectByValue(frequencyPayment);
	Thread.sleep(2000);
	
	effectveFromForAllowance.sendKeys(effectiveFromDate);
	Thread.sleep(5000);
	clickSave.click();
	Thread.sleep(5000);

}
	
	
	
	
	public boolean verifyOtherPaymentDeductionAllowance(){
		try {
			clickOtherPaymentDeductionAllowance.isDisplayed();
			log.info("Other payment deduction record is showing"+clickOtherPaymentDeductionAllowance);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickOtherPaymentDeductionAllowance() {
		clickOtherPaymentDeductionAllowance.click();

	}
	
	public boolean verifyOtherPaymentDeductionBenefit(){
		try {
			clickOtherPaymentDeductionBenefit.isDisplayed();
			log.info("Other payment deduction record is showing"+clickOtherPaymentDeductionBenefit);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickOtherPaymentDeductionBenefit() {
		clickOtherPaymentDeductionBenefit.click();

	}
	
	public boolean verifyOtherPaymentDeductionDeduction(){
		try {
			clickOtherPaymentDeductionDeduction.isDisplayed();
			log.info("Other payment deduction record is showing"+clickOtherPaymentDeductionDeduction);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickOtherPaymentDeductionDeduction() {
		clickOtherPaymentDeductionDeduction.click();

	}
	
	
	
	public String regularPaymentAmountMatches() {
		try {
			String actualRegularPaymentAmount = "";

			actualRegularPaymentAmount = regularPaymentAmountMatch.getText();
			log.info("regular payment smount=====" + actualRegularPaymentAmount);
			return actualRegularPaymentAmount;

		} catch (Exception e) {
			return "lets see";
		}

	}
	
	public String annualBenefitMatches() {
		try {
			String actualAnnualBenefitAmount = "";

			actualAnnualBenefitAmount = annualBenefitAmountMatch.getText();
			log.info("Annual benefit amount=====" + actualAnnualBenefitAmount);
			return actualAnnualBenefitAmount;

		} catch (Exception e) {
			return "lets see";
		}

	}
	
	public String totalAnnualContributionMatches(){
		try{
			String actualTotalAnnualContribution = "";
			actualTotalAnnualContribution = totalAnnualContributionMatch.getText();
			log.info("Total annual contribution amount===="+actualTotalAnnualContribution);
			return actualTotalAnnualContribution ;
		}
		catch(Exception e){
			return "lets see";
		}
		
		
	}
	
	public String regularPaymentAmountMatchesForDeduction() {
		try {
			String actualRegularPaymentAmount = "";

			actualRegularPaymentAmount = regularPaymentAmountMatchForDeduction.getText();
			log.info("regular payment smount=====" + actualRegularPaymentAmount);
			return actualRegularPaymentAmount;

		} catch (Exception e) {
			return "lets see";
		}

	}


}

