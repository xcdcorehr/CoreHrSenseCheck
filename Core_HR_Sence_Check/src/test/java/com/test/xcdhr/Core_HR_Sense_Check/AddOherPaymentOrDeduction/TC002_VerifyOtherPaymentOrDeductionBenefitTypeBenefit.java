package com.test.xcdhr.Core_HR_Sense_Check.AddOherPaymentOrDeduction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOtherPaymentOrDeductionPage;

public class TC002_VerifyOtherPaymentOrDeductionBenefitTypeBenefit extends TestBase {
	
AddOtherPaymentOrDeductionPage addOtherPaymentDeduction ; ;
	
	public static final Logger log = Logger
			.getLogger(TC002_VerifyOtherPaymentOrDeductionBenefitTypeBenefit.class.getName());
	
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
		
		boolean verifyOtherPaymentDeduction = addOtherPaymentDeduction.verifyOtherPaymentDeductionBenefit();
		log.info("One of pension contribution is displayed =====" + verifyOtherPaymentDeduction);
		Assert.assertEquals(verifyOtherPaymentDeduction, true);
		if (verifyOtherPaymentDeduction) {
			addOtherPaymentDeduction.clickOtherPaymentDeductionBenefit();
			log.info("Other payment deduction is clicked");
		
		}

	}

	@Test(dependsOnMethods = { "verifyOtherPaymentDeductionAndClicked" })
	@Parameters ({"totalAnnualContribution"})
	public void verifyTotalAnnualContribution(String totalAnnualContribution) {
		String expectedTotalAnnualContribution = totalAnnualContribution;
		String actualTotalAnnualContribution = addOtherPaymentDeduction.totalAnnualContributionMatches();
		log.info("Regular payment amount  =====" + actualTotalAnnualContribution);
		Assert.assertEquals(actualTotalAnnualContribution, expectedTotalAnnualContribution);
		log.info("Total annual contribution amount is matches and test is passed");
		
	}
	
	@Test(dependsOnMethods = { "verifyTotalAnnualContribution" })
	public void closeBroswe(){
		driver.quit();
	}

	
	
	
	
	
	
}
