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

public class TC005_CancelAnnualLeaveAndVerify extends TestBase {
	public static final Logger log = Logger.getLogger(TC005_CancelAnnualLeaveAndVerify.class.getName());

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
	
	public void loginAndClickMyDetail ( String username ,String password, String runMode) throws InterruptedException {
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
		boolean leaveSubTabDisplayed = leaveBooking.verifyLeaveSubTab();
		log.info("My leave tab is displayed===="+leaveSubTabDisplayed);
		Assert.assertEquals(leaveSubTabDisplayed, true);
		
		if(leaveSubTabDisplayed){
			leaveBooking.clickLeaveSubTab();
		}	
	  
		boolean leaveCancelIcon = leaveBooking.verifyCancelIcon();
		Assert.assertEquals(leaveCancelIcon, true);
		log.info("0909090"+leaveCancelIcon);
		if(leaveCancelIcon){
			log.info("080808"+leaveCancelIcon);
			Thread.sleep(5000);
			leaveBooking.clickCancelIcon();
			Thread.sleep(5000);
			isAlertPresent();
		}
	
	}	
	
	
	
	
	}
	
	
	

