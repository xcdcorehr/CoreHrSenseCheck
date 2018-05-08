package com.test.xcdhr.Core_HR_Sense_Check.ManagerTLapproveRejectReassignLR;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveApproveRejectReassignForManagerTlPage;

public class TC002_RejectLrAndVerify extends TestBase{
	LeaveApproveRejectReassignForManagerTlPage leaveApproveRejectReassign ;


	@DataProvider(name="HrManagerInputData")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getDataForHRManagerTL("HrManagerInputSheet.xls","LoginDataForManager"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	@Test (dataProvider = "HrManagerInputData")
	
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
		boolean verifyLrRecord = leaveApproveRejectReassign.verifyLeaveRequestForReject();
		Assert.assertEquals(verifyLrRecord, true);
		log.info("--------"+verifyLrRecord);
		if(verifyLrRecord){
			leaveApproveRejectReassign.clickLeaveRequestRecordForReject();
		}
	}
	@Test(dependsOnMethods ={"ClickLeaveTabAndRecord"}) 
	public void verifyApproveRejectAndReject() throws InterruptedException{
	
		boolean verifyApproveRejectLink = leaveApproveRejectReassign.verifyApproveRejectLink();
		Assert.assertEquals(verifyApproveRejectLink, true);
		log.info("--------"+verifyApproveRejectLink);
		if(verifyApproveRejectLink){
			leaveApproveRejectReassign.clickApproveRejectLink();
		}
		boolean verifyRejectButton = leaveApproveRejectReassign.verifyRejectButton();
		Assert.assertEquals(verifyRejectButton, true);
		if(verifyRejectButton){
			leaveApproveRejectReassign.clickRejectButton();
		}
		leaveApproveRejectReassign.goBack();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods = { "verifyApproveRejectAndReject" })
	public void verifyLRForDaysWorker() throws Exception{
		String excelLocation = 	System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrManagerResult.xlsx";
		excelReader exr = new excelReader(excelLocation);
		
		String sheetName = "RejectLeaveResult";
		String columnmnName  ;
		String actualTotalEntitlement = leaveApproveRejectReassign.getTotalEntitlmentForDays();
		String actualLeaveRemaining = leaveApproveRejectReassign.getLeaveRemainingForDays();
		String actualApprovalStatus = leaveApproveRejectReassign.getApprovalStatusForRejectedLeave();
		

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
