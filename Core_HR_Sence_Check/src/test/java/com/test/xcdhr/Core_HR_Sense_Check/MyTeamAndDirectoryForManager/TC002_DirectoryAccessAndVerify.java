package com.test.xcdhr.Core_HR_Sense_Check.MyTeamAndDirectoryForManager;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.MyTeamAndDirectoryForManagerPage;

public class TC002_DirectoryAccessAndVerify extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_DirectoryAccessAndVerify.class.getName());

	MyTeamAndDirectoryForManagerPage myTeamMyDirectory ;


	@DataProvider(name="HrManagerInputSheet")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getDataForHRManagerTL("HrManagerInputSheet.xls","LoginDataForManager"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	@Test (dataProvider = "HrManagerInputSheet")
	
	public void loginAndClickDirectoryTab ( String username ,String password, String runMode) {
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("this user is inactive");
			
		}
		myTeamMyDirectory = new MyTeamAndDirectoryForManagerPage(driver);
		log.info("======Starting test======");
	
		myTeamMyDirectory.loginToApplicationForEmployee(username,password);
		
		boolean directoryTabDisplayed = myTeamMyDirectory.verifyDirectoryTab();
		log.info("directory tab is displayed===="+directoryTabDisplayed);
		Assert.assertEquals(directoryTabDisplayed, true);
		
		if(directoryTabDisplayed){
			myTeamMyDirectory.clickDirectoryTab();
			
		}
	
	}	
	@Test(dependsOnMethods ={"loginAndClickDirectoryTab"}) 
	public void searchEmployee() throws InterruptedException{
		boolean verifySearchInput = myTeamMyDirectory.verifySearchInput();
		log.info("firoz77777"+verifySearchInput);
		Assert.assertEquals(verifySearchInput, true);
		if(verifySearchInput)
			myTeamMyDirectory.enterEmployeeForSearch();
			Thread.sleep(3000);
		//	myTeamMyDirectory.clickAlphabetD();
			
	}	
@Test(dependsOnMethods = { "searchEmployee" })
	
	public void verifySearchedEmployee() {
		String expectedSearchedEmp = "DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ";
		String actualSearchedEmp = myTeamMyDirectory.getSearchedEmployee();
		log.info("Expected employee is  =====" + actualSearchedEmp);
		log.info("Searched employee is  =====" + expectedSearchedEmp);
		Assert.assertEquals(actualSearchedEmp, expectedSearchedEmp);
		log.info("Expected employee and actual employee is matching so the test case is pass");
		endTest();
	}

}
