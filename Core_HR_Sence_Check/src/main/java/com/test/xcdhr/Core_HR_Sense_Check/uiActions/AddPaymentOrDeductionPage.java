package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class AddPaymentOrDeductionPage extends TestBase {
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
	
	
	@FindBy(xpath = "//*[contains(@value,'Add payment or deduction')]")
	WebElement addPaymentDeductionButton;
	
	@FindBy(xpath = "//div[2]/table/tbody/tr[1]/td/select")
	WebElement selectTypeOfPaymentDeduction;
	

	@FindBy(xpath = "//*[text()='Type']//following::select[1]")
	WebElement paymentDeductionTypeForOneOffBenefit;
	
	
	
	@FindBy(xpath = "//*[text()='Membership number']//following::input[1]")
	WebElement membershipNumber;
	
	/*@FindBy(xpath = "//*[@id='j_id0:theform:j_id11:j_id47:0:j_id61:j_id65:type']")
	WebElement paymentDeductionTypeForOneOffDeduction;
	
	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id11:j_id47:0:j_id79:j_id83:type']")
	WebElement paymentDeductionTypeForOneOffPayment;*/
	

	@FindBy(xpath = "//*[text()='Employer contribution']//following::input[1]")
	WebElement employerContribution;
	
	@FindBy(xpath = "//*[text()='Employee contribution']//following::input[1]")
	WebElement employeeContribution;

	
	@FindBy(xpath = "//*[text()='Date of award']//following::input[1]")
	WebElement dateOfAward;
	
	@FindBy(id = "//*[text()='Earliest payment date']//following::input[1]")
	WebElement earliestPaymentDate;
	
	@FindBy(xpath = "//*[text()='Payment amount']//following::input[1]")
	WebElement paymentAmountForOneOffDeduction;
	
/*	@FindBy(xpath = "//*[@id='j_id0:theform:j_id11:j_id47:0:j_id61:j_id71:j_id73']")
	WebElement paymentAmountForOneOffBenefit;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:j_id11:j_id47:0:j_id79:j_id89:j_id91']")
	WebElement paymentAmountForOneOffPayment;*/
	
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickSave;
	
	   
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[6]/div/div[2]//table/tbody/tr[1]/td[1]/a")
	WebElement paymentDeductionRecordForOneOffBenefit;
	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[6]/div/div[2]//table/tbody/tr[2]/td[1]/a")
	WebElement paymentDeductionRecordForOneOffDeduction;
	
	@FindBy(xpath = "//table/tbody/tr/td/span/span[2]/form/div[6]/div/div[2]//table/tbody/tr[1]/td[1]/a")
	WebElement paymentDeductionRecordForOneOffPayment;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[3]/td[2]/div")
	WebElement VerifyPaymentAmountForOneOffBenefit;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div")
	WebElement VerifyPaymentAmountForOneOffDeduction;

	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div")
	WebElement VerifyPaymentAmountForOneOffPayment;
	
	
	@FindBy(xpath = "//body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[3]/td[2]/div")
	WebElement verifyRecordTypeForOneOffBenefit;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div")
	WebElement verifyRecordTypeForOneOffDeduction;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div")
	WebElement verifyRecordTypeForOneOffPayment;
	
	
	public AddPaymentOrDeductionPage(WebDriver driver) {
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
		Thread.sleep(5000);
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
	public boolean verifyPaymentDeductionButton() {
		try {
			addPaymentDeductionButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickpaymentDeductionButton() throws InterruptedException {
		addPaymentDeductionButton.click();
		

	}
	public boolean verifyPaymentDeductionTypePage() {
		try {
			selectTypeOfPaymentDeduction.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

public void setupPaymentDedcutionForOneOffBenefit (String typeOfPaymenttDeduction,String employerrContribution,String empContribution) throws InterruptedException{
		
		Select selectByValueforPaymentDeduction = new Select(selectTypeOfPaymentDeduction);
		log.info("+++++++" + selectByValueforPaymentDeduction);
		selectByValueforPaymentDeduction.selectByVisibleText("One off benefit");
		Thread.sleep(4000);
		
		Select typeOfPaymentDeduction = new Select(paymentDeductionTypeForOneOffBenefit);
		log.info("+++++++" + typeOfPaymentDeduction);
		typeOfPaymentDeduction.selectByValue(typeOfPaymenttDeduction);
		Thread.sleep(5000);
		employerContribution.sendKeys(employerrContribution);
		Thread.sleep(5000);
		employeeContribution.sendKeys(empContribution);
		Thread.sleep(4000);
		clickSave.click();
		Thread.sleep(3000);
	
	}
public boolean verifyPaymentDeductionRecordForOneOffBenefit(){
	try {
		paymentDeductionRecordForOneOffBenefit.isDisplayed();
		log.info("paymentDeduction Record is showing "+paymentDeductionRecordForOneOffBenefit);
		return true;
	} catch (Exception e) {
		return false;
	}
}
public void clickpaymentDeductionRecordForOneOffBenefit() {
	paymentDeductionRecordForOneOffBenefit.click();

}
public String paymentAmountMatchesForOneOffBenefit() {
	try {
		String actualPaymentAmount = "";

		actualPaymentAmount = VerifyPaymentAmountForOneOffBenefit.getText();
		log.info("payment amount=====" + actualPaymentAmount);
		return actualPaymentAmount;

	} catch (Exception e) {
		return "lets see";
	}

}

public String recordTypeMatchesForOneOffBenefit() {
	try {
		String actualRecordType = "";

		actualRecordType = verifyRecordTypeForOneOffBenefit.getText();
		log.info("Record type=====" + actualRecordType);
		return actualRecordType;

	} catch (Exception e) {
		return "lets see";
	}

}

public void setupPaymentDedcutionForOneOffDeduction (String typeOfPaymenttDeduction,String paymentAmount) throws InterruptedException{
	
	Select selectByValueforPaymentDeduction = new Select(selectTypeOfPaymentDeduction);
	log.info("+++++++" + selectByValueforPaymentDeduction);
	selectByValueforPaymentDeduction.selectByVisibleText("One off deduction");
	Thread.sleep(4000);
	
	Select typeOfPaymentDeduction = new Select(paymentDeductionTypeForOneOffBenefit);
	log.info("+++++++" + typeOfPaymentDeduction);
	typeOfPaymentDeduction.selectByValue(typeOfPaymenttDeduction);
	Thread.sleep(6000);
	paymentAmountForOneOffDeduction.clear();
	paymentAmountForOneOffDeduction.sendKeys(paymentAmount);
	Thread.sleep(8000);
	clickSave.click();
	Thread.sleep(3000);

}
public boolean verifyPaymentDeductionRecordForOneOffDeduction(){
try {
	paymentDeductionRecordForOneOffDeduction.isDisplayed();
	log.info("paymentDeduction Record is showing "+paymentDeductionRecordForOneOffDeduction);
	return true;
} catch (Exception e) {
	return false;
}
}
public void clickpaymentDeductionRecordForOneOffDeduction() {
paymentDeductionRecordForOneOffDeduction.click();

}
public String paymentAmountMatchesForOneOffDeduction() {
try {
	String actualPaymentAmount = "";

	actualPaymentAmount = VerifyPaymentAmountForOneOffDeduction.getText();
	log.info("payment amount=====" + actualPaymentAmount);
	return actualPaymentAmount;

} catch (Exception e) {
	return "lets see";
}

}

public String recordTypeMatchesForOneOffDeduction() {
try {
	String actualRecordType = "";

	actualRecordType = verifyRecordTypeForOneOffDeduction.getText();
	log.info("Record type=====" + actualRecordType);
	return actualRecordType;

} catch (Exception e) {
	return "lets see";
}

}

public void setupPaymentDedcutionForOneOffPayment (String typeOfPaymenttDeduction,String paymentAmount) throws InterruptedException{
	
	Select selectByValueforPaymentDeduction = new Select(selectTypeOfPaymentDeduction);
	log.info("+++++++" + selectByValueforPaymentDeduction);
	selectByValueforPaymentDeduction.selectByVisibleText("One off payment");
	Thread.sleep(4000);
	
	Select typeOfPaymentDeduction = new Select(paymentDeductionTypeForOneOffBenefit);
	log.info("+++++++" + typeOfPaymentDeduction);
	typeOfPaymentDeduction.selectByValue(typeOfPaymenttDeduction);
	Thread.sleep(6000);
	paymentAmountForOneOffDeduction.clear();
	paymentAmountForOneOffDeduction.sendKeys(paymentAmount);
	Thread.sleep(8000);
	clickSave.click();
	Thread.sleep(3000);

}
public boolean verifyPaymentDeductionRecordForOneOffPayment(){
try {
	paymentDeductionRecordForOneOffPayment.isDisplayed();
	log.info("paymentDeduction Record is showing "+paymentDeductionRecordForOneOffPayment);
	return true;
} catch (Exception e) {
	return false;
}
}
public void clickpaymentDeductionRecordForOneOffPayment() {
paymentDeductionRecordForOneOffPayment.click();

}
public String paymentAmountMatchesForOneOffPayment() {
try {
	String actualPaymentAmount = "";

	actualPaymentAmount = VerifyPaymentAmountForOneOffPayment.getText();
	log.info("payment amount=====" + actualPaymentAmount);
	return actualPaymentAmount;

} catch (Exception e) {
	return "lets see";
}

}

public String recordTypeMatchesForOneOffPayment() {
try {
	String actualRecordType = "";

	actualRecordType = verifyRecordTypeForOneOffPayment.getText();
	log.info("Record type=====" + actualRecordType);
	return actualRecordType;

} catch (Exception e) {
	return "lets see";
}

}


}
