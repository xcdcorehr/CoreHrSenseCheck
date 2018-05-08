package com.test.xcdhr.Core_HR_Sense_Check.home;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LoginPage;

public class TC001_verifyLogin extends TestBase {
	public static final Logger log = Logger.getLogger(TC001_verifyLogin.class.getName());
	LoginPage loginpage;
	
	
	@DataProvider(name="UserCredentials")
	public  String[][] getTestData(){
		String[][] testUsers = getData("TestData.xls","LoginData"); 
		return testUsers ;
		
	}

	
	
	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}

	@Test(dataProvider = "UserCredentials")
	
	
	public void verifyLogin(String username ,String password ,String runMode  ) {
		
		
		log.info("======Starting test======");

		
		
				loginpage = new LoginPage(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		
		loginpage.loginToApplication(username,password);
		 boolean comanyTabDisplayed = loginpage.verifyCompaniesTab();
		if(comanyTabDisplayed){
			loginpage.clickOnCompaniesTab();
		}
		
		Assert.assertEquals(comanyTabDisplayed, true);
		log.info("======Company tab displayed======"+comanyTabDisplayed);
		
		log.info("======Logged in successfully======");
	} 


	@AfterTest
	public void endTest() {
		driver.close();
	}

}
