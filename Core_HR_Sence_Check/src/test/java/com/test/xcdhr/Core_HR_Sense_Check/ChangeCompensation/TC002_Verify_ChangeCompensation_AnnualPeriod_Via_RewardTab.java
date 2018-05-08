package com.test.xcdhr.Core_HR_Sense_Check.ChangeCompensation;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ChangeCompensationPage;

public class TC002_Verify_ChangeCompensation_AnnualPeriod_Via_RewardTab extends TestBase {
	
	ChangeCompensationPage changeCompensation;

	public static final Logger log = Logger
			.getLogger(TC002_Verify_ChangeCompensation_AnnualPeriod_Via_RewardTab.class
					.getName());

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
	public void searchCreatedEmployeeForChangeCompensation

	(String username, String password, String runMode)
			throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		changeCompensation = new ChangeCompensationPage(driver);
		log.info("======Starting test======");

		changeCompensation.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = changeCompensation.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			changeCompensation.enterEmployeeNameForAnnualPeriod();
		}

	}

	@Test(dependsOnMethods = { "searchCreatedEmployeeForChangeCompensation" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		changeCompensation.clickVerifiedEmployeeForAnnualPeriod();

		boolean verifyRewardTab = changeCompensation.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		changeCompensation.clickRewardTab();
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifySecondCompensationAndClickSecondCompensation()
			throws InterruptedException {

		boolean verifySecondCompensation1 = changeCompensation
				.verifySecondCompensation();
		Thread.sleep(5000);
		log.info("Second compensation is displayed ====="
				+ verifySecondCompensation1);
		Assert.assertEquals(verifySecondCompensation1, true);
		if (verifySecondCompensation1) {
			changeCompensation.clickSecondCompensation();
			log.info("Second compesation is clicked");

		}

	}

	@Test(dependsOnMethods = { "verifySecondCompensationAndClickSecondCompensation" })
	@Parameters ({"secondCompensation"})
	public void verifySecondCompensation(String secondComp ) {

		String expectedSecondCompensation = secondComp;
		//"GBP 24,000.00"
		String actualSecondCompensation = changeCompensation
				.SecondCompensationAnnualSalaryMatches();
		log.info("Second compensation annual amount  ====="
				+ actualSecondCompensation);
		Assert.assertEquals(actualSecondCompensation,
				expectedSecondCompensation);
		log.info("Second compensation annual salary amount is verified and test is passed");
	}

	@Test(dependsOnMethods ={"verifySecondCompensation"})
	public void closeBrowser(){
		driver.quit();
	}
	
	
	
	
}
