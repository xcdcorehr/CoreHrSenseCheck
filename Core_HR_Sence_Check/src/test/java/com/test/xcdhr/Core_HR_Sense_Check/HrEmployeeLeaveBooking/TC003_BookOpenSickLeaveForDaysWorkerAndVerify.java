package com.test.xcdhr.Core_HR_Sense_Check.HrEmployeeLeaveBooking;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveBookingForHrEmployeeManagerTlPage;

public class TC003_BookOpenSickLeaveForDaysWorkerAndVerify extends TestBase {
	public static final Logger log = Logger.getLogger(TC003_BookOpenSickLeaveForDaysWorkerAndVerify.class.getName());

	LeaveBookingForHrEmployeeManagerTlPage leaveBooking ;


	@DataProvider(name="HrEmployeeInputSheet")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getDataForHREmployee("HrEmployeeInputSheet.xls","LoginDataForHrEmployee"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	@Test (dataProvider = "HrEmployeeInputSheet")
	
	public void loginAndClickMyDetail ( String username ,String password, String runMode) {
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("this user is inactive");
			
		}
		leaveBooking = new LeaveBookingForHrEmployeeManagerTlPage(driver);
		log.info("======Starting test======");
	
		leaveBooking.loginToApplicationForEmployee(username,password);
		
		boolean myDetailTabDisplayed = leaveBooking.verifyMyDetailTab();
		log.info("My detail tab is displayed===="+myDetailTabDisplayed);
		Assert.assertEquals(myDetailTabDisplayed, true);
		
		if(myDetailTabDisplayed){
			leaveBooking.clickMyDetailTab();
			
		}
	
	}	
	@DataProvider(name="LeaveRequestData")
	public  String[][] getTestDataforLeaveRequest(){
		String[][] leaveData = getDataForHREmployee("HrEmployeeInputSheet.xls","OpenSickLeaveRequestData"); 
		return leaveData ;
		
	}
	@Test(dataProvider = "LeaveRequestData",dependsOnMethods ={"loginAndClickMyDetail"}) 
	public void setupLrAndSubmit(String lCategory,String startDate,String endDate, String startDateAmPm,String endDateAmPm) throws InterruptedException{
		leaveBooking.clickBookLeavebutton();
		boolean verifyLrPage = leaveBooking.verifyBookLeavePage();
		Assert.assertEquals(verifyLrPage, true);
		log.info("--------"+verifyLrPage);
		if(verifyLrPage){
		leaveBooking.setupOpenSicklLeaveRequestAndSubmit(lCategory,startDate,endDate,startDateAmPm,endDateAmPm);
		}
		endTest();
}
}
