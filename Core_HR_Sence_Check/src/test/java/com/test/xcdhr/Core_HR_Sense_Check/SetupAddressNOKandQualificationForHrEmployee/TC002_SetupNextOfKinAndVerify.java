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

public class TC002_SetupNextOfKinAndVerify extends TestBase{

	public static final Logger log = Logger.getLogger(TC002_SetupNextOfKinAndVerify.class.getName());
		
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
public void verifyNokButtonAndClick() throws InterruptedException {
	Thread.sleep(5000);
	boolean newNokButtonDisplayed = setupAddress.verifyNewNextOfKinButton();
	log.info("New address button is displayed===="+newNokButtonDisplayed);
	Assert.assertEquals(newNokButtonDisplayed, true);
	if(newNokButtonDisplayed){
		Thread.sleep(5000);
		setupAddress.clickNewNOkButton();
	}



}


@DataProvider(name="setupNextOfKinData")
public  String[][] getTestDataPersonalAddress(){
	String[][] addressData = getDataForHREmployee("HrEmployeeInputSheet.xls","SetupNOK"); 
	return addressData ; 
	
}
/*@DataProvider(name="updateNOKResult")
public  String[][] updateNextOfKinResult(){
	String[][] nokResultData = getDataForHREmployeeResult("HrEmployeeResult.xls","NextOfKinResult"); 
	log.info("nextofkindata"+nokResultData);
	return nokResultData ; 
	
}
*/


@Test(dataProvider = "setupNextOfKinData",dependsOnMethods ={"verifyNokButtonAndClick"}) 
public void setupNok(String nextOfKinName,String relationshipWithEmp,String contactOfEmergency) throws InterruptedException{
	Thread.sleep(5000);
	
	boolean verifyNewNokPage = setupAddress.verifyNoKPage();
	Assert.assertEquals(verifyNewNokPage, true);
	log.info("New address page is displayed"+verifyNewNokPage);
	if(verifyNewNokPage){
		setupAddress.setupNOK(nextOfKinName,relationshipWithEmp,contactOfEmergency);
	//	setupAddress.clickNewAddressButton();
      
	}

}
@Test(dependsOnMethods ={"setupNok"})
public void getNokData() throws Exception{
//	String excelLocation = 	"C:\\TestReport\\HrEmployeeResult.xlsx";
	String excelLocation = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\OutputData\\HrEmployeeResult.xlsx";
	log.info("firoz9999"+excelLocation);
	excelReader exr = new excelReader(excelLocation);
	
	log.info("firoz"+exr);
	
	
	
	String sheetName = "NextOfKinResult";
	String coulmnName  ;
	String actualNokName = setupAddress.getNokName();
	log.info("actual nok name == "+actualNokName);
	String actualNokRelationship = setupAddress.getNokRelationhip();
	String actualNokEmergencyContact = setupAddress.getNokEmergencyContact();
	

	excelReader.updateResult(excelLocation,sheetName,"Verify NOK Name",actualNokName);
	log.info("actual nok nameb = " +actualNokName);
	excelReader.updateResult(excelLocation,sheetName,"Verify Relationship",actualNokRelationship);
	excelReader.updateResult(excelLocation,sheetName,"Verify Emergency contact",actualNokEmergencyContact);
	
	
	String excpectedNokName =exr.getCellData( sheetName,"Expected result",2); 
	String excpectedNokRelationship =exr.getCellData( sheetName,"Expected result",3);
	String excpectedNokEmergencyContact =exr.getCellData( sheetName,"Expected result",4);

	if(actualNokName.equals(excpectedNokName)){
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify NOK Name","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify NOK Name","FAIL");
	}
	if(actualNokRelationship.equals(excpectedNokRelationship)){
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify Relationship","PASS");
	}
	else{
		excelReader.updateTestStatus(excelLocation,sheetName,"Verify Relationship","FAIL");
	}
	if(actualNokEmergencyContact.equals(excpectedNokEmergencyContact)){
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify Emergency contact","PASS");
	}
	else{
			excelReader.updateTestStatus(excelLocation,sheetName,"Verify Emergency contact","FAIL");
	}
	
	endTest();
}

}
