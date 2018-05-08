package com.test.xcdhr.Core_HR_Sense_Check.ChangeJobRole;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.JoinerProcess.TC001_SetupJoiner_WithLicenseWithoutExistingUser;
import com.test.xcdhr.Core_HR_Sense_Check.JoinerProcess.TC001_VerifyJoiner_WithLicenseWithoutExistingUser;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.ChangeJobRolePage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.JoinerPage;

public class TC001_Change_JR_With_PatternType_RWPD extends TestBase {

	ChangeJobRolePage changeJR;
	public static final Logger log = Logger
			.getLogger(TC001_Change_JR_With_PatternType_RWPD.class.getName());

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

		boolean verifySearchBox = changeJR.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			changeJR.enterEmployeeNameForRWPD();
		}

	}

	@Test(dependsOnMethods = { "searchCreatedEmployeeForChangeJR" })
	public void clickOnSearchedEmployee() {
		changeJR.clickVerifiedEmployeeRWPD();

		boolean verifyJR = changeJR.verifyFirstJobRole();
		log.info("Job role is displayed =====" + verifyJR);
		Assert.assertEquals(verifyJR, true);
		if (verifyJR) {
			changeJR.clickFirstJobRole();
			log.info("job role is clicked");

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changeJR.clickChangeJobroleButton();
	}
	
	@Test(dependsOnMethods = { "clickOnSearchedEmployee" })
	@Parameters ({ "jobTitle", "startDate" })
	public void clickSave(String jobTitle,String startDate) throws InterruptedException {
		Thread.sleep(5000);
		changeJR.verifyChangeJobROlePage();
		Thread.sleep(5000);
		try {
			changeJR.setupChangeJobROleWithRWPD(jobTitle, startDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      endTest();
	}

}
