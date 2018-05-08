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

public class TC002_SetupJoiner_WithLicenseWithExistingUser extends TestBase{
	JoinerPage joiner ;
	TC001_SetupJoiner_WithLicenseWithoutExistingUser setupJoinerWithoutLicense ;
	public static final Logger log = Logger.getLogger(TC002_SetupJoiner_WithLicenseWithExistingUser.class.getName());
	
	@DataProvider(name="UserCredentials")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getData("TestData.xls","LoginData"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	
	@Test (dataProvider = "UserCredentials")
	public void companyTabclick ( String username ,String password, String runMode) {
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("this user is inactive");
			
		}
		joiner = new JoinerPage(driver);
		log.info("======Starting test======");
	
		joiner.loginToApplication(username,password);
		
		boolean comanyTabDisplayed = joiner.verifyCompaniesTab();
		log.info("company tab is displayed===="+comanyTabDisplayed);
		Assert.assertEquals(comanyTabDisplayed, true);
		
		if(comanyTabDisplayed){
			joiner.clickOnCompaniesTab();
		}
	}	
		@Test (dependsOnMethods = { "companyTabclick" })
		@Parameters ({"existingUser"})
		public void goToNewJoinerPageAndSelectExistingUser(String existingUser) throws InterruptedException{
			joiner.clickGO();
			joiner.clickDNTcoreHRComp();
			joiner.clickNewJoinerButton();
			joiner.setupExistingUserWtihLicense(existingUser);
		
		}
	
		@Test (dependsOnMethods = { "goToNewJoinerPageAndSelectExistingUser" })
		@Parameters ({ "jTitle", "empStatus","empManager","empStartDate","empContineousStartDate" })
		public void setupFirstJoinerPage(String jTitle,String empStatus,String empManager,String empStartDate,String empContineousStartDate) throws InterruptedException{
			joiner.setupFirstPageOfJoinerAndClickNext(jTitle,empStatus,empManager,empStartDate,empContineousStartDate);
			
		}
		
		@Test (dependsOnMethods = { "setupFirstJoinerPage" })
		@Parameters ({ "empAddrFromDate", "addr1","empCity","empPostCode","empCountry","empAddrType","empNOK","empRegularPay","empPeriod" })
		public void verifySecoonPageAndSetupSecondPageOfJoiner(String empAddrFromDate,String addr1,String empCity,String empPostCode,String empCountry,String empAddrType,String empNOK,String empRegularPay,String empPeriod) throws InterruptedException{
			boolean saveButton = joiner.verifySecondPageRegularPay();
			log.info("777777777"+joiner.verifySecondPageRegularPay());
			log.info("88888888"+saveButton);
			Assert.assertEquals(saveButton, true);
			log.info("99999999"+saveButton);
			if(saveButton){
				joiner.setupSecondPageOfJoinerAndClickSave(empAddrFromDate,addr1,empCity,empPostCode,empCountry,empAddrType,empNOK,empRegularPay,empPeriod);
				
				 
		}
			 endTest();
		}
		
}






