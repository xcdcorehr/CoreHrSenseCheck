package com.test.xcdhr.Core_HR_Sense_Check.SetupAddressNOKandQualificationForHrEmployee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.collect.Table.Cell;
import com.test.xcdhr.Core_HR_Sense_Check.HrEmployeeLeaveBooking.TC001_BookAnnualLeaveForDaysWorkerAndVerify;
import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.LeaveBookingForHrEmployeeManagerTlPage;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.SetupAddressNextOfKinAndQualificationForHREmployee;

public class TC001_SetupPersonalAddressAndVerify extends TestBase {
	
	  
	
	
	public static final Logger log = Logger.getLogger(TC001_SetupPersonalAddressAndVerify.class.getName());
		
	SetupAddressNextOfKinAndQualificationForHREmployee setupAddress ;
	
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
		setupAddress = new SetupAddressNextOfKinAndQualificationForHREmployee(driver);
		log.info("======Starting test======");
	
		setupAddress.loginToApplicationForEmployee(username,password);
		
		boolean myDetailTabDisplayed = setupAddress.verifyMyDetailTab();
		log.info("My detail tab is displayed===="+myDetailTabDisplayed);
		Assert.assertEquals(myDetailTabDisplayed, true);
		
		if(myDetailTabDisplayed){
			setupAddress.clickMyDetailTab();
			setupAddress.clickPersonalTab();
		}
	
	}	




@Test(dependsOnMethods = { "loginAndClickMyDetail" })
public void verifyAddressButtonAndClick() throws InterruptedException {
	Thread.sleep(5000);
	boolean newAddressButtonDisplayed = setupAddress.verifyNewAddressButton();
	log.info("New address button is displayed===="+newAddressButtonDisplayed);
	Assert.assertEquals(newAddressButtonDisplayed, true);
	if(newAddressButtonDisplayed){
		Thread.sleep(5000);
		setupAddress.clickNewAddressButton();
	}



}


@DataProvider(name="setupPersonalAddressData")
public  String[][] getTestDataPersonalAddress(){
	String[][] addressData = getDataForHREmployee("HrEmployeeInputSheet.xls","SetupAddress"); 
	return addressData ;
	
}
@Test(dataProvider = "setupPersonalAddressData",dependsOnMethods ={"verifyAddressButtonAndClick"}) 
public void setupPersonalAddress(String fromdate,String address1,String address2,String city ,String postCode,String country,String addressType) throws InterruptedException{
	Thread.sleep(5000);
	
	boolean verifyNewAddressPage = setupAddress.verifyAddressPage();
	Assert.assertEquals(verifyNewAddressPage, true);
	log.info("New address page is displayed"+verifyNewAddressPage);
	if(verifyNewAddressPage){
		setupAddress.setupPersonalAddress(fromdate,address1,address2,city,postCode,country,addressType);
	//	setupAddress.clickNewAddressButton();
      
	}

}
@Test(dependsOnMethods = { "setupPersonalAddress" })
public void getPersonalData() throws Exception{
//	String excelLocation = 	"C:\\TestReport\\HrEmployeeResult.xlsx";
	String excelLocation = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrEmployeeResult.xlsx";
	
	excelReader exr = new excelReader(excelLocation);
	
	
	String sheetName = "PersonalAddressResult";
	String coulmnName  ;
	String actualAddressType = setupAddress.getAddressType();
	String actualAddress1 = setupAddress.getAddress1();
	String actualAddressCity = setupAddress.getCity();
	String actualAddressPostcode = setupAddress.getPostCode();

	String excpectedAddressType =exr.getCellData( sheetName,"Expected result",2); 
	String excpectedAddress1 =exr.getCellData( sheetName,"Expected result",3);
	String excpectedAddressCity =exr.getCellData( sheetName,"Expected result",4);
	String excpectedAddressPostcode =exr.getCellData( sheetName,"Expected result",5);
	
	excelReader.updateResult(excelLocation,sheetName,"Verify Address type",actualAddressType);
	excelReader.updateResult(excelLocation,sheetName,"Verify Address 1",actualAddress1);
	excelReader.updateResult(excelLocation,sheetName,"Verify City",actualAddressCity);
	excelReader.updateResult(excelLocation,sheetName,"Verify Postcode",actualAddressPostcode);
	log.info("actual address type" + actualAddressType + "and"+ "excpectedAddressType" + excpectedAddressType);
	
	if(actualAddressType.equals(excpectedAddressType)){
	log.info("actual address type" + actualAddressType + "and"+ "excpectedAddressType" + excpectedAddressType);
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify Address type","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify Address type","FAIL");
	}
	if(actualAddress1.equals(excpectedAddress1)){
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify Address 1","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify Address 1","FAIL");
	}
	if(actualAddressCity.equals(excpectedAddressCity)){
		log.info("actual address type" + actualAddressType + "and"+ "excpectedAddressType" + excpectedAddressType);
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify City","PASS");
	}
	else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify City","FAIL");
	}
	if(actualAddressPostcode.equals(excpectedAddressPostcode)){
				excelReader.updateTestStatus(excelLocation,sheetName,"Verify Postcode","PASS");
	}
	else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify Postcode","FAIL");
	}
	endTest();
}

}












