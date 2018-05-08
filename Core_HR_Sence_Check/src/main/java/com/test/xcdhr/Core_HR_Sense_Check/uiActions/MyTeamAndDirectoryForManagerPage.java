package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class MyTeamAndDirectoryForManagerPage extends TestBase {


	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;

	@FindBy(linkText = "My Team")
	WebElement myTeamTab;
	
	@FindBy(linkText = "Directory")
	WebElement directoryTab;
	
	@FindBy(linkText = "D")
	WebElement alphabetD;
	
	@FindBy(xpath = "//img[@src='/resource/1523017552000/xcdhcm__Css/lgar.png']")
	WebElement viewlEmployeeIcon;
	
	@FindBy(xpath = "//*[text() ='firoza@xcdhr.com']")
	WebElement verifyEmail;
	
	@FindBy(xpath = "//*[@id='j_id0:frm1:search1']")
	WebElement searchDirectory;
	
	@FindBy(xpath = "//*[text()='DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ']")
	WebElement verifyEmployee;
	
	public MyTeamAndDirectoryForManagerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void loginToApplicationForEmployee(String username, String password) {

		enterUserName.sendKeys(username);
		log.info("Entere user name = " + username + " and object is"
				+ enterUserName.toString());
		enterPassword.sendKeys(password);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}
	public boolean verifyMyTeamTab() {
		try {

			myTeamTab.isDisplayed();
			log.info("My Detail  tab is displayed and object is"
					+ myTeamTab.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickMyTeamTab() {
		myTeamTab.click();
		log.info("My Team tab is clicked");
	}

	public boolean verifyDirectoryTab() {
		try {

			directoryTab.isDisplayed();
			log.info("Directory  tab is displayed and object is"
					+ myTeamTab.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickDirectoryTab() {
		directoryTab.click();
		log.info("Directory tab is clicked");
	}
	
	
	public boolean verifyViewIcon() {
		try {
			viewlEmployeeIcon.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickViewEmployeeIcon() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(viewlEmployeeIcon).click().build().perform();

		Thread.sleep(5000);
	}
	public String getEmployeeEmail(){
		String actualEmail = verifyEmail.getText();
		log.info("the actual email is"+actualEmail);
		return actualEmail ;
		
	}
	public boolean verifySearchInput(){
		try{
			searchDirectory.isDisplayed();
			return true ;
		}
		catch (Exception e){
			
		}
		return false;
	}
	public void clickAlphabetD(){
		alphabetD.click();
	}
	
	public void enterEmployeeForSearch() throws InterruptedException{
		searchDirectory.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ");
		Thread.sleep(3000);

	}
	 public String getSearchedEmployee(){
		 String employeeNameOnDirectory;
		 employeeNameOnDirectory = verifyEmployee.getText();
		 log.info("value of statuss "+employeeNameOnDirectory);
		 return employeeNameOnDirectory;
	} 

}
