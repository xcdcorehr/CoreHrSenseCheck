package com.test.xcdhr.Core_HR_Sense_Check.AddPaymentOrDeduction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.AddPaymentOrDeductionPage;

public class TC003_AddPaymentOrDeductionOneOffPaymentType extends TestBase{

	AddPaymentOrDeductionPage addPaymentDeduction;
	public static final Logger log = Logger
			.getLogger(TC003_AddPaymentOrDeductionOneOffPaymentType.class.getName());

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
		addPaymentDeduction = new AddPaymentOrDeductionPage(driver);
		log.info("======Starting test======");

		addPaymentDeduction.loginToApplication(username, password);

		boolean verifySearchBox = addPaymentDeduction.verifySeacrchBox();

		log.info("Searchbox is displayed====" + verifySearchBox);
		Assert.assertEquals(verifySearchBox, true);

		if (verifySearchBox) {
			addPaymentDeduction.enterEmployeeName();
		}
	}

	@Test(dependsOnMethods = { "searchEmployeeForSetupOtherPaymentDeduction" })
	public void clickOnSearchedEmployeeAndVerifyRewardTab()
			throws InterruptedException {
		addPaymentDeduction.clickVerifiedEmployee();

		boolean verifyRewardTab = addPaymentDeduction.verifyRewardTab();
		log.info("Reward tab is displayed =====" + verifyRewardTab);
		Assert.assertEquals(verifyRewardTab, true);
		addPaymentDeduction.clickRewardTab();

	}

	@Test(dependsOnMethods = { "clickOnSearchedEmployeeAndVerifyRewardTab" })
	public void verifyPaymentDeductionButton() throws InterruptedException {

		boolean verifyPaymentDeductionButton = addPaymentDeduction
				.verifyPaymentDeductionButton();
		log.info("Payment dedution button is displaying ====="
				+ verifyPaymentDeductionButton);
		Assert.assertEquals(verifyPaymentDeductionButton, true);
		Thread.sleep(7000);
		addPaymentDeduction.clickpaymentDeductionButton();

	}

	@Test(dependsOnMethods = { "verifyPaymentDeductionButton" })
	@Parameters ({ "typeOfPaymenttDeduction", "paymentAmount" })
	public void VerifyAndSetupPaymentDeduction(String typeOfPaymenttDeduction,String paymentAmount) throws InterruptedException {
		
			try{
			addPaymentDeduction.setupPaymentDedcutionForOneOffPayment(typeOfPaymenttDeduction,paymentAmount);
			}
			catch(Exception e){
				log.info(e);
			}
			endTest();
		}

}
