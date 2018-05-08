package com.test.xcdhr.Core_HR_Sense_Check.AddAward;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.AddOherPaymentOrDeduction.TC001_VerifyOtherPaymentOrDeductionBenefitTypeAllowance;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddAwardPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOtherPaymentOrDeductionPage;

public class TC001_VerifyAwardWithAwardTypeBonus extends TestBase{

	AddAwardPage addAward ; ; 
	
	public static final Logger log = Logger
			.getLogger(TC001_VerifyAwardWithAwardTypeBonus.class.getName());
	
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
		addAward = new AddAwardPage(driver);
		log.info("======Starting test======");

		addAward.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = addAward.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addAward.enterEmployeeName();
		}

	}
	@Test(dependsOnMethods = { "searchEmployeeRecord" })
	public void clickOnSearchedEmployeeAndRewardTab() throws InterruptedException {
		addAward.clickVerifiedEmployee();

		boolean rewardTab = addAward.verifyRewardTab();
		log.info("Reward tab is displayed =====" + rewardTab);
		Assert.assertEquals(rewardTab, true);
		if (rewardTab) {
			addAward.clickRewardTab();
			log.info("reward tab is clicked");
		
		}
	
	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndRewardTab" })
	public void verifyAwardAndClicked() throws InterruptedException {
		
		boolean verifyOtherPaymentDeduction = addAward.verifyAwardRecordForBonus();
		log.info("Award record is displayed =====" + verifyOtherPaymentDeduction);
		Assert.assertEquals(verifyOtherPaymentDeduction, true);
		if (verifyOtherPaymentDeduction) {
			addAward.clickAwardRecordForBonus();
			log.info("Award record is clicked");
		
		}

	}

	@Test(dependsOnMethods = { "verifyAwardAndClicked" })
	@Parameters ({"verifyPaymentAmount"})
	public void verifyPaymentAmount(String paymentAmount) {
		String expectedPaymentAmount = paymentAmount;
		String actualPaymentAmount = addAward.paymentAmountMatchesForAwardBonus();
		log.info("Regular payment amount  =====" + actualPaymentAmount);
		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
		log.info("Award amount matches and test is passed");
		
	}

	
	@Test(dependsOnMethods = { "verifyPaymentAmount" })
	@Parameters ({"verifyRecordType"})
	public void verifyRecordType(String rcdType ) {
		String expectedRecordType = rcdType;
		String actualRecordType = addAward.recordTypeMatchesForAwardBonus();
		log.info("Regular payment amount  =====" + actualRecordType);
		Assert.assertEquals(actualRecordType, expectedRecordType);
		log.info("Record Type matches and test is passed");
		endTest();
	}
	


}
