package com.test.xcdhr.Core_HR_Sense_Check.AddOherPaymentOrDeduction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.AddOneOffPensionContribution.TC001_AddOneOffPensionContribution;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOneOffPensionContributionPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOtherPaymentOrDeductionPage;

public class TC001_AddOtherPaymentOrDeductionBenefitTypeAllowance extends TestBase {
	
	AddOtherPaymentOrDeductionPage addOtherPaymentDeduction ;
	public static final Logger log = Logger
			.getLogger(TC001_AddOneOffPensionContribution.class.getName());
	


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
	public void searchEmployeeForSetupOtherPaymentDeduction(String username,
			String password, String runMode)

	throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		addOtherPaymentDeduction = new AddOtherPaymentOrDeductionPage(driver);
		log.info("======Starting test======");

		addOtherPaymentDeduction.loginToApplication(username, password);

		boolean verifySearchBox = addOtherPaymentDeduction.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addOtherPaymentDeduction.enterEmployeeName();
		}
	}

	@Test(dependsOnMethods = { "searchEmployeeForSetupOtherPaymentDeduction" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		addOtherPaymentDeduction.clickVerifiedEmployee();

		boolean verifyRewardTab = addOtherPaymentDeduction.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		addOtherPaymentDeduction.clickRewardTab();

	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifyAddOtherPaymentDeductionButton() throws InterruptedException {

		boolean verifyAddOtherPaymentDeductionButton = addOtherPaymentDeduction
				.verifyAddOtherPaymentDeductionButton();
		log.info("Other Payment deduction button is displayed ====="
				+ verifyAddOtherPaymentDeductionButton);
		Assert.assertEquals(verifyAddOtherPaymentDeductionButton, true);
		Thread.sleep(3000);
		addOtherPaymentDeduction.clickAddOtherPaymentDeductionButton();

	}
	
	
	@Test(dependsOnMethods = { "verifyAddOtherPaymentDeductionButton" })
	@Parameters ({ "paymentDeductionType", "frequencyPayment","regularAmountOfPayment","effectiveFromDate" })
	public void VerifyAndSetupOtherPaymentDeduction(String paymentDeductionType,String frequencyPayment,String regularAmountOfPayment,String effectiveFromDate) throws InterruptedException {
		Thread.sleep(5000);
		addOtherPaymentDeduction.verifyBenefitTypePage();
		Thread.sleep(5000);
		try {
			//addOtherPaymentDeduction.selectBenefitType();
		
			addOtherPaymentDeduction.setupOtherPaymentDeductionForAllowance(paymentDeductionType,frequencyPayment,regularAmountOfPayment,effectiveFromDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "VerifyAndSetupOtherPaymentDeduction" })
	public void closeBroswe(){
		driver.quit();
	}

}
