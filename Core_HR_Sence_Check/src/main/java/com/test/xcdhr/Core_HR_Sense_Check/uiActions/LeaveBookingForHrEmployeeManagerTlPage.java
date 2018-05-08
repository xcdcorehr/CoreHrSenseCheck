package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class LeaveBookingForHrEmployeeManagerTlPage extends TestBase {
	WebDriver driver;
	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;
	
	@FindBy(linkText = "My Details")
	WebElement myDetailTab;
	
	
	@FindBy(xpath = "//*[@id='j_id0:holidaySumm_lbl']")
	WebElement leaveSubTab;
	
	@FindBy(xpath = "//*[contains(@value,'Book leave')]")
	WebElement bookLeaveButton;
	
	@FindBy(xpath = "//*[contains(text(),'New leave / absence request')]")
	WebElement verifyBookLeavePage;
	
	@FindBy(xpath = "//*[@id='bookLeavePage:frm:pgBlock:j_id49:0:j_id50:j_id51:id_1_Leave_Request']")
	WebElement leaveCategory;
	
	@FindBy(xpath = "//div/div/table/tbody/tr[2]/td[1]/div/span/input")
	WebElement lrStartDate;
	
	@FindBy(xpath = "//*[text()='End date']//following::input[1]")
	WebElement sickLeaveEndDate;
	
	@FindBy(xpath = "//*[@id='calRow2']/td[1]")
	WebElement lrStartDateValue;
	
	@FindBy(xpath = "//*[@id='calRow3']/td[1]")
	WebElement openLrStartDateValue;
	
	@FindBy(xpath = "//*[@id='calRow2']/td[3]")
	WebElement sickStartDateValue;
	
	
	@FindBy(xpath = "//*[@id='calRow2']/td[4]")
	WebElement sickEndDateValue;
	
	
	@FindBy(xpath = "//div/div/table/tbody/tr[2]/td[2]/div/span/input")
	WebElement lrEndDate;
	
	@FindBy(xpath = "//*[@id='calRow2']/td[2]")
	WebElement lrEndDateValue;
	
	@FindBy(xpath = "//div/div/table/tbody/tr[3]/td[1]/select")
	WebElement startDateAmPmAllDay;
	
	@FindBy(xpath = "//div/div/table/tbody/tr[3]/td[2]/select")
	WebElement endDateAmPmAllDay;
	
	@FindBy(xpath = "//*[contains(text(),'Hours booked hh')]//following::input[1]")
	WebElement bookedHH;
	
	@FindBy(xpath = "//div/div[2]/table/tbody/tr[5]/td[1]/div/select")
	WebElement bookedMM;
	
	
	@FindBy(xpath = "//img[@src='/resource/1510592859000/xcdhcm__Remove_Cross_Symbol']")
	WebElement cancelIcon;
	
	@FindBy(xpath = "//*[text() ='5.17 hours']")
	WebElement verifyDurationForHours;
	
	@FindBy(xpath = "//*[text() ='1.5 days']")
	WebElement verifyDurationForDays;
	
	@FindBy(xpath = "//*[text() ='Annual leave']")
	WebElement verifyLeaveCategoryForHours;
	
	@FindBy(xpath = "//*[text() ='Awaiting Approval']")
	WebElement verifyApprovalStatusForHours;
	
	@FindBy(xpath = "//*[contains(@value,'Submit leave request')]")
	WebElement submitLR;
	
	
	@FindBy(xpath = "//*[@id='bookLeavePage:frm:okButton1']")
	WebElement clickOK;
	
	
	
	
	public LeaveBookingForHrEmployeeManagerTlPage(WebDriver driver) {
		this.driver = driver ;
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
	public boolean verifyMyDetailTab() {
		try {

			myDetailTab.isDisplayed();
			log.info("My Detail  tab is displayed and object is"
					+ myDetailTab.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickMyDetailTab(){
		myDetailTab.click();
		log.info("My Detail tab is clicked");
	}
	
	public boolean verifyLeaveSubTab() {
		try {

			leaveSubTab.isDisplayed();
			log.info("leave  tab is displayed and object is"
					+ leaveSubTab.toString());
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickLeaveSubTab(){
		leaveSubTab.click();
		log.info("leave Tab ic clicked");
	}
	
	
	public boolean verifyCancelIcon(){
	try{
		cancelIcon.isDisplayed();
		log.info("cancol  icon is displayed and object is"
				+ cancelIcon.toString());
	
		return true ;
	}
		catch(Exception e ){
		}
		return false ;
	}
    public void clickCancelIcon() throws InterruptedException{
    	Actions act = new Actions(driver);
    	act.moveToElement(cancelIcon).click().build().perform();
    	Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
        Thread.sleep(5000);
    }
	
	
      public boolean verifyBookLeavebutton() {
		try {

			bookLeaveButton.isDisplayed();
			log.info("Book leave button is  displayed and object is"
					+ bookLeaveButton.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickBookLeavebutton (){
		bookLeaveButton.click();
		log.info("Book Leave button is clicked ");
		
	}
	
	public boolean verifyBookLeavePage(){
		try {
			;
			verifyBookLeavePage.isDisplayed();
			log.info("Control is on book leave page"
					+ verifyBookLeavePage.toString());

			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public void setupAnnualLeaveRequestAndSubmit(String lCategory,String startDate ,String endDate ,String startDateAmPm ,String endDateAmPm) throws InterruptedException{
		Select selectLeaveCategory = new Select(leaveCategory);
		Thread.sleep(2000);
		selectLeaveCategory.selectByValue(lCategory);
		Thread.sleep(4000);
		
		lrStartDate.sendKeys(startDate);
		Thread.sleep(4000);
		lrEndDate.sendKeys(endDate);
		Select selectStartDateAmPm = new Select(startDateAmPmAllDay);
		log.info("+++++++" + selectStartDateAmPm);
		selectStartDateAmPm.selectByValue(startDateAmPm);
   	//	lrStartDateValue.click();
   		Thread.sleep(5000);
	
	//	lrEndDateValue.click();
		Thread.sleep(5000);
		
		Select selectEndDateAmPm = new Select(endDateAmPmAllDay);
		log.info("+++++++" + selectEndDateAmPm);
		selectEndDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		submitLR.click();	
		Thread.sleep(8000);
		clickOK.click();
		Thread.sleep(10000);
	}
	public void setupSicklLeaveRequestAndSubmit(String lCategory,String startDate,String endDate ,String startDateAmPm ,String endDateAmPm) throws InterruptedException{
		Thread.sleep(2000);
		Select selectLeaveCategory = new Select(leaveCategory);
		Thread.sleep(2000);
		selectLeaveCategory.selectByValue(lCategory);
		Thread.sleep(4000);
		lrStartDate.clear();
		Thread.sleep(3000);
		lrStartDate.sendKeys(startDate);
		Thread.sleep(8000);
		sickLeaveEndDate.clear();
		Thread.sleep(5000);
		sickLeaveEndDate.sendKeys(endDate);
		Thread.sleep(10000);
		Select selectStartDateAmPm = new Select(startDateAmPmAllDay);
		log.info("+++++++" + selectStartDateAmPm);
		selectStartDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		Select selectEndDateAmPm = new Select(endDateAmPmAllDay);
		log.info("+++++++" + selectEndDateAmPm);
		selectEndDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		submitLR.click();	
		Thread.sleep(8000);
		clickOK.click();
		Thread.sleep(5000);
	}
	public void setupOpenSicklLeaveRequestAndSubmit(String lCategory,String startDate,String endDate ,String startDateAmPm ,String endDateAmPm) throws InterruptedException{
		Thread.sleep(7000);
		Select selectLeaveCategory = new Select(leaveCategory);
		Thread.sleep(7000);
		selectLeaveCategory.selectByValue(lCategory);
		Thread.sleep(4000);
		lrStartDate.clear();
		Thread.sleep(2000);
		lrStartDate.sendKeys(startDate);
   		Thread.sleep(5000);
		Select selectStartDateAmPm = new Select(startDateAmPmAllDay);
		log.info("+++++++" + selectStartDateAmPm);
		selectStartDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		Select selectEndDateAmPm = new Select(endDateAmPmAllDay);
		log.info("+++++++" + selectEndDateAmPm);
		selectEndDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		submitLR.click();	
		Thread.sleep(8000);
		clickOK.click();
		Thread.sleep(8000);
	}
	
	public void setupAnnualLeaveRequestForHoursAndSubmit(String lCategory,String endDate,String startDate ,String startDateAmPm ,String endDateAmPm,String hoursBookedhh,String mm) throws InterruptedException{
		lrStartDate.click();
		Thread.sleep(2000);
   		lrStartDateValue.click();
   		Thread.sleep(5000);
		lrEndDate.click();
		lrEndDateValue.click();
		Thread.sleep(5000);
		Select selectStartDateAmPm = new Select(startDateAmPmAllDay);
		log.info("+++++++" + selectStartDateAmPm);
		selectStartDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		Select selectEndDateAmPm = new Select(endDateAmPmAllDay);
		log.info("+++++++" + selectEndDateAmPm);
		selectEndDateAmPm.selectByValue(startDateAmPm);
		Thread.sleep(5000);
		bookedHH.sendKeys(hoursBookedhh);
		Thread.sleep(5000);
		Select minute = new Select(bookedMM);
		log.info("--------" + minute);
		minute.selectByVisibleText("10");
		Thread.sleep(5000);
		submitLR.click();	
		Thread.sleep(8000);
		clickOK.click();
		Thread.sleep(8000);
	
	}
	
	 public String getDurationForHours(){
		 String durationForHours;
		 durationForHours = verifyDurationForHours.getText();
		 log.info("value of durarion is  "+durationForHours);
		 return durationForHours;
	}
	
	 public String getDurationForDays(){
		 String durationForDays;
		 durationForDays = verifyDurationForDays.getText();
		 log.info("value of durarion is  "+durationForDays);
		 return durationForDays;
	}
	
	 
	 public String getLeaveCategoryForHours(){
		 String leaveCategoryForHours;
		 leaveCategoryForHours = verifyLeaveCategoryForHours.getText();
		 log.info("value of leave category is "+leaveCategoryForHours);
		 return leaveCategoryForHours;
	}
	 public String getApprovalStatusForHours(){
		 String approvalStatusForHours;
		 approvalStatusForHours = verifyApprovalStatusForHours.getText();
		 log.info("value of approval status is "+approvalStatusForHours);
		 return approvalStatusForHours;
	} 
	 
	 

}
	
	
	
	

