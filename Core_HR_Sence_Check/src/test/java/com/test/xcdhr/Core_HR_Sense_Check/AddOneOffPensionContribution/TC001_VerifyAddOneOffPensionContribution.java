package com.test.xcdhr.Core_HR_Sense_Check.AddOneOffPensionContribution;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.JoinerProcess.TC001_SetupJoiner_WithLicenseWithoutExistingUser;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddOneOffPensionContributionPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ChangeJobRolePage;

public class TC001_VerifyAddOneOffPensionContribution extends TestBase {

	AddOneOffPensionContributionPage addOneOffPensionContribution ;
	
	public static final Logger log = Logger
			.getLogger(TC001_VerifyAddOneOffPensionContribution.class.getName());
	
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
		addOneOffPensionContribution = new AddOneOffPensionContributionPage(driver);
		log.info("======Starting test======");

		addOneOffPensionContribution.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = addOneOffPensionContribution.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addOneOffPensionContribution.enterEmployeeName();
		}

	}
	@Test(dependsOnMethods = { "searchEmployeeRecord" })
	public void clickOnSearchedEmployeeAndRewardTab() throws InterruptedException {
		addOneOffPensionContribution.clickVerifiedEmployee();

		boolean rewardTab = addOneOffPensionContribution.verifyRewardTab();
		log.info("Reward tab is displayed =====" + rewardTab);
		Assert.assertEquals(rewardTab, true);
		if (rewardTab) {
			addOneOffPensionContribution.clickRewardTab();
			log.info("job role is clicked");
		
		}
	
	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndRewardTab" })
	public void verifyOneOffPensionContributionAndClicked() {
		
		boolean verifyOneoffPensionContribution = addOneOffPensionContribution.verifyOneOffPensionContribution();
		log.info("One of pension contribution is displayed =====" + verifyOneoffPensionContribution);
		Assert.assertEquals(verifyOneoffPensionContribution, true);
		if (verifyOneoffPensionContribution) {
			addOneOffPensionContribution.clickOneOffPensionContribution();
			log.info("One off pension contribution is clicked");
		
		}

	}

	@Test(dependsOnMethods = { "verifyOneOffPensionContributionAndClicked" })
	@Parameters ({"verifyEmployerContribution"})
	public void verifyEmployerContribution(String employerrAmount) {
		String expectedEmployerContribution = employerrAmount;
		String actualEmployerContribution = addOneOffPensionContribution.employerContributionMatches();
		log.info("Employer contribution  =====" + actualEmployerContribution);
		Assert.assertEquals(actualEmployerContribution, expectedEmployerContribution);
		log.info("Employer contribution matches and test is passed");
		
	}
	
	@Test(dependsOnMethods = { "verifyEmployerContribution" })
	@Parameters ({"verifyEmployeeContribution"})
	public void verifyEmployeeContribution(String employeeeAmount) {
		String expectedEmployeeContribution = employeeeAmount;
		String actualEmployeeContribution = addOneOffPensionContribution.employeeContributionMatches();
		log.info("Employer contribution  =====" + actualEmployeeContribution);
		Assert.assertEquals(actualEmployeeContribution, expectedEmployeeContribution);
		log.info("Employee contribution matches and test is passed");
		
	}
	
	@Test(dependsOnMethods = { "verifyEmployeeContribution" })
	public void closeBrowser(){
		driver.quit();
	}







}
