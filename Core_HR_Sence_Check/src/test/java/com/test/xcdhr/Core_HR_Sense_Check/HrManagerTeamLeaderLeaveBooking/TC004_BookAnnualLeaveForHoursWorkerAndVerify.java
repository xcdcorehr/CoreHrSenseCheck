package com.test.xcdhr.Core_HR_Sense_Check.HrManagerTeamLeaderLeaveBooking;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveBookingForHrEmployeeManagerTlPage;

public class TC004_BookAnnualLeaveForHoursWorkerAndVerify extends TestBase {
	public static final Logger log = Logger.getLogger(TC004_BookAnnualLeaveForHoursWorkerAndVerify.class.getName());

	LeaveBookingForHrEmployeeManagerTlPage leaveBooking ;


	@DataProvider(name="HrManagerInputSheet")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getDataForHREmployee("HrManagerInputSheet.xls","LoginDataForHrEmployee"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	@Test (dataProvider = "HrManagerInputSheet")
	
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
		String[][] leaveData = getDataForHREmployee("HrManagerInputSheet.xls","AnnualLeaveRequestDataForHours"); 
		return leaveData ;
		
	}
	@Test(dataProvider = "LeaveRequestData",dependsOnMethods ={"loginAndClickMyDetail"}) 
	public void setupLrAndSubmit(String lCategory,String endDate, String startDate,String startDateAmPm,String endDateAmPm,String hoursBookedhh,String mm) throws InterruptedException{
		leaveBooking.clickBookLeavebutton();
		boolean verifyLrPage = leaveBooking.verifyBookLeavePage();
		Assert.assertEquals(verifyLrPage, true);
		log.info("--------"+verifyLrPage);
		if(verifyLrPage){
		leaveBooking.setupAnnualLeaveRequestForHoursAndSubmit(lCategory,endDate,startDate,startDateAmPm,endDateAmPm,hoursBookedhh,mm);
		}
		
		
	}
	
	@Test(dependsOnMethods = { "setupLrAndSubmit" })
	public void verifyLRForHoursWorker() throws Exception{
		String excelLocation = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrManagerResult.xlsx";
		excelReader exr = new excelReader(excelLocation);
		
		
		String sheetName = "LeaveRequestForHoursResult";
		String columnmnName  ;
		String actualDuration = leaveBooking.getDurationForHours();
		String actualLeaveCategory = leaveBooking.getLeaveCategoryForHours();
		String actualApprovalStatus = leaveBooking.getApprovalStatusForHours();
		

		String excpectedDuration =exr.getCellData( sheetName,"Expected result",2); 
		String excpectedLeaveCategory  =exr.getCellData( sheetName,"Expected result",3);
		String excpectedApprovalStatus =exr.getCellData( sheetName,"Expected result",4);
		
		
		excelReader.updateResult(excelLocation,sheetName,"Verify duration",actualDuration);
		excelReader.updateResult(excelLocation,sheetName,"Verify leave category",actualLeaveCategory);
		excelReader.updateResult(excelLocation,sheetName,"Verify approval status",actualApprovalStatus);
		
		
		if(actualDuration.equals(excpectedDuration)){
		
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify duration","PASS");
		}
		else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify duration","FAIL");
		}
		if(actualLeaveCategory.equals(excpectedLeaveCategory)){
				excelReader.updateTestStatus(excelLocation,sheetName,"Verify leave category","PASS");
		}
		else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify leave category","FAIL");
		}
		if(actualApprovalStatus.equals(excpectedApprovalStatus)){
				excelReader.updateTestStatus(excelLocation,sheetName,"Verify approval status","PASS");
		}
		else{
				excelReader.updateTestStatus(excelLocation,sheetName,"Verify approval status","FAIL");
		}
		
		endTest();
	}
	
	
	
	
}
