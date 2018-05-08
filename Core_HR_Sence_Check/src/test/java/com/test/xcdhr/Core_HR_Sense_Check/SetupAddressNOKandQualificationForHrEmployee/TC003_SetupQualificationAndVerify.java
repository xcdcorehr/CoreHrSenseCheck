package com.test.xcdhr.Core_HR_Sense_Check.SetupAddressNOKandQualificationForHrEmployee;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.SetupAddressNextOfKinAndQualificationForHREmployee;

public class TC003_SetupQualificationAndVerify extends TestBase {
	public static final Logger log = Logger.getLogger(TC003_SetupQualificationAndVerify.class.getName());
	
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
	//		setupAddress.clickPersonalTab();
		}
	
	}	




@Test(dependsOnMethods = { "loginAndClickMyDetail" })
public void verifyQualificationButtonAndClick() throws InterruptedException {
	Thread.sleep(3000);
	boolean newQualificationDisplayed = setupAddress.verifyNewQualificationButton();
	log.info("New qualification button is displayed===="+newQualificationDisplayed);
	Assert.assertEquals(newQualificationDisplayed, true);
	if(newQualificationDisplayed){
		Thread.sleep(3000);
		setupAddress.clickQualificationButton();
	}



}


@DataProvider(name="setupQualificationData")
public  String[][] getTestDataQualification(){
	String[][] addressData = getDataForHREmployee("HrEmployeeInputSheet.xls","SetupQualification"); 
	return addressData ; 
	
}
@Test(dataProvider = "setupQualificationData",dependsOnMethods ={"verifyQualificationButtonAndClick"}) 
public void setupQualification(String title,String type,String provider,String date,String location,String duration,String period,String result,String status) throws InterruptedException{
	Thread.sleep(5000);
	
	boolean verifyQualificationPage = setupAddress.verifyQualificationPage();
	Assert.assertEquals(verifyQualificationPage, true);
	log.info("New qualification page is displayed"+verifyQualificationPage);
	if(verifyQualificationPage){
		setupAddress.setupQualification(title,type,provider,date,location,duration,period,result,status);
	//	setupAddress.clickNewAddressButton();
      
	}

}
@Test(dependsOnMethods = { "setupQualification" })
public void getQualificationData() throws Exception{
//	String excelLocation = 	"C:\\TestReport\\HrEmployeeResult.xlsx";
	String excelLocation = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrEmployeeResult.xlsx";
	excelReader exr = new excelReader(excelLocation);
	
	
	String sheetName = "QualificationResult";
	String coulmnName  ;
	String actualCourseTitle = setupAddress.getCourseTitle();
	log.info("actual course title == "+actualCourseTitle);
	String actualCourseDate = setupAddress.getCourseDate();
	log.info("actual course date == "+actualCourseDate);
	String actualCourseProvider = setupAddress.getCourseProvider();
	log.info("actual course date == "+actualCourseProvider);
	String actualCourseResult = setupAddress.getCourseResult();
	log.info("actual course result == "+actualCourseResult);
	String actualCourseStatus = setupAddress.getCourseStatus();
	log.info("actual course status == "+actualCourseStatus);
	excelReader.updateResult(excelLocation,sheetName,"Verify course title",actualCourseTitle);
	log.info("actual qualification = " +actualCourseTitle);
	excelReader.updateResult(excelLocation,sheetName,"Verify course date",actualCourseDate);
	excelReader.updateResult(excelLocation,sheetName,"Verify course provider",actualCourseProvider);
	excelReader.updateResult(excelLocation,sheetName,"Verify course result",actualCourseResult);
	excelReader.updateResult(excelLocation,sheetName,"Verify course status",actualCourseStatus);
	
	String excpectedCourseTitle =exr.getCellData( sheetName,"Expected result",2); 
	log.info("expected course title = "+excpectedCourseTitle);
	String excpectedCourseDate =exr.getCellData( sheetName,"Expected result",3);
	log.info("expected course date = "+excpectedCourseDate);
	String excpectedCourseProvider =exr.getCellData( sheetName,"Expected result",4);
	String excpectedCourseResult =exr.getCellData( sheetName,"Expected result",5);
	String excpectedCourseStatus =exr.getCellData( sheetName,"Expected result",6);
	
	if(actualCourseTitle.equals(excpectedCourseTitle)){
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course title","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course title","FAIL");
	}
	if(actualCourseDate.equals(excpectedCourseDate)){
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify course date","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course date","FAIL");
	}
	if(actualCourseProvider.equals(excpectedCourseProvider)){
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify course provider","PASS");
	}
	else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify course provider","FAIL");
	}
	
	if(actualCourseResult.equals(excpectedCourseResult)){
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course result","PASS");
    }
    else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course result","FAIL");
    }
	if(actualCourseStatus.equals(excpectedCourseStatus)){
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify course status","PASS");
    }
    else{
	excelReader.updateTestStatus(excelLocation,sheetName,"Verify course status","FAIL");
    }

	
	endTest();
}


	
	
	
}
