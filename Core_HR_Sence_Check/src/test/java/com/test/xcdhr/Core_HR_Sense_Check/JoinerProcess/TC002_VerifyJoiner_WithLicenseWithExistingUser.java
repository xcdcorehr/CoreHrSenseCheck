package com.test.xcdhr.Core_HR_Sense_Check.JoinerProcess;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.JoinerPage;

public class TC002_VerifyJoiner_WithLicenseWithExistingUser extends TestBase {
	JoinerPage joiner ;
	public static final Logger log = Logger
			.getLogger(TC002_VerifyJoiner_WithLicenseWithExistingUser.class.getName());

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
	public void searchCreatedEmployee(String username, String password,
			String runMode) throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		joiner = new JoinerPage(driver);
		log.info("======Starting test======");

		joiner.loginToApplication(username, password);

		boolean verifySearchBox = joiner.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			joiner.enterEmployeeNameWithLicense();
		}

	}

	@Test(dependsOnMethods = { "searchCreatedEmployee" })
	public void clickOnSearchedEmployee() {
		joiner.clickVerifiedEmployeeWithActiveLicense();

		boolean verifyJR = joiner.verifyJobRole();
		log.info("Job role is displayed =====" + verifyJR);
		Assert.assertEquals(verifyJR, true);
		if (verifyJR) {
			joiner.clickJobRole();
			log.info("job role is clicked");
		}

	}

	@Test(dependsOnMethods = { "clickOnSearchedEmployee" })
	@Parameters ({ "expectedJTitle" })
	public void verifyJobTitleOfCreatedEmployee(String expectedJTitle) {
		String expectedJobTitle = expectedJTitle;
		String verifyJobTitle = joiner.JobRoleTittleMatches();
		log.info(" Expected annual Salary amount  =====" + expectedJobTitle);
		log.info(" Actual annual Salary amount  =====" + verifyJobTitle);
		Assert.assertEquals(verifyJobTitle, expectedJobTitle);

	}

	@Test(dependsOnMethods = { "verifyJobTitleOfCreatedEmployee" })
	public void verifyEmployeeNameOnJobRoleAndGoBackToEmployment() {
		boolean verifyEmpName = joiner.verifyEmployeeOnJobrole1();
		log.info("employee is displayed =====" + verifyEmpName);
		Assert.assertEquals(verifyEmpName, true);
		if (verifyEmpName) {
			joiner.goBacktoEmploymentFromJobRole1();
			log.info("Employee is clicked");
		}

	}

	@Test(dependsOnMethods = { "verifyEmployeeNameOnJobRoleAndGoBackToEmployment" })
	public void verifyRewardTabAndClickedRewardTab()
			throws InterruptedException {
		boolean verifyRewardTab = joiner.verifyRewardTab();
		log.info("RewardTab is displayed=====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		if (verifyRewardTab) {
			joiner.clickRewardTab();
			log.info("Reward tab is clicked");
		}

	}

	@Test(dependsOnMethods = { "verifyRewardTabAndClickedRewardTab" })
	@Parameters ({"expectedAnnualSal"})
	public void verifyAnnualSalaryOfCreatedCompensation(String expectedAnnualSal) {
		String expectedAnnualSalary = expectedAnnualSal;
		String actualAnnualSalary = joiner.VerifyCompnesationAmount();
		log.info(" Expected annual Salary amount  =====" + expectedAnnualSalary);
		log.info(" Actual annual Salary amount  =====" + actualAnnualSalary);
		Assert.assertEquals(actualAnnualSalary, expectedAnnualSalary);
		   endTest();
	}

	


}
