package com.test.xcdhr.Core_HR_Sense_Check.ManagerTLapproveRejectReassignLR;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.HrEmployeeLeaveBooking.TC001_BookAnnualLeaveForDaysWorkerAndVerify;
import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveApproveRejectReassignForManagerTlPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveBookingForHrEmployeeManagerTlPage;

public class TC001_ApproveLrAndVerify extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC001_ApproveLrAndVerify.class.getName());

	LeaveApproveRejectReassignForManagerTlPage leaveApproveRejectReassign ;


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
		leaveApproveRejectReassign = new LeaveApproveRejectReassignForManagerTlPage(driver);
		log.info("======Starting test======");
	
		leaveApproveRejectReassign.loginToApplicationForEmployee(username,password);
		
		boolean myTeamTabDisplayed = leaveApproveRejectReassign.verifyMyTeamTab();
		log.info("My Team tab is displayed===="+myTeamTabDisplayed);
		Assert.assertEquals(myTeamTabDisplayed, true);
		
		if(myTeamTabDisplayed){
			leaveApproveRejectReassign.clickMyTeamTab();
			
		}
	
	}	
	@Test(dependsOnMethods ={"loginAndClickMyTeamTab"}) 
	public void ClickLeaveTabAndRecord() throws InterruptedException{
		boolean verifyViewEmployeeIcon = leaveApproveRejectReassign.verifyViewIcon();
		log.info("firoz77777"+verifyViewEmployeeIcon);
		Assert.assertEquals(verifyViewEmployeeIcon, true);
		if(verifyViewEmployeeIcon)
			leaveApproveRejectReassign.clickViewEmployeeIcon();
		boolean verifyViewLeaveSubTab =leaveApproveRejectReassign.verifyLeaveSubTab();
		if(verifyViewLeaveSubTab)
		leaveApproveRejectReassign.clickLeaveSubTab();
		boolean verifyLrRecord = leaveApproveRejectReassign.verifyLeaveRequestForApprove();
		Assert.assertEquals(verifyLrRecord, true);
		log.info("--------"+verifyLrRecord);
		if(verifyLrRecord)
			leaveApproveRejectReassign.clickLeaveRequestRecordForApprove();
		
	}
	@Test(dependsOnMethods ={"ClickLeaveTabAndRecord"}) 
	public void verifyApproveRejectAndApprove() throws InterruptedException{
	
		boolean verifyApproveRejectLink = leaveApproveRejectReassign.verifyApproveRejectLink();
		Assert.assertEquals(verifyApproveRejectLink, true);
		log.info("--------"+verifyApproveRejectLink);
		if(verifyApproveRejectLink){
			leaveApproveRejectReassign.clickApproveRejectLink();
		}
		boolean verifyApproveButton = leaveApproveRejectReassign.verifyApproveButton();
		Assert.assertEquals(verifyApproveButton, true);
		if(verifyApproveButton){
			leaveApproveRejectReassign.clickApproveButton();
		}
		leaveApproveRejectReassign.goBack();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods = { "verifyApproveRejectAndApprove" })
	public void verifyLRForDaysWorker() throws Exception{
		String excelLocation = 	System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrManagerResult.xlsx";
		excelReader exr = new excelReader(excelLocation);
		
		String sheetName = "ApproveLeaveResult";
		String columnmnName  ;
		String actualTotalEntitlement = leaveApproveRejectReassign.getTotalEntitlmentForDays();
		String actualLeaveRemaining = leaveApproveRejectReassign.getLeaveRemainingForDays();
		String actualApprovalStatus = leaveApproveRejectReassign.getApprovalStatusForApprovedLeave();
		

		String excpectedTotalEntitlement =exr.getCellData( sheetName,"Expected result",2); 
		String excpectedLeaveRemaining  =exr.getCellData( sheetName,"Expected result",3);
		String excpectedApprovalStatus =exr.getCellData( sheetName,"Expected result",4);
		
		
		excelReader.updateResult(excelLocation,sheetName,"Verify total leave entitlement",actualTotalEntitlement);
		excelReader.updateResult(excelLocation,sheetName,"Verify leave remaining",actualLeaveRemaining);
		excelReader.updateResult(excelLocation,sheetName,"Verify approval status",actualApprovalStatus);
		
		
		if(actualTotalEntitlement.equals(excpectedTotalEntitlement)){
		
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify total leave entitlement","PASS");
		}
		else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify total leave entitlement","FAIL");
		}
		if(actualLeaveRemaining.equals(excpectedLeaveRemaining)){
				excelReader.updateTestStatus(excelLocation,sheetName,"Verify leave remaining","PASS");
		}
		else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify leave remaining","FAIL");
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
