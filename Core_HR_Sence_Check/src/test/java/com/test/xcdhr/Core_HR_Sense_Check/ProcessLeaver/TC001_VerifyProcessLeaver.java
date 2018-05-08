package com.test.xcdhr.Core_HR_Sense_Check.ProcessLeaver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ProcessLeaverPage;

public class TC001_VerifyProcessLeaver extends TestBase {
	ProcessLeaverPage processLeaver;

	public static final Logger log = Logger
			.getLogger(TC001_VerifyProcessLeaver.class.getName());

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
	public void searchLeaverEmployee

	(String username, String password, String runMode)
			throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		processLeaver = new ProcessLeaverPage(driver);
		log.info("======Starting test======");

		processLeaver.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = processLeaver.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			processLeaver.enterEmployeeName();
		}

	}
	/*@Test(dependsOnMethods = { "searchLeaverEmployee" })
	public void clickOnSearchedEmployee() {
		processLeaver.clickVerifiedEmployee();
	
	
	}
*/
	
	@Test(dependsOnMethods = { "searchLeaverEmployee" })
	@Parameters ({"leaverSection"})
	public void clickLeaverAndverifyLeaverSection(String leaverSection) {
		processLeaver.clickVerifiedEmployee();
		String expectedLeaverSection = leaverSection;
		String actualLeaverSection = processLeaver.leaverSectionMatch();
		log.info("Leaver section is  =====" + actualLeaverSection);
		Assert.assertEquals(actualLeaverSection, expectedLeaverSection);
		log.info("Leaver section is appeared and test is passed is passed");
		
	}
	
	@Test(dependsOnMethods = { "clickLeaverAndverifyLeaverSection" })
	@Parameters ({"leavingDate"})
	public void verifyLeavingDate(String leavingDate) {
		
		String expectedLeavingDate = leavingDate;
		String actualLeavingDate = processLeaver.leavingDateMatches();
		log.info("Leaving date is  =====" + actualLeavingDate);
		Assert.assertEquals(actualLeavingDate, expectedLeavingDate);
		log.info("Leaving date is appeared and test is passed is passed");
		
	}
	@Test(dependsOnMethods = { "verifyLeavingDate" })
	@Parameters ({"lastWorkingDate"})
	public void verifyLastWorkingDate(String lastWorkingDate) {
		
		String expectedLastWorkingDate = lastWorkingDate;
		String actualLastWorkingDate = processLeaver.lastWorkingDateMatches();
		log.info("Last working date is  =====" + actualLastWorkingDate);
		Assert.assertEquals(actualLastWorkingDate, expectedLastWorkingDate);
		log.info("Last working date is appeared and test is passed is passed");
		endTest();
	}
	
	
	
	
}
