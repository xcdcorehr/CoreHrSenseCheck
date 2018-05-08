package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class LeaveApproveRejectReassignForManagerTlPage extends TestBase {

	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;

	@FindBy(linkText = "My Team")
	WebElement myTeamTab;

	@FindBy(xpath = "//img[@src='/resource/1523017552000/xcdhcm__Css/lgar.png']")
	WebElement viewlEmployeeIcon;

	@FindBy(xpath = "//*[@id='j_id0:holidaySumm_lbl']")
	WebElement leaveSubTab;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/a")
	WebElement lrRecordForAprrove;

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/a")
	WebElement lrRecordForReject;

	@FindBy(xpath = "//table/tbody/tr[3]/td[2]/a")
	WebElement lrRecordForReassign;

	@FindBy(xpath = "//*[contains(text(),'Approve / Reject')]")
	WebElement approveRejectLink;

	@FindBy(xpath = "//*[contains(text(),'Reassign')]")
	WebElement reassignLink;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement approveButton;

	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[2]")
	WebElement rejectButton;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[3]")
	WebElement backButton;

	@FindBy(xpath = "//*[text()='(=) Total entitlement']//following::td[1]")
	WebElement verifyAnnualEntitlement;

	@FindBy(xpath = "//*[text()='(=) Leave remaining']//following::td[1]")
	WebElement verifyLeaveRemaining;

	@FindBy(xpath = "//*[text()='Approval status']//following::td[8]")
	WebElement verifyApprovalStatusForApprovedLR;

	@FindBy(xpath = "//*[text()='Rejected']")
	WebElement verifyApprovalStatusForRejectedLR;

	@FindBy(id = "Actor")
	WebElement reassignLookupField;
	
	@FindBy(xpath = "//*[@id='Actor_lkwgt']/img")
	WebElement reassignLookupIcon;
	
	
	@FindBy(xpath = "//*[@id='theForm']/div/div[2]/input[2]")
	WebElement goButtonOnLookup;


	@FindBy(xpath = "//*[@id='Actor']")
	WebElement lookupSearchField;

	
	@FindBy(linkText = "Amjad Khan")
	WebElement selectReassignManager;
	
	
	@FindBy(xpath = "//*[@id='User']/div[2]/div/div[1]/table/tbody/tr/td[3]/span/a")
	WebElement myColumnLink;
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	WebElement reassignApprovalRequestButton;
	
	public LeaveApproveRejectReassignForManagerTlPage(WebDriver driver) {
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

	public void clickLeaveSubTab() {
		leaveSubTab.click();
		log.info("leave Tab ic clicked");
	}

	/* For approving the leave request start */
	public boolean verifyLeaveRequestForApprove() {
		try {

			lrRecordForAprrove.isDisplayed();
			log.info("leave record is displayed and object is"
					+ lrRecordForAprrove.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLeaveRequestRecordForApprove() {
		lrRecordForAprrove.click();
		log.info("leave Tab ic clicked");
	}

	public boolean verifyReassignLink() {
		try {

			reassignLink.isDisplayed();
			log.info("reassign Link link is displayed and object is"
					+ reassignLink.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickReassignLink() {
		reassignLink.click();
		log.info("approve reassign link is clicked");
	}

	public boolean verifyApproveRejectLink() {
		try {

			approveRejectLink.isDisplayed();
			log.info("approve reject link is displayed and object is"
					+ approveRejectLink.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickApproveRejectLink() {
		approveRejectLink.click();
		log.info("approve reject link is clicked");
	}

	public boolean verifyApproveButton() {
		try {
			approveButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickApproveButton() {
		approveButton.click();

	}

	/* For approving the leave request end */

	/* For rejecting the leave request start */

	public boolean verifyLeaveRequestForReject() {
		try {

			lrRecordForReject.isDisplayed();
			log.info("leave record is displayed and object is"
					+ lrRecordForReject.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLeaveRequestRecordForReject() {
		lrRecordForReject.click();
		log.info("leave Tab ic clicked");
	}

	public boolean verifyRejectButton() {
		try {
			rejectButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickRejectButton() {
		rejectButton.click();
	}

	/* For rejecting the leave request end */
	
	
	/* For reassign the leave request start */

	public boolean verifyLeaveRequestForReassign() {
		try {

			lrRecordForReassign.isDisplayed();
			log.info("leave record is displayed and object is"
					+ lrRecordForReassign.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLeaveRequestRecordForReassign() {
		lrRecordForReassign.click();
		log.info("leave record ic clicked");
	}
	

	public boolean isNewWindowPresent(){
		
		String homePage = driver.getWindowHandle();
		log.info("33333333"+homePage);
		
		Set<String> windows = driver.getWindowHandles();
		log.info("Size off the window"+windows.size());
		
		
		Iterator iterator = windows.iterator();
		String currentWindoID ;
		while(iterator.hasNext()){
			currentWindoID = iterator.next().toString();
			log.info("popupWindoID ====="+currentWindoID);
		if(!currentWindoID.equals(homePage)){
				driver.switchTo().window(currentWindoID);
				return true ;
		}
		
		}
		return false;
	}

	
	
	
	
	
	public void reassignToOtherManager() throws InterruptedException{
	//	reassignLookupField.clear();
		try {
			Thread.sleep(2000);

			//	reassignLookupField.sendKeys("Amjad khan");
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.moveToElement(reassignLookupIcon).click().build().perform();
			lookupSearchField.clear();
			Thread.sleep(2000);
			lookupSearchField.sendKeys("Amjad khan");
			// Perform the click operation that opens new window
			Thread.sleep(10000);
			String winHandleBefore = driver.getWindowHandle();
			// Switch to new window opened
			log.info("");
			for(String winHandle : driver.getWindowHandles()){
				log.info("new window"+winHandle);
				driver.switchTo().window(winHandle);
			}
			 
		//	myColumnLink.click();
			//goButtonOnLookup.click();
			Thread.sleep(10000);
			
			Thread.sleep(10000);
			selectReassignManager.click();
			// Perform the actions on new window

			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	public boolean verifyReassignApprovalButton(){
		try{
			reassignApprovalRequestButton.isDisplayed();
			log.info("Reassign approve leave button is displayee"
					+ reassignApprovalRequestButton.toString());
			return true ;
		}
		catch(Exception e){
			return false ;
		}
	}
	
	public void clickReassignApprovalButton(){
		reassignApprovalRequestButton.click();
	}
	
	*/
	
	
	
	
	public void goBack() {
		backButton.click();
	}

	public String getTotalEntitlmentForDays() {
		String totalEntitlementFordays;
		totalEntitlementFordays = verifyAnnualEntitlement.getText();
		log.info("value of total leave is  " + totalEntitlementFordays);
		return totalEntitlementFordays;
	}

	public String getLeaveRemainingForDays() {
		String leaveRemainingFordays;
		leaveRemainingFordays = verifyLeaveRemaining.getText();
		log.info("value of leave remaining is  " + leaveRemainingFordays);
		return leaveRemainingFordays;
	}

	public String getApprovalStatusForApprovedLeave() {
		String approvalStatusValue;
		approvalStatusValue = verifyApprovalStatusForApprovedLR.getText();
		log.info("value of status is  " + approvalStatusValue);
		return approvalStatusValue;
	}

	public String getApprovalStatusForRejectedLeave() {
		String approvalStatusValue;
		approvalStatusValue = verifyApprovalStatusForRejectedLR.getText();
		log.info("value of status  " + approvalStatusValue);
		return approvalStatusValue;
	}

}
