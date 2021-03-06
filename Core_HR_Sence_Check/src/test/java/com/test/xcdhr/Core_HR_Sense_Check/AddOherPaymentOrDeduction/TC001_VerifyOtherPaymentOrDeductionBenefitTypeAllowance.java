package com.test.xcdhr.Core_HR_Sense_Check.AddOherPaymentOrDeduction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.AddOneOffPensionContribution.TC001_VerifyAddOneOffPensionContribution;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOneOffPensionContributionPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOtherPaymentOrDeductionPage;

public class TC001_VerifyOtherPaymentOrDeductionBenefitTypeAllowance extends TestBase {

	AddOtherPaymentOrDeductionPage addOtherPaymentDeduction ; ;
	
	public static final Logger log = Logger
			.getLogger(TC001_VerifyOtherPaymentOrDeductionBenefitTypeAllowance.class.getName());
	
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
		addOtherPaymentDeduction = new AddOtherPaymentOrDeductionPage(driver);
		log.info("======Starting test======");

		addOtherPaymentDeduction.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = addOtherPaymentDeduction.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addOtherPaymentDeduction.enterEmployeeName();
		}

	}
	@Test(dependsOnMethods = { "searchEmployeeRecord" })
	public void clickOnSearchedEmployeeAndRewardTab() throws InterruptedException {
		addOtherPaymentDeduction.clickVerifiedEmployee();

		boolean rewardTab = addOtherPaymentDeduction.verifyRewardTab();
		log.info("Reward tab is displayed =====" + rewardTab);
		Assert.assertEquals(rewardTab, true);
		if (rewardTab) {
			addOtherPaymentDeduction.clickRewardTab();
			log.info("reward tab is clicked");
		
		}
	
	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndRewardTab" })
	public void verifyOtherPaymentDeductionAndClicked() throws InterruptedException {
		
		boolean verifyOtherPaymentDeduction = addOtherPaymentDeduction.verifyOtherPaymentDeductionAllowance();
		log.info("One of pension contribution is displayed =====" + verifyOtherPaymentDeduction);
		Assert.assertEquals(verifyOtherPaymentDeduction, true);
		if (verifyOtherPaymentDeduction) {
			addOtherPaymentDeduction.clickOtherPaymentDeductionAllowance();
			log.info("Other payment deduction is clicked");
		
		}

	}

	@Test(dependsOnMethods = { "verifyOtherPaymentDeductionAndClicked" })
	@Parameters ({"verifyRegularPaymentAmount"})
	public void verifyRegularPaymentAmount(String regularPaymentAmount) {
		String expectedRegularPaymentAmount = regularPaymentAmount;
		String actualRegularPaymentAmount = addOtherPaymentDeduction.regularPaymentAmountMatches();
		log.info("Regular payment amount  =====" + actualRegularPaymentAmount);
		Assert.assertEquals(actualRegularPaymentAmount, expectedRegularPaymentAmount);
		log.info("Regular payment amount matches and test is passed");
		
	}
	
	@Test(dependsOnMethods = { "verifyRegularPaymentAmount" })
	@Parameters ({"verifyAnnualAmount"})
	public void verifyAnnualBenefit(String annualPaymentAmount) {
		String expectedAnnualBenefit = annualPaymentAmount;
		String actualAnnualBenefit = addOtherPaymentDeduction.annualBenefitMatches();
		log.info("Annual benefit =====" + actualAnnualBenefit);
		Assert.assertEquals(actualAnnualBenefit, expectedAnnualBenefit);
		log.info("Annual benefit matches and test is passed");
		
	}
	@Test(dependsOnMethods = { "verifyAnnualBenefit" })
	public void closeBroswe(){
		driver.quit();
	}




}
