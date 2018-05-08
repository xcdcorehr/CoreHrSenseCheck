package com.test.xcdhr.Core_HR_Sense_Check.AddAward;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddAwardPage;

public class TC002_VerifyAwardWithAwardTypeCommission extends TestBase{

AddAwardPage addAward ; ; 
	
	public static final Logger log = Logger
			.getLogger(TC002_VerifyAwardWithAwardTypeCommission.class.getName());
	
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
		
		boolean verifyOtherPaymentDeduction = addAward.verifyAwardRecordForCommission();
		log.info("Award record is displayed =====" + verifyOtherPaymentDeduction);
		Assert.assertEquals(verifyOtherPaymentDeduction, true);
		if (verifyOtherPaymentDeduction) {
			addAward.clickAwardRecordForCommision();
			log.info("Award record is clicked");
		
		}

	}

	@Test(dependsOnMethods = { "verifyAwardAndClicked" })
	@Parameters ({"verifyPaymentAmount"})
	public void verifyPaymentAmount(String paymentAmount) {
		String expectedPaymentAmount = paymentAmount;
		String actualPaymentAmount = addAward.paymentAmountMatchesForAwardCommission();
		log.info("Actual Regular payment amount  =====" + actualPaymentAmount);
		log.info("Expected Regular payment amount  =====" + expectedPaymentAmount);
		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
		log.info("Expected regular payment amount==="+expectedPaymentAmount+"   and found regular payment amount==="+actualPaymentAmount);
		
	}

	
	@Test(dependsOnMethods = { "verifyPaymentAmount" })
	@Parameters ({"verifyRecordType"})
	public void verifyRecordType(String rcdType ) throws InterruptedException {
		String expectedRecordType = rcdType;
		String actualRecordType = addAward.recordTypeMatchesForAwardCommission();
		log.info("Record type actual  =====" + actualRecordType);
		log.info("Record type expected  =====" + expectedRecordType);
		Assert.assertEquals(expectedRecordType, actualRecordType);
		log.info("Expected record type==="+expectedRecordType+"   and found record type==="+actualRecordType);
		Thread.sleep(4000);
		endTest();
	}
	
	
	
}
