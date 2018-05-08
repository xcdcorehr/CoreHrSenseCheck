package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import java.awt.List;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class JoinerPage extends TestBase {
	WebDriver driver;
	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;

	@FindBy(xpath = "//*[contains(@title,'Companies Tab')]")
	WebElement compainesss ;
	
	@FindBy(linkText = "Companies")
	WebElement companiesTab;
	//*[@id='01rb00000001Wv4_Tab']/a   for companies tab
	
		
	@FindBy(xpath = "//*[@id='fcf']")
	WebElement selectDNTCHComp;

	@FindBy(xpath = "//*[@id='filter_element']/div/span/span[1]/input")
	WebElement clcikGObutton;

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION TESTING")
	WebElement DNTCoreHRComp;
	//*[@id='a0Kb000000Dobme_Name']    for DO Not Touch Core HR Company
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION TESTING")
	WebElement clickDNTCoreHRComp;
	//*[@id='a0Kb000000Dobme_Name']/a/span  for click DNT Core HR COmpany
	
	/*@FindBy(xpath = "//*[@id='j_id0:j_id17:j_id18']/input")
	WebElement newJoinerbutton;*/

	@FindBy(xpath = "//*[contains(@value,'New joiner')]")
	WebElement newJoinerbutton1;
	
	
	@FindBy(xpath = "//*[@id='j_id0:theform']/div[1]/h3")
	WebElement verifyFirstPageofJoiner;
	
	@FindBy(xpath ="//*[@id='j_id0:theform:theblock:info:theblocksecitem:targetName']")
	WebElement enterExistingUserName;

	@FindBy(xpath ="//*[@id='j_id0:theform:theblock:info:theblocksecitem:j_id33']/img")
	WebElement existingUserLookupIcon;
	

	@FindBy(xpath ="//*[@id='j_id0:theform:theblock:info:j_id35:j_id44']")
	WebElement clickShowAll;
	
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement selecteExistingUserWithLicense;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ")
	WebElement selecteExistingUserWithoutLicense;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ")
	WebElement selecteExisting;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:info:theblockone:reguserfalse:FirstName:j_id61']/input")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:info:theblockone:reguserfalse:LastName:j_id65']/input")
	WebElement LastName;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:info:theblockone:reguserfalse:j_id68:j_id72']")
	WebElement email;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:info:theblockone:reguserfalse:j_id73:j_id76']")
	WebElement userName;


    @FindBy(xpath = "//*[@id='j_id0:theform:theblock:info:theblockone:reguserfalse:j_id90:j_id92']")
	WebElement activateLicense;
   
    @FindBy(xpath = "//*[@id='j_id0:theform:theblock:jbsec:jobtitle:j_id171']")
	WebElement jobTitle;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:jbsec:j_id184:j_id187']")
	WebElement employmentStatus;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:jbsec:j_id202:j_id204']")
	WebElement manager;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:jbsec:j_id202:j_id204_lkwgt']/img")
	WebElement managerLookupIcon;
	
	@FindBy(id = "//*[@id='fcf']")
	WebElement selectDNTCompany;
	
	
	@FindBy(name = "Go")
	WebElement clickGoOnManagerLookup;
	

	
	@FindBy(name ="go")
	WebElement selectManager ;
	//*[@id='User_body']/table/tbody/tr[2]/th/a
	
	
	@FindBy(xpath ="//*[@id='User_body']/table/tbody/tr[2]/th/a")
	WebElement selectManager1 ;
	
	
	
	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:pSec:j_id205:j_id207']")
	WebElement startDate;

	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:pSec:j_id208:consr']")
	WebElement contineousServiseDate;

	@FindBy(id = "lksrch")
	WebElement lookupTextbox;

	@FindBy(xpath = "//*[@id='theForm']/div/div[2]/input[2]")
	WebElement popWindowGo;

	@FindBy(xpath = "//*[@id='j_id0:theform:btn6']")
	WebElement clcikNext;

	//*[@id='j_id0:theform:theblock:j_id41:j_id42:0:j_id43'] = payroll automation               
	//*[@id='j_id0:theform:theblock:j_id37:j_id38:0:j_id39'] =esa
	/*@FindBy(xpath = "//*[@id='j_id0:theform:theblock:j_id37:j_id38:0:j_id39']")
	WebElement addrFromDate;*/
	@FindBy(xpath = "//*[text()='From date']//following::input[1]")
	WebElement addrFromDate;
	
	@FindBy(xpath = "//*[text()='Address 1']//following::input[1]")
	WebElement address1;

	@FindBy(xpath = "//*[text()='City']//following::input[1]")
	WebElement addrCity;

	@FindBy(xpath = "//*[text()='Postcode']//following::input[1]")
	WebElement addrPostcode;

	@FindBy(xpath = "//*[text()='Country']//following::select[1]")
	WebElement addrCountry;
	//*[@id='j_id0:theform:theblock:j_id41:j_id42:6:j_id43']
	@FindBy(xpath = "//*[text()='Address type']//following::select[1]")
	WebElement addrAddressType;
	
	@FindBy(xpath = "//*[text()='Next of kin name']//following::input[1]")
	WebElement nextofKinName;

	@FindBy(xpath = "//*[text()='Emergency contact']//following::select[1]")
	WebElement emergencyContact;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:Comsec:j_id60:2:j_id61']")
	WebElement pensionablesalary;
	//*[@id='j_id0:theform:theblock:Comsec:j_id60:2:j_id61']
	
	@FindBy(xpath = "//*[text()='Regular pay']//following::input[1]")
	WebElement rPay;

	@FindBy(xpath = "//*[text()='Period']//following::select[1]")
	WebElement period;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:btn1']")
	WebElement clickSave;
	
	
	@FindBy(xpath = "//*[@id='j_id0:theform:theblock:btn4']")
	WebElement saveAndAddBenefit;
	
	@FindBy(xpath = "//*[text() ='Company benefits']")
	WebElement verifyThirdCompanyBenefit;
	
	
	
	@FindBy(xpath = "//form/div[1]/div/div/div/div[2]/table/tbody/tr/td[1]/select")
	WebElement schemeNameForBenefit;
	
	
	@FindBy(xpath = "//form/div[1]/div/div/div/div[2]/table/tbody/tr/td[4]/div/input")
    WebElement employerContributionBenefit;
	
	@FindBy(xpath = "//form/div[1]/div/div/div/div[2]/table/tbody/tr/td[5]/div/input")
    WebElement employeeContributionBenefit;

	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement clickSaveOnBenefit;


	@FindBy(id = "phSearchInput")
	WebElement searchBox;

	@FindBy(id = "phSearchButton")
	WebElement searchButton;

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ")
	WebElement joinerEmployeeWithoutUser;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement joinerEmployeeWithActiveLicense;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ")
	WebElement joinerEmployeeWithoutActiveLicense;
	
	//*[@id='Employee_Detail__c_body']/table/tbody/tr[2]/th/a
	//*[@id='j_id0:JobRoleBlock:j_id515:0:j_id516']/a
	@FindBy(linkText = "Tester")
	WebElement clickJobRole;

	@FindBy(xpath = "//*[@id='Namej_id0_j_id1_j_id2_ileinner']")
	public WebElement jobTitleMatch;

	@FindBy(xpath = "//*[@id='lookupa0Kb000000Dobmej_id0_j_id1_j_id200Nb0000009I7HP']")
	WebElement companyNameMatch;

	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ")
	WebElement goBacktoEmployee;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ")
	WebElement goBacktoEmployee1;
	
	@FindBy(linkText = "DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ")
	WebElement goBacktoEmployee2;
	
	@FindBy(xpath = "//*[@id='j_id0:reward_lbl']")
	WebElement rewardTab;
	                  //div[1]/div/div[2]/table/tbody/tr/td[1]/a
	@FindBy(xpath = "//form/div[1]/div/div[2]/table/tbody/tr/td[1]/a")
	WebElement clickCompensation;
	//*[@id='j_id0:rewardHelp:CompensationBlock:j_id1100:0:j_id1101']/a

	@FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[4]/div[2]/div[4]/table/tbody/tr[1]/td[2]")
	WebElement verifyAnnualSalary;
	
	@FindBy(xpath = "//*[@id='j_id0:theform:pb1:pgt1:0:j_id60:0:j_id64']")
	WebElement memberNumber;
	
	public JoinerPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);

	}

	public void loginToApplication(String username, String password) {

		enterUserName.sendKeys(username);
		log.info("Enter user name = " + username + " and object is"
				+ enterUserName.toString());
		enterPassword.sendKeys(password);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}

	public boolean verifyCompaniesTab() {
		try {

			compainesss.isDisplayed();
			log.info("companies tab is displayed and object is"
					+ compainesss.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnCompaniesTab() {
		compainesss.click();
		log.info("clicked on companies tab and object is "
				+ companiesTab.toString());

	}
	public void selectDNTCompany(){
		Select selectByValueDNTCompany = new Select(selectDNTCompany);
		log.info("ssssssssssssssss" + selectByValueDNTCompany);
		selectByValueDNTCompany.selectByVisibleText("DO NOT TOUCH COREHR AUTOMATION TESTING");
		
		
	}
	
	
	public boolean verifyGObutton() {
		try {
			;
			clcikGObutton.isDisplayed();
			log.info("Go button is displayed and object is"
					+ clcikGObutton.toString());

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickGO() {
		clcikGObutton.click();
		log.info("Clicked on GO button and object is"
				+ clcikGObutton.toString());

	}

	public boolean verifyDNTcoreHRCompDisplayed() {
		try {
			DNTCoreHRComp.isDisplayed();
			log.info("Do not touch core HR Company is displayed and object is" + DNTCoreHRComp.toString());

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickDNTcoreHRComp() {
		clickDNTCoreHRComp.click();
		log.info("Do not touch core HR company clicked and object is"
				+ DNTCoreHRComp.toString());

	}

	public boolean verifyJoinerbutton() {
		try {
			newJoinerbutton1.isDisplayed();
			log.info("New joiner button displayed on  Company"
					+ newJoinerbutton1.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickNewJoinerButton() {
		newJoinerbutton1.click();
	}

	public boolean verifyJoinerFirstPage() {
		try {
			verifyFirstPageofJoiner.isDisplayed();
			log.info("Setup new joiner text is displayed and object is"
					+ verifyFirstPageofJoiner.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public boolean verifyJoinerThirdPage() {
		try {
			schemeNameForBenefit.isDisplayed();
			log.info("company benefit text is displayed and object is"
					+ verifyThirdCompanyBenefit.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	

	public boolean verifyEmploymentStatus() {
		try {
			employmentStatus.isDisplayed();
			log.info("Employment Status field is diplayed and object is "
					+ employmentStatus.toString()); 
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void setupExistingUserWtihLicense(String existingUser) throws InterruptedException{
		enterExistingUserName.sendKeys(existingUser);
		Thread.sleep(15000);
		existingUserLookupIcon.click();
				Thread.sleep(8000);
				clickShowAll.click();
				Thread.sleep(8000);
				selecteExistingUserWithLicense.click();
				Thread.sleep(10000);
	}
		
	public void setupExistingUserForBenefit(String existingUser) throws InterruptedException{
		enterExistingUserName.sendKeys(existingUser);
		Thread.sleep(15000);
		existingUserLookupIcon.click();
				Thread.sleep(8000);
				clickShowAll.click();
				Thread.sleep(8000);
				selecteExisting.click();
				Thread.sleep(10000);
	}
	
	
	public void setupExistingUserWtihoutLicense(String licenseActivate,String existingUser) throws InterruptedException{
	
		Select selectByValueforActivateLicense = new Select(activateLicense);
		log.info("ssssssssssssssss" + selectByValueforActivateLicense);
		selectByValueforActivateLicense.selectByVisibleText(licenseActivate);
		
		Thread.sleep(5000);
		
		
		enterExistingUserName.sendKeys(existingUser);
		Thread.sleep(15000);
		existingUserLookupIcon.click();
				Thread.sleep(15000);
				clickShowAll.click();
				Thread.sleep(15000);
				selecteExistingUserWithoutLicense.click();
				Thread.sleep(30000);
				
				
	}
		
	
	public void setupFirstPageOfJoinerAndClickNext(String jTitle,String empStatus,String empManager,String empStartDate,String empContineousStartDate) throws InterruptedException{
		jobTitle.sendKeys(jTitle);
		log.info("Enter job tile = " + jobTitle + " and object is"
				+ jobTitle.toString());
		Select selectByValue = new Select(employmentStatus);
		log.info("+++++++" + selectByValue);
		selectByValue.selectByValue(empStatus);
		manager.sendKeys(empManager);
		startDate.sendKeys(empStartDate);
		contineousServiseDate.sendKeys(empContineousStartDate);
		clcikNext.click();
	
	}
	
	
	
	public boolean verifySecondPage(){
		try {
			
			clickSave.isDisplayed();
			log.info("Control is on second page and Save button is displaying "
					+ clickSave.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean verifySecondPageRegularPay(){
		try {
			addrFromDate.isDisplayed();
			log.info("Control is on second page and regular pay field is displaying "
					+ addrFromDate.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	public void setupSecondPageOfJoinerAndClickSave(String empAddrFromDate,String addr1,String empCity,String empPostCode,String empCountry,String empAddrType,String empNOK,String empRegularPay,String empPeriod) throws InterruptedException {
		log.info("-----------"+addrFromDate);
		addrFromDate.sendKeys(empAddrFromDate);
		log.info("-----------"+addrFromDate);
		Thread.sleep(10000);
		address1.sendKeys(addr1);
		Thread.sleep(5000);
		addrCity.sendKeys(empCity);
		Thread.sleep(5000);
		addrPostcode.sendKeys(empPostCode);
		Thread.sleep(5000);
	
		Select selectByValueforCountry = new Select(addrCountry);
		log.info("+++++++" + selectByValueforCountry);
	    selectByValueforCountry.selectByValue(empCountry);
	    Thread.sleep(5000);
		Select selectByValueforAddressType = new Select(addrAddressType);
		log.info("+++++++" + selectByValueforAddressType);
		selectByValueforAddressType.selectByValue(empAddrType);
		Thread.sleep(5000);
		nextofKinName.sendKeys(empNOK);
		Thread.sleep(5000);
		log.info("next of kin field is available and control found this"+nextofKinName);
		rPay.clear();
		rPay.sendKeys("1000");
		Thread.sleep(2000);
		Select selectByValueforPeriod = new Select(period);
		Thread.sleep(2000);
		log.info("+++++++" + selectByValueforPeriod);
		selectByValueforPeriod.selectByValue(empPeriod);
		Thread.sleep(3000);
		
		clickSave.click();	
		Thread.sleep(12000);
		
	}
	public void setupSecondPageOfJoinerAndClickSaveAndAddBenefit(String empAddrFromDate,String addr1,String empCity,String empPostCode,String empCountry,String empAddrType,String empNOK,String empRegularPay,String empPeriod) throws InterruptedException {
		log.info("-----------"+addrFromDate);
		addrFromDate.sendKeys(empAddrFromDate);
		log.info("-----------"+addrFromDate);
		Thread.sleep(10000);
		address1.sendKeys(addr1);
		Thread.sleep(5000);
		addrCity.sendKeys(empCity);
		Thread.sleep(5000);
		addrPostcode.sendKeys(empPostCode);
		Thread.sleep(5000);
	
		Select selectByValueforCountry = new Select(addrCountry);
		log.info("+++++++" + selectByValueforCountry);
	    selectByValueforCountry.selectByValue(empCountry);
	    Thread.sleep(5000);
		Select selectByValueforAddressType = new Select(addrAddressType);
		log.info("+++++++" + selectByValueforAddressType);
		selectByValueforAddressType.selectByValue(empAddrType);
		Thread.sleep(5000);
		nextofKinName.sendKeys(empNOK);
		Thread.sleep(5000);
		log.info("next of kin field is available and control found this"+nextofKinName);
		rPay.clear();
		rPay.sendKeys("1000");
		Thread.sleep(2000);
		Select selectByValueforPeriod = new Select(period);
		Thread.sleep(2000);
		log.info("+++++++" + selectByValueforPeriod);
		selectByValueforPeriod.selectByValue(empPeriod);
		Thread.sleep(3000);
		
		saveAndAddBenefit.click();	
		Thread.sleep(4000);
		
	}
	
	public void setupPersonalSectionOfJoinerFirstPage(String firstname,
			String lastname, String email, String username,
			String activateLicense1, String jobtitle, String empStatus,
			String manager1, String StartDate, String ContinousStdate,
			String addr1, String city, String postcode, String addrCountry1,
			String addrType, String nextOfKin, String emregencyContact,
			String regularPay1, String regularPeriod) throws Throwable {

		firstName.sendKeys(firstname);
		log.info("Entere first name = " + firstname + " and object is"
				+ firstName.toString());
		LastName.sendKeys(lastname);
		log.info("Enter last name = " + lastname + " and object is"
				+ LastName.toString());
		this.email.sendKeys(email);
		log.info("Enter email = " + email + " and object is"
				+ email.toString());
		userName.sendKeys(username);
		Select selectByValueforActivateLicense = new Select(activateLicense);
		log.info("+++++++" + selectByValueforActivateLicense);
		selectByValueforActivateLicense.selectByValue(activateLicense1);

		log.info("user namee = " + username + " and object is"
				+ username.toString());
		jobTitle.sendKeys(jobtitle);

		log.info("Enter job tile = " + jobtitle + " and object is"
				+ jobtitle.toString());
		Select selectByValue = new Select(employmentStatus);
		log.info("+++++++" + selectByValue);
		selectByValue.selectByValue(empStatus);
		// readLookupText(manager1);

		manager.sendKeys(manager1);
		startDate.sendKeys("01/12/2017");
		contineousServiseDate.sendKeys("01/12/2017");
		clcikNext.click();
		addrFromDate.sendKeys("01/12/2017");
		address1.sendKeys(addr1);
		addrCity.sendKeys(city);
		addrPostcode.sendKeys(postcode);
		Thread.sleep(5000);
		Select selectByValueforCountry = new Select(addrCountry);
		log.info("+++++++" + selectByValueforCountry);
	    selectByValueforCountry.selectByValue(addrCountry1);
		//selectByValue(addrCountry1);
		
		Thread.sleep(5000);
		Select selectByValueforAddressType = new Select(addrAddressType);
		log.info("+++++++" + selectByValueforAddressType);
		selectByValueforAddressType.selectByValue(addrType);
		nextofKinName.sendKeys(nextOfKin);
		this.emergencyContact.sendKeys(emregencyContact);
		Thread.sleep(2000);
		double rsal = Double.parseDouble(regularPay1);
		DecimalFormat df1 = new DecimalFormat("####.##");
		String rsalwithoutDecimal = df1.format(rsal);
		rPay.clear();
		rPay.sendKeys(rsalwithoutDecimal);
		period.sendKeys(regularPeriod);
		Thread.sleep(2000);
		clickSave.click();
		Thread.sleep(12000);

	}
      public void setupThirdPageOfJoiner(String schemeName,String employerContribution,String employeeContribution) throws InterruptedException{
		Thread.sleep(3000);
		Select selectCompBenefit = new Select(schemeNameForBenefit);
		log.info("+++++++" + selectCompBenefit);
		selectCompBenefit.selectByValue(schemeName);	
		Thread.sleep(2000);
		employerContributionBenefit.sendKeys(employerContribution);
		Thread.sleep(2000);
		employeeContributionBenefit.sendKeys(employeeContribution);
		Thread.sleep(3000);
		clickSaveOnBenefit.click();
		Thread.sleep(5000);
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

	public void enterEmployeeNameWithoutUser() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 101 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	public void enterEmployeeNameWithLicense() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 102 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}

	public void enterEmployeeNameWithoutLicense() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 103 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	public void enterEmployeeNameWithBenefitRecordCreated() throws InterruptedException {
		searchBox.sendKeys("DO NOT TOUCH COREHR AUTOMATION EMP 104 FIROZ");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(200);

	}
	
	
	public boolean verifyEmployeeNamewithActiveLicense() {
		try {
			joinerEmployeeWithActiveLicense.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployeeWithActiveLicense.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeWithActiveLicense() {
		joinerEmployeeWithActiveLicense.click();

	}

	public boolean verifyEmployeeNameWithoutActiveLicense() {
		try {
			joinerEmployeeWithActiveLicense.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployeeWithActiveLicense.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeWithoutActiveLicense() {
		joinerEmployeeWithoutActiveLicense.click();

	}
	
	public boolean verifyEmployeeNameWithoutUser() {
		try {
			joinerEmployeeWithoutUser.isDisplayed();
			log.info("Employee is available on the page "
					+ joinerEmployeeWithoutUser.toString());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickVerifiedEmployeeWithoutUser() {
		joinerEmployeeWithoutUser.click();

	}
	
	
	public boolean verifyJobRole() {
		try {
			clickJobRole.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickJobRole() {
		clickJobRole.click();

	}

	public String JobRoleTittleMatches() {
		try {
			String actualJobTitle = "";

			actualJobTitle = jobTitleMatch.getText();
			log.info("job title is=====" + actualJobTitle);
			return actualJobTitle;

		} catch (Exception e) {
			return "Lets see";
		}
		
	}

	public boolean verifyEmployeeOnJobrole() {
		try {
			goBacktoEmployee.isDisplayed();
			log.info("=====employee name  should be DO NOT TOUCH====="+goBacktoEmployee.isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void goBacktoEmploymentFromJobRole() {
		goBacktoEmployee.click();

	}

	
	public boolean verifyEmployeeOnJobrole1() {
		try {
			goBacktoEmployee1.isDisplayed();
			log.info("=====employee name  should be DO NOT TOUCH====="+goBacktoEmployee1.isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void goBacktoEmploymentFromJobRole1() {
		goBacktoEmployee1.click();

	}


	public boolean verifyEmployeeOnJobrole2() {
		try {
			goBacktoEmployee2.isDisplayed();
			log.info("=====employee name  should be DO NOT TOUCH====="+goBacktoEmployee2.isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void goBacktoEmploymentFromJobRole2() {
		goBacktoEmployee2.click();

	}
	
	
	
	public boolean verifyRewardTab() {
		try {
			rewardTab.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickRewardTab() throws InterruptedException {
		rewardTab.click();
		Thread.sleep(4000);
		clickCompensation.click();
	}

	public String VerifyCompnesationAmount() {
		try {
			String actualCompensationAmount = "";

			actualCompensationAmount = verifyAnnualSalary.getText();
			log.info("Annual salary=====" + verifyAnnualSalary);
			return actualCompensationAmount;

		} catch (Exception e) {
			return "Lets see";
		}

	}

}

/*
 * public void readLookupText () {
 * 
 * String homePage = driver.getWindowHandle(); log.info("33333333"+homePage);
 * Set<String> windows = driver.getWindowHandles();
 * log.info("Size off the window"+windows.size());
 * 
 * Iterator iterator = windows.iterator(); String currentWindoID ;
 * while(iterator.hasNext()){ currentWindoID = iterator.next().toString();
 * log.info("popupWindoID ====="+currentWindoID);
 * if(!currentWindoID.endsWith(homePage)){
 * driver.switchTo().window(currentWindoID); }
 * 
 * 
 * }
 */
/* Below code is for standard lookup*/
/*//	Thread.sleep(5000);
managerLookupIcon.click();
Thread.sleep(5000);
String parentWindow = driver.getWindowHandle();
log.info("======="+driver.getWindowHandle());

Set<String> windows =driver.getWindowHandles();
for(String childWindow : windows ){
	if(childWindow.equals(parentWindow)==false){
		log.info("child window ==="+childWindow);
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		break;
	}
	log.info(childWindow);
}

log.info("childdd url"+driver.getCurrentUrl());
log.info("childdd title"+driver.getTitle());
//	Thread.sleep(10000L);
driver.findElement(By.linkText("Show all results"));
//	driver.findElement(By.xpath("//*[@id='theForm']/div/div[2]/input[2]")).click();
//	clickGoOnManagerLookup.click();
Thread.sleep(10000L);
//	selectManager.click();
log.info("manager is selected and object is "+selectManager);
//	driver.quit();
driver.switchTo().window(parentWindow);
log.info("Parenttt url"+driver.getCurrentUrl());
log.info("Parenttt title"+driver.getTitle());
Thread.sleep(5000);*/
