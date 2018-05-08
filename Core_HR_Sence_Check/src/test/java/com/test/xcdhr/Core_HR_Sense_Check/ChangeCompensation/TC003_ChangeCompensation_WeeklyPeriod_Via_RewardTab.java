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

public class TC003_ChangeCompensation_WeeklyPeriod_Via_RewardTab extends TestBase {
	ChangeCompensationPage changeCompensatiom;
	public static final Logger log = Logger
			.getLogger(TC003_ChangeCompensation_WeeklyPeriod_Via_RewardTab.class.getName());

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
	public void searchCreatedEmployeeForChangeJR(String username,
			String password, String runMode)

	throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		changeCompensatiom = new ChangeCompensationPage(driver);
		log.info("======Starting test======");

		changeCompensatiom.loginToApplication(username, password);

		boolean verifySearchBox = changeCompensatiom.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			changeCompensatiom.enterEmployeeNameForWeeklyPeriod();
		}
	}

	@Test(dependsOnMethods = { "searchCreatedEmployeeForChangeJR" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		changeCompensatiom.clickVerifiedEmployeeForWeeklyPeriod();

		boolean verifyRewardTab = changeCompensatiom.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		changeCompensatiom.clickRewardTab();

	}

	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifyChangeCompButtonAndClick() throws InterruptedException {

		boolean verifyChangeCompButton = changeCompensatiom
				.verifyChangeCompButton();
		log.info("Change compnesation button is displayed ====="
				+ verifyChangeCompButton);
		Assert.assertEquals(verifyChangeCompButton, true);
		Thread.sleep(3000);
		changeCompensatiom.clickChangeCompButton();

	}

	@Test(dependsOnMethods = { "verifyChangeCompButtonAndClick" })
	@Parameters ({ "effectiveFrom", "regularPay","regularPeriod" })
	public void VerifyAndSetupChangeCompensation(String effectiveFrom,String regularPay,String regularPeriod) throws InterruptedException {
		Thread.sleep(5000);
		changeCompensatiom.verifyChangeCompensationPage();
		Thread.sleep(5000);
		try {
			changeCompensatiom.setupChangeCompensationWithPeriodAnnualAndWeekly(effectiveFrom,regularPay,regularPeriod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test(dependsOnMethods ={"VerifyAndSetupChangeCompensation"})
	public void closeBrowser(){
		driver.quit();
	}
	





}
