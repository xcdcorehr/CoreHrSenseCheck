package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class AddOneOffPensionContributionPage extends TestBase {

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
	
	                 //*[@id='j_id0:rewardHelp:OneOffPension:j_id1193']/input
	@FindBy(xpath = "//*[contains(@value,'Add one off pension contribution')]")
	WebElement addOneOffContributionButton;
    
	@FindBy(xpath = "//*[text()='Date of award']//following::input[1]")
	WebElement dateOfAward;
    
	@FindBy(xpath = "//*[text()='Earliest payment date']//following::input[1]")
	WebElement earliestPaymentDate;
	
	
	@FindBy(xpath = "//*[text()='Type']//following::select[1]")
	WebElement TypeOneOffPaymentContribution;
	
	

	
	@FindBy(xpath = "//*[text()='Employer contribution']//following::input[1]")
	WebElement employerContribution;
	
	@FindBy(xpath = "//*[text()='Employee contribution']//following::input[1]")
	WebElement employeeContribution;
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickSave;

	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[3]/div/div[2]/table/tbody/tr/td[1]/a")
	WebElement clickOneOffPensionContributton;
	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div")
	WebElement employerContibutionMatch;
	

	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[2]/td[4]/div")
	WebElement employeeContibutionMatch;
	public AddOneOffPensionContributionPage(WebDriver driver) {
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

	public boolean verifyOneOffPensionContributionButton() {
		try {
			addOneOffContributionButton.isDisplayed();
		log.info("----------"+addOneOffContributionButton.isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickOneOffPensionContributionButton() {
		addOneOffContributionButton.click();
	}
	public boolean verifyAddOneOffPensionContributionPage() {
		try {
			dateOfAward.isDisplayed();
			log.info("Date of award field is displayed"
					+ dateOfAward.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void setupOneOffPensaionCOntribution(String typeOfPension,String awardDate,String payentEarliestDate,String employerrContribution, String employeeeContribution) throws InterruptedException {

		
		Select selectByValueforType = new Select(TypeOneOffPaymentContribution);
		log.info("+++++++" + selectByValueforType);
		selectByValueforType.selectByValue(typeOfPension);
		dateOfAward.sendKeys(awardDate);
		Thread.sleep(4000);
		earliestPaymentDate.sendKeys(payentEarliestDate);
		Thread.sleep(4000);
		employerContribution.clear();
		employerContribution.sendKeys(employerrContribution);
		Thread.sleep(5000);
		employeeContribution.clear();
		employeeContribution.sendKeys(employeeeContribution);
		Thread.sleep(5000);
		clickSave.click();
		Thread.sleep(3000);
	}
	public boolean verifyOneOffPensionContribution (){
		try {
			clickOneOffPensionContributton.isDisplayed();
			log.info("One off pension contribution record is showing"+clickOneOffPensionContributton);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickOneOffPensionContribution() {
		clickOneOffPensionContributton.click();

	}
	public String employerContributionMatches() {
		try {
			String actualEmployerContribution = "";

			actualEmployerContribution = employerContibutionMatch.getText();
			log.info("Employer Contribution=====" + actualEmployerContribution);
			return actualEmployerContribution;

		} catch (Exception e) {
			return "lets see";
		}

	}
	
	public String employeeContributionMatches() {
		try {
			String actualEmployeeContribution = "";

			actualEmployeeContribution = employeeContibutionMatch.getText();
			log.info("Employee Contribution=====" + actualEmployeeContribution);
			return actualEmployeeContribution;

		} catch (Exception e) {
			return "lets see";
		}

	}



}
