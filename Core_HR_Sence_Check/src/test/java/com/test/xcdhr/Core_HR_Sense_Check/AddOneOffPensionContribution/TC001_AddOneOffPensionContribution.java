package com.test.xcdhr.Core_HR_Sense_Check.AddOneOffPensionContribution;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.ChangeCompensation.TC001_ChangeCompensation_MonthlyPeriod_Via_RewardTab;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOneOffPensionContributionPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ChangeCompensationPage;

public class TC001_AddOneOffPensionContribution extends TestBase {
	AddOneOffPensionContributionPage addOneOffPensionContribution ;
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
	public void searchCreatedEmployeeForChangeJR(String username,
			String password, String runMode)

	throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		addOneOffPensionContribution = new AddOneOffPensionContributionPage(driver);
		log.info("======Starting test======");

		addOneOffPensionContribution.loginToApplication(username, password);

		boolean verifySearchBox = addOneOffPensionContribution.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addOneOffPensionContribution.enterEmployeeName();
		}
	}

	@Test(dependsOnMethods = { "searchCreatedEmployeeForChangeJR" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		addOneOffPensionContribution.clickVerifiedEmployee();

		boolean verifyRewardTab = addOneOffPensionContribution.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		addOneOffPensionContribution.clickRewardTab();

	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifyAddOneffPensionCOntributionButton() throws InterruptedException {

		boolean verifyAddOneOffPensionContributionButton = addOneOffPensionContribution
				.verifyOneOffPensionContributionButton();
		log.info("One Off Pension contribution button is displayed ====="
				+ verifyAddOneOffPensionContributionButton);
		Assert.assertEquals(verifyAddOneOffPensionContributionButton, true);
		Thread.sleep(3000);
		addOneOffPensionContribution.clickOneOffPensionContributionButton();

	}
	
	
	@Test(dependsOnMethods = { "verifyAddOneffPensionCOntributionButton" })
	@Parameters ({ "typeOfPension", "awardDate","payentEarliestDate","employerrContribution","employeeeContribution" })
	public void VerifyAndSetupOneOffPensionContribution(String typeOfPension,String awardDate,String payentEarliestDate,String employerrContribution, String employeeeContribution) throws InterruptedException {
		Thread.sleep(5000);
		addOneOffPensionContribution.verifyAddOneOffPensionContributionPage();
		Thread.sleep(5000);
		try {
			addOneOffPensionContribution.setupOneOffPensaionCOntribution(typeOfPension,awardDate,payentEarliestDate,employerrContribution,employeeeContribution);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = { "VerifyAndSetupOneOffPensionContribution" })
	public void closeBrowser(){
		driver.quit();
	}
	
	
	
}
