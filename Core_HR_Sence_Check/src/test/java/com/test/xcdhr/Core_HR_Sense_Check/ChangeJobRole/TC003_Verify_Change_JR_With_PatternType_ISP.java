package com.test.xcdhr.Core_HR_Sense_Check.ChangeJobRole;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ChangeJobRolePage;

public class TC003_Verify_Change_JR_With_PatternType_ISP extends TestBase {

	ChangeJobRolePage changeJR;

	public static final Logger log = Logger
			.getLogger(TC003_Verify_Change_JR_With_PatternType_ISP.class.getName());

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
	public void searchCreatedEmployeeForChangeJR

	(String username, String password, String runMode)
			throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		changeJR = new ChangeJobRolePage(driver);
		log.info("======Starting test======");

		changeJR.loginToApplication(username, password);
		getScreenShot(username);
		boolean verifySearchBox = changeJR.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			changeJR.enterEmployeeNameForISP();
		}

	}
	@Test(dependsOnMethods = { "searchCreatedEmployeeForChangeJR" })
	public void clickOnSearchedEmployeeAndJobTitle() {
		changeJR.clickVerifiedEmployeeISP();

		boolean verifySecondJR = changeJR.verifySecondJobRole();
		log.info("Job role is displayed =====" + verifySecondJR);
		Assert.assertEquals(verifySecondJR, true);
		if (verifySecondJR) {
			changeJR.clickSecondJobRole();
			log.info("job role is clicked");
		
		}

	}
	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndJobTitle" })
	@Parameters ({"SecondJobTitle"})
	public void verifySecondJobTitle(String secondJobTitle) {
		String expectedSecondJobTitle = secondJobTitle;
		String actualSecondJobTitle = changeJR.SecondJobRoleTittleMatches();
		log.info("Second job role title  =====" + actualSecondJobTitle);
		Assert.assertEquals(actualSecondJobTitle, expectedSecondJobTitle);
		log.info("Second job title verification is passed");
		endTest();
	}
	



}
