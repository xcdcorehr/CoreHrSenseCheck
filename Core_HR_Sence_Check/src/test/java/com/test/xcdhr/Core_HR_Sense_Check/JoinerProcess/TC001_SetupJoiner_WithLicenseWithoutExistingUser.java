package com.test.xcdhr.Core_HR_Sense_Check.JoinerProcess;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;
import com.test.xcdhr.Core_HR_Sense_Check.uiActions.JoinerPage;

public class TC001_SetupJoiner_WithLicenseWithoutExistingUser extends TestBase {
	public static final Logger log = Logger.getLogger(TC001_SetupJoiner_WithLicenseWithoutExistingUser.class.getName());
	
	
	JoinerPage joiner ;
	
	@DataProvider(name="UserCredentials")
	public  String[][] getTestDataforLogin(){
		String[][] testUsers = getData("TestData.xls","LoginData"); 
		return testUsers ;
		
	}

	@BeforeTest
	public void setup() throws IOException {
		init();
		
	}
	
	@Test (dataProvider = "UserCredentials")
	public void companyTabclick ( String username ,String password, String runMode) {
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("this user is inactive");
			
		}
		joiner = new JoinerPage(driver);
		log.info("======Starting test======");
	
		joiner.loginToApplication(username,password);
		
		boolean comanyTabDisplayed = joiner.verifyCompaniesTab();
		log.info("company tab is displayed===="+comanyTabDisplayed);
		Assert.assertEquals(comanyTabDisplayed, true);
		
		if(comanyTabDisplayed){
			joiner.clickOnCompaniesTab();
			
		}
		
		
	}
    @Test (dependsOnMethods = { "companyTabclick" })
    public void clickGO(){
    	joiner = new JoinerPage(driver);
    boolean goButtonDisplayed = joiner.verifyGObutton();
    Assert.assertEquals(goButtonDisplayed, true);
    	if(goButtonDisplayed){
    		joiner.clickGO();
    }
    }
 
@Test (dependsOnMethods ={"clickGO"})		
public void clickDNTcoreHRComp(){
	joiner = new JoinerPage(driver);
	boolean DNTcompDisplayed = joiner.verifyDNTcoreHRCompDisplayed();
	Assert.assertEquals(DNTcompDisplayed, true);
	if(DNTcompDisplayed){
		joiner.clickDNTcoreHRComp();
}
	
}
@Test(dependsOnMethods ={"clickDNTcoreHRComp"})	
public void clicnNewJoinerButton(){
	joiner = new JoinerPage(driver);
	boolean newjoinerbuttonDisplayed = joiner.verifyJoinerbutton();
	Assert.assertEquals(newjoinerbuttonDisplayed, true);
	if(newjoinerbuttonDisplayed){
		joiner.clickNewJoinerButton();
	
	}
}	 
	
@DataProvider(name="JoinerData")
public  String[][] getTestDataforJoiner(){
	String[][] testUsers = getData("TestData.xls","joinerFirstAndSecondPage"); 
	return testUsers ;
	
}
@Test(dataProvider = "JoinerData",dependsOnMethods ={"clicnNewJoinerButton"}) 
public void setupPersonalSection(String firstname,String lastname,String email,String username,String activateLicense,String jobtitle,String employmentStatus,String manager,String startDate,String contineousServiceDate,String addr1,String postcode,String city,String addrCountry,String addrType,String nextOfKin,String emregencyContact,String regularPay,String regularPeriod) throws Throwable{
	//	joiner = new JoinerPage(driver);
		boolean setupNewJoinerDisplayed = joiner.verifyJoinerFirstPage();
		log.info("setup joiner text is displayed ===="+setupNewJoinerDisplayed);
		Assert.assertEquals(setupNewJoinerDisplayed, true);
		
		if(setupNewJoinerDisplayed){
		
			joiner.setupPersonalSectionOfJoinerFirstPage(firstname,lastname,email,username,activateLicense,jobtitle,employmentStatus,manager,startDate,contineousServiceDate,addr1,postcode,city,addrCountry,addrType,nextOfKin,emregencyContact,regularPay,regularPeriod);
		}
		
		endTest();
		
	}
 
	
	

	
	
	
	


}
