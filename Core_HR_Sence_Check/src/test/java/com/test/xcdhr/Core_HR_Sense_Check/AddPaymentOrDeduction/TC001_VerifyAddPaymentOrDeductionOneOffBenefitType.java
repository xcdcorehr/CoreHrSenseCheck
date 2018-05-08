package com.test.xcdhr.Core_HR_Sense_Check.AddPaymentOrDeduction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.AddAward.TC001_VerifyAwardWithAwardTypeBonus;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddAwardPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddPaymentOrDeductionPage;

public class TC001_VerifyAddPaymentOrDeductionOneOffBenefitType extends TestBase{
	AddPaymentOrDeductionPage addPaymentDeduction; 
	
	public static final Logger log = Logger
			.getLogger(TC001_VerifyAddPaymentOrDeductionOneOffBenefitType.class.getName());
	
	@DataProvider(name = "UserCredentials")
	public String[][] getTestDataforLogin() {
		String[][] testUsers = getData("TestData.xls", "LoginData");
		return testUsers;

	}

	@BeforeTest
	public void setup() throws IOException {
		init();

	}
	@Test(dataProvider = "UserCredentials")
	public void searchEmployeeRecord

	(String username, String password, String runMode)
			throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		addPaymentDeduction = new AddPaymentOrDeductionPage(driver);
		log.info("======Starting test======");

		addPaymentDeduction.loginToApplication(username, password);
		getScreenShot(username);
		/*boolean verifySearchBox = addPaymentDeduction.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {*/
			addPaymentDeduction.enterEmployeeName();
		}

	
	@Test(dependsOnMethods = { "searchEmployeeRecord" })
	public void clickOnSearchedEmployeeAndRewardTab() throws InterruptedException {
		addPaymentDeduction.clickVerifiedEmployee();

		boolean rewardTab = addPaymentDeduction.verifyRewardTab();
		log.info("Reward tab is displayed =====" + rewardTab);
		Assert.assertEquals(rewardTab, true);
		if (rewardTab) {
			addPaymentDeduction.clickRewardTab();
			log.info("reward tab is clicked");
		
		}
	
	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndRewardTab" })
	public void verifyPaymentDedutonAndClick() throws InterruptedException {
		
		boolean verifyPaymentDeduction = addPaymentDeduction.verifyPaymentDeductionRecordForOneOffBenefit();
		log.info("Award record is displayed =====" + verifyPaymentDeduction);
		Assert.assertEquals(verifyPaymentDeduction, true);
		if (verifyPaymentDeduction) {
			addPaymentDeduction.clickpaymentDeductionRecordForOneOffBenefit();
			
			log.info("Payment deduction record is clicked");
		
		}

	}
	
	@Test(dependsOnMethods = { "verifyPaymentDedutonAndClick" })
	@Parameters ({"verifyPaymentAmount"})
	public void verifyPaymentAmount(String verifyPaymentAmount) {
		String expectedPaymentAmount = verifyPaymentAmount;
		String actualPaymentAmount = addPaymentDeduction.paymentAmountMatchesForOneOffBenefit();
		log.info("actual payment amount  =====" + actualPaymentAmount);
		log.info("expected payment amount  =====" + expectedPaymentAmount);
		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
		log.info("Payment amount matches and test is passed");
		
	}


	@Test(dependsOnMethods = { "verifyPaymentAmount" })
	@Parameters ({"verifyRecordType"})
	public void verifyRecordType(String verifyRecordType) {
		String expectedRecordType = verifyRecordType;
		String actualRecordType = addPaymentDeduction.recordTypeMatchesForOneOffBenefit();
		log.info("Record type  =====" + actualRecordType);
		Assert.assertEquals(actualRecordType, expectedRecordType);
		log.info("expected record type===="+expectedRecordType);
		log.info("Record Type matches and test is passed");
		endTest();
	}

}
