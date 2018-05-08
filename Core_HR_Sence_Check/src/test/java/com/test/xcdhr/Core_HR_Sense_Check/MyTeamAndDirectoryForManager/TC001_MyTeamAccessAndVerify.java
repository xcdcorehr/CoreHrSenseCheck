package com.test.xcdhr.Core_HR_Sense_Check.MyTeamAndDirectoryForManager;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.ManagerTLapproveRejectReassignLR.TC001_ApproveLrAndVerify;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveApproveRejectReassignForManagerTlPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.MyTeamAndDirectoryForManagerPage;

public class TC001_MyTeamAccessAndVerify extends TestBase  {


	public static final Logger log = Logger.getLogger(TC001_MyTeamAccessAndVerify.class.getName());

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
	
	public void loginAndClickMyTeamTab ( String username ,String password, String runMode) {
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("this user is inactive");
			
		}
		myTeamMyDirectory = new MyTeamAndDirectoryForManagerPage(driver);
		log.info("======Starting test======");
	
		myTeamMyDirectory.loginToApplicationForEmployee(username,password);
		
		boolean myTeamTabDisplayed = myTeamMyDirectory.verifyMyTeamTab();
		log.info("My Team tab is displayed===="+myTeamTabDisplayed);
		Assert.assertEquals(myTeamTabDisplayed, true);
		
		if(myTeamTabDisplayed){
			myTeamMyDirectory.clickMyTeamTab();
			
		}
	
	}	
	@Test(dependsOnMethods ={"loginAndClickMyTeamTab"}) 
	public void ClickViewEmployee() throws InterruptedException{
		try {
			boolean verifyViewEmployeeIcon = myTeamMyDirectory.verifyViewIcon();
			log.info("firoz77777"+verifyViewEmployeeIcon);
			Assert.assertEquals(verifyViewEmployeeIcon, true);
			if(verifyViewEmployeeIcon)
				myTeamMyDirectory.clickViewEmployeeIcon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
   
	@Test(dependsOnMethods = { "ClickViewEmployee" })
	
	public void verifyMyTeamAccess() {
		try {
			String expectedEmail = "firoza@xcdhr.com";
			String actualEmail = myTeamMyDirectory.getEmployeeEmail();
			log.info("Actual email is  =====" + actualEmail);
			log.info("Expected email is  =====" + expectedEmail);
			Assert.assertEquals(actualEmail, expectedEmail);
			
			log.info("actual email and expected email is matching so the test case is pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTest();
	}

}
