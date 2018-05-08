package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class ChangeJobRolePage extends TestBase {

	// JoinerFirstPage joiner;

	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;

	@FindBy(xpath = "//*[@id='topButtonRowj_id0_j_id1_j_id2']/input[4]")
	WebElement changeJobRoleButton;

	@FindBy(id = "phSearchInput")
	WebElement searchBox;

	@FindBy(id = "phSearchButton")
	WebElement searchButton;

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ")
	WebElement joinerEmployee1;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement joinerEmployee2;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ")
	WebElement joinerEmployee3;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ")
	WebElement joinerEmployee4;
	
	
	
	//*[@id='Employee_Detail__c_body']/table/tbody/tr[2]/th/a
	//*[@id='j_id0:JobRoleBlock:j_id515:0:j_id516']/a
	@FindBy(linkText = "Tester")
	WebElement clickFirstJobRole;
	
	@FindBy(linkText = "Senior Tester")
	WebElement clickSecondJobRole;
	
	@FindBy(xpath = "//*[text()='New job role']")
	WebElement NewJobRoleText;

	@FindBy(xpath = "//*[text()='Job title']//following::input[1]")
	WebElement changeJobTitle;

	@FindBy(xpath = "//*[text()='Effective from']//following::input[1]")
	WebElement JobRoleStartDate;

	@FindBy(xpath = "//*[text()='Employment type']//following::select[1]")
	WebElement employmentType;
	
	@FindBy(xpath = "//*[text()='Pattern type']//following::select[1]")
	WebElement employeePatternType;
	                 //*[@id='j_id0:theFrm:j_id3:empWorkingHoursId:j_id57:4:j_id58_unselected']/option[1]
	@FindBy(xpath = "//*[@id='j_id0:theFrm:j_id3:empWorkingHoursId:j_id57:4:j_id58_unselected']/option[1]")
	WebElement selectIrregularFromWorkingDays;
	                 
	@FindBy(xpath = "//*[@id='j_id0:theFrm:j_id3:empWorkingHoursId:j_id57:4:j_id58_right_arrow']")
	WebElement addArrowFromWorkingDays;
	
               
	@FindBy(xpath = "//*[@id='j_id0:theFrm:j_id3:j_id114:btns1B']")
	WebElement clickSave;

	@FindBy(xpath = "//*[@id='j_id0:theform:j_id121']")
	WebElement clickOK;

	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickFinalSave;

	@FindBy(xpath = "//*[@id='j_id0:j_id133:j_id136']")
	WebElement clickFinalOK;
	
	/*@FindBy(xpath = "//*[@id='j_id0:JobRoleBlock:j_id515:0:j_id516']/a")
	WebElement clickSecondJobRole;*/

	@FindBy(xpath = "//*[@id='Namej_id0_j_id1_j_id2_ileinner']")
	WebElement secondJobTitleMatch;

	public ChangeJobRolePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void loginToApplication(String username, String password) {

		enterUserName.sendKeys(username);
		log.info("Entere user name = " + username + " and object is"
				+ enterUserName.toString());
		enterPassword.sendKeys(password);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}

	public boolean verifySeacrchBox() {
		try {
			searchBox.isDisplayed();
			log.info("Employment Status field is diplayed and object is "
					+ searchBox.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void enterEmployeeNameForRWPD() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}

	public void enterEmployeeNameForRWPH() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	public void enterEmployeeNameForISP() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	public void enterEmployeeNameForFWD() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	
	
	public boolean verifyEmployeeNameForRWPD() {
		try {
			joinerEmployee1.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee1.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeRWPD() {
		joinerEmployee1.click();

	}
	
	
	public boolean verifyEmployeeNameForRWPH() {
		try {
			joinerEmployee2.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee2.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeRWPH() {
		joinerEmployee2.click();

	}
	
	

	public boolean verifyEmployeeNameForISP() {
		try {
			joinerEmployee3.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee3.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeISP() {
		joinerEmployee3.click();

	}
	
	public boolean verifyEmployeeNameForFWD() {
		try {
			joinerEmployee4.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployee4.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeFWD() {
		joinerEmployee4.click();

	}
	
	
	
	public boolean verifyFirstJobRole() {
		try {
			clickFirstJobRole.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickFirstJobRole() {
		clickFirstJobRole.click();

	}

	
	
	
	public boolean VerifychangejobRoleButton() throws InterruptedException {
		Thread.sleep(2000);
		try {
			changeJobRoleButton.isDisplayed();
			log.info("change job role button is displayed====="
					+ changeJobRoleButton);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public void clickChangeJobroleButton() {
		changeJobRoleButton.click();

	}

	public boolean verifyChangeJobROlePage() {
		try {
			NewJobRoleText.isDisplayed();
			log.info("change job role is diplayed and object is "
					+ NewJobRoleText.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void setupChangeJobROleWithRWPD(String jobTitle,String jobRoleStartDate) throws InterruptedException {
		changeJobTitle.clear();
		changeJobTitle.sendKeys(jobTitle);
		Thread.sleep(5000);
		JobRoleStartDate.sendKeys(jobRoleStartDate);
		Thread.sleep(5000);
		clickSave.click();
		Thread.sleep(5000);
		clickOK.click();
		Thread.sleep(5000);
	}

	public void setupChangeJobROleWithRWPH(String jobTitle,String startDate,String empType,String empPatternType ) throws InterruptedException {
	
	  try{
		changeJobTitle.clear();
		changeJobTitle.sendKeys(jobTitle);
		Thread.sleep(5000);
		JobRoleStartDate.sendKeys(startDate);
		Thread.sleep(5000);
		Select selectByValueforEmploymentType = new Select(employmentType);
		log.info("ssssssssssssssss" + selectByValueforEmploymentType);
		selectByValueforEmploymentType.selectByValue(empType);
		Thread.sleep(10000);
		Select selectByValueforPatternType = new Select(employeePatternType);
		log.info("ssssssssssssssss" + selectByValueforPatternType);
		selectByValueforPatternType.selectByValue(empPatternType);
		Thread.sleep(5000);
		
		clickSave.click();
		Thread.sleep(5000);
		clickOK.click();
		Thread.sleep(5000);
		clickFinalSave.click();
		Thread.sleep(7000);
	  }
	 catch(Exception e){}
	
	}
	
	public void setupChangeJobROleWithISPandFWD(String jobTitle,String startDate,String empType,String empPatternType)throws InterruptedException{
		changeJobTitle.clear();
		changeJobTitle.sendKeys(jobTitle);
		Thread.sleep(5000);
		JobRoleStartDate.sendKeys(startDate);
		Thread.sleep(5000);
		Select selectByValueforEmploymentType = new Select(employmentType);
		log.info("ssssssssssssssss" + selectByValueforEmploymentType);
		selectByValueforEmploymentType.selectByValue(empType);
		Thread.sleep(10000);
		Select selectByValueforPatternType = new Select(employeePatternType);
		log.info("ssssssssssssssss" + selectByValueforPatternType);
		selectByValueforPatternType.selectByValue(empPatternType);
		Thread.sleep(5000);
		selectIrregularFromWorkingDays.click();
		Thread.sleep(5000);
		addArrowFromWorkingDays.click();
		Thread.sleep(5000);
		clickSave.click();
		Thread.sleep(5000);
		clickOK.click();
		Thread.sleep(5000);
		clickFinalOK.click();
		Thread.sleep(5000);
	}
	
	
	public boolean verifySecondJobRole() {
		try {
			clickSecondJobRole.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickSecondJobRole() {
		clickSecondJobRole.click();

	}

	public String SecondJobRoleTittleMatches() {
		try {
			String actualJobTitle = "";

			actualJobTitle = secondJobTitleMatch.getText();
			log.info("job title is=====" + actualJobTitle);
			return actualJobTitle;

		} catch (Exception e) {
			return "Lets see";
		}

	}

}
