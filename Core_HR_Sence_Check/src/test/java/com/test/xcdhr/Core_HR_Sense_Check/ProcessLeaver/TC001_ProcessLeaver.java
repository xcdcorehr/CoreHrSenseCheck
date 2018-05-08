package com.test.xcdhr.Core_HR_Sense_Check.ProcessLeaver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.AddAward.TC001_AddAwardWithAwardTypeBonus;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddPaymentOrDeductionPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ProcessLeaverPage;

public class TC001_ProcessLeaver extends TestBase {

	ProcessLeaverPage processLeaver;
	public static final Logger log = Logger.getLogger(TC001_ProcessLeaver.class
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
	public void searchEmployeeForSetupOtherPaymentDeduction(String username,
			String password, String runMode)

	throws InterruptedException {
		if (runMode.equalsIgnoreCase("N")) {
			throw new SkipException("this user is inactive");

		}
		processLeaver = new ProcessLeaverPage(driver);
		log.info("======Starting test======");

		processLeaver.loginToApplication(username, password);

		boolean verifySearchBox = processLeaver.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			processLeaver.enterEmployeeName();
		}
	}

	@Test(dependsOnMethods = { "searchEmployeeForSetupOtherPaymentDeduction" })
	public void clickOnSearchedEmployeeAndVerifyLeaverButton()
			throws InterruptedException {
		processLeaver.clickVerifiedEmployee();

		boolean verifyLeaverButton = processLeaver.verifyLeaverButton();
		log.info("Leaver button is displayed =====" + verifyLeaverButton);
		Assert.assertEquals(verifyLeaverButton, true);
		processLeaver.clickLeaverButton();

	}

	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyLeaverButton" })
	@Parameters({ "noticeDate", "dateOfLeaving", "lastWorkingDay",
			"leavingReason","lastPayRun" })
	public void VerifyAndProcessLeaver(String noticeDate, String dateOfLeaving,
			String lastWorkingDay, String leavingReason,String lastPayRun)
			throws InterruptedException {
		Thread.sleep(5000);
		processLeaver.verifyLeavePage();
		Thread.sleep(5000);
		try {

			processLeaver.processsLeaver(noticeDate, dateOfLeaving,
					lastWorkingDay,leavingReason,lastPayRun);
			isAlertPresent();
			//clickOKAfterCompleteLeaver();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		endTest();
	}

}
