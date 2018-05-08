package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class LoginPage extends TestBase  {
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	WebDriver driver ;
	
	By enterUsername1 = By.id("username]");
	By enterpassword1 = By.id("password]");
	By clickLogin1 = By.id("Login]");
	
	@FindBy(id="username")
	public
	WebElement enterUserName ;
	
	@FindBy(id="password")
	WebElement enterPassword ;
	
	@FindBy(id="Login")
	WebElement clickLogin ;
	@FindBy(xpath="//*[@id='01rb00000001Wv4_Tab']/a") 
	WebElement companiesTab ;
	public LoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);
	
		
	}

public void loginToApplication(String username ,String password){
	//waitForElement(300, enterUserName);
	enterUserName.sendKeys(username);
	log.info("Enter user name = "+username+" and object is"+enterUserName.toString());
	enterPassword.sendKeys(password);
	log.info("Enter Passord = "+password+" and object is"+enterPassword.toString());
	clickLogin.click();
	log.info("Click on Login button and objet is"+clickLogin.toString() );
	
}	
	
public boolean verifyCompaniesTab (){
	try {
		//waitForElement(100 ,companiesTab);
		companiesTab.isDisplayed();
		log.info("companies tab is displayed and object is"+companiesTab.toString());
		 
		return true ;
	} catch (Exception e) {
		return false ;
	}
	
	
	
}

public void clickOnCompaniesTab(){
	companiesTab.click();
	log.info("clicked on companies tab and object is "+companiesTab.toString()); 
	
}








}
