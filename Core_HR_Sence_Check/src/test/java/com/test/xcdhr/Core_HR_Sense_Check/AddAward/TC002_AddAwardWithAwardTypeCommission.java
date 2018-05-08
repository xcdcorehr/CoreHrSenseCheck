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

public class TC002_AddAwardWithAwardTypeCommission extends TestBase {
	AddAwardPage addAward ;
	public static final Logger log = Logger
			.getLogger(TC002_AddAwardWithAwardTypeCommission.class.getName());

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
		addAward = new AddAwardPage(driver);
		log.info("======Starting test======");

		addAward.loginToApplication(username, password);

		boolean verifySearchBox = addAward.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addAward.enterEmployeeName();
		}
	}

	@Test(dependsOnMethods = { "searchEmployeeForSetupOtherPaymentDeduction" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		addAward.clickVerifiedEmployee();

		boolean verifyRewardTab = addAward.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		addAward.clickRewardTab();

	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifyAwardButton() throws InterruptedException {

		boolean verifyAwardButton = addAward
				.VerifyAddAwardButton();
		log.info("Award button is displaying ====="
				+ verifyAwardButton);
		Assert.assertEquals(verifyAwardButton, true);
		Thread.sleep(7000);
		addAward.clickAwardButton();

	}
	
	
	@Test(dependsOnMethods = { "verifyAwardButton" })
	@Parameters ({ "typeAward", "awardDate","amountOfPayment","earliestPaymentDate" })
	public void VerifyAndSetupAward(String typeAward,String awardDate,String earliestPaymentDate,String amountOfPayment) throws InterruptedException {
		Thread.sleep(5000);
		addAward.verifyAwardTypePage();
		Thread.sleep(5000);
		try {
			//addOtherPaymentDeduction.selectBenefitType();
		
			addAward.setupAwardForCommission(typeAward,awardDate,earliestPaymentDate,amountOfPayment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(4000);
		endTest();
	}
	
	
}
