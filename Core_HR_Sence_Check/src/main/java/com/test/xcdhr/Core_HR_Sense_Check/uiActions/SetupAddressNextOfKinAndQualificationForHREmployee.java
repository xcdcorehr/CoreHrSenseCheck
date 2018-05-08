package com.test.xcdhr.Core_HR_Sense_Check.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class SetupAddressNextOfKinAndQualificationForHREmployee extends TestBase {

	WebDriver driver;
	@FindBy(id = "username")
	WebElement enterUserName;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(id = "Login")
	WebElement clickLogin;
	
	@FindBy(linkText = "My Details")
	WebElement myDetailTab;
    
	@FindBy(xpath = "//*[@id='j_id0:tabdetails_lbl']")
	WebElement personalSubTab;
  
	@FindBy(xpath = "//*[@id='j_id0:jobRole_lbl']")
	WebElement employmentSubTab;
	
	/*Personal address*/
	
	@FindBy(xpath = "//*[contains(@value,'New address')]")
	WebElement newAddressButton;
	
	
	@FindBy(xpath = "//*[text()='New address']")
	WebElement verifyAddressPage;
	
	
	@FindBy(xpath = "//*[text()='From date']//following::input[1]")
	WebElement fromDateAddress;
	
	@FindBy(xpath = "//*[text()='Address 1']//following::input[1]")
	WebElement address1Address;
	
	@FindBy(xpath = "//*[text()='Address 2']//following::input[1]")
	WebElement address2Address;
	
	@FindBy(xpath = "//*[text()='City']//following::input[1]")
	WebElement cityAddress;
	
	@FindBy(xpath = "//*[text()='Postcode']//following::input[1]")
	WebElement postcodeAddress;
	
	@FindBy(xpath = "//*[text()='Address type']//following::select[1]")
	WebElement addressTypeAddress;
	
	@FindBy(xpath = "//*[text()='Country']//following::select[1]")
	WebElement countryAddress;
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement addressSaveButton;
	
	@FindBy(xpath = "//*[text()='Current home']")
	WebElement verifyAddressType;
	
	@FindBy(xpath = "//*[text()='Elgin road']")
	WebElement verifyAddress1;
	
	@FindBy(xpath = "//*[text()='Park street']")
	WebElement verifyAddress2;
	
	@FindBy(xpath = "//*[text()='Kolkata']")
	WebElement verifyCity;
	
	@FindBy(xpath = "//*[text()='KOL901']")
	WebElement verifyPostcode;
	

	@FindBy(xpath = "//*[text()='From date']")
	WebElement verifyFromDate;
	
	
	/*Next of kin*/
	
	@FindBy(xpath = "//*[contains(@value,'New next of kin')]")
	WebElement newNokButton;
	

	@FindBy(xpath = "//*[text()='New next of kin']")
	WebElement verifyNoKPage;
	
	@FindBy(xpath = "//*[text()='Next of kin name']//following::input[1]")
	WebElement NokName;
	
	@FindBy(xpath = "//*[text()='Relationship to employee']//following::input[1]")
	WebElement relationShipWithEmp;
	
	@FindBy(xpath = "//*[text()='Emergency contact']//following::select[1]")
	WebElement emergencyContact;
	
	@FindBy(xpath = "//*[text()='Mobile']//following::select[1]")
	WebElement mobile;
	
	@FindBy(xpath = "//*[text()='Work phone']//following::select[1]")
	WebElement workPhone;
	
	@FindBy(xpath = "//*[text()='Email']//following::select[1]")
	WebElement email;
	
	@FindBy(xpath = "//*[contains(@value,'Save')]")
	WebElement NokSaveButton;
	
	@FindBy(xpath = "//*[text()='James taylor']")
	WebElement verifyNokName;
	
	@FindBy(xpath = "//*[text()='Brother']")
	WebElement verifyNokRelationship;
	
	@FindBy(xpath = "//*[text()='Yes']")
	WebElement verifyNokEmergencyContact;
	
	@FindBy(xpath = "90278923']")
	WebElement verifyNokMobile;
	
	
	/*Qualification*/
	
	@FindBy(xpath = "//*[contains(@value,'New qualification')]")
	WebElement newQualificationButton;
	
	@FindBy(xpath = "//*[text()='New qualification']")
	WebElement verifyQualificationPage;
	
	@FindBy(xpath = "//*[text()='Course title']//following::input[1]")
	WebElement courseTitle;
	
	@FindBy(xpath = "//*[text()='Type']//following::select[1]")
	WebElement courseType;
	
	@FindBy(xpath = "//*[text()='Provider']//following::input[1]")
	WebElement courseProvider;
    
	@FindBy(xpath = "//*[text()='Date']//following::input[1]")
	WebElement courseDate;
	
	@FindBy(xpath = "//*[text()='Location']//following::input[1]")
	WebElement courseLocaion;
	
	@FindBy(xpath = "//*[text()='Duration']//following::input[1]")
	WebElement courseDuration;
    
	@FindBy(xpath = "//*[text()='Period']//following::select[1]")
	WebElement coursePeriod;
    
	@FindBy(xpath = "//*[text()='Result']//following::input[1]")
	WebElement courseResult;
	
	@FindBy(xpath = "//*[text()='Status']//following::select[1]")
	WebElement courseStatus;
	
	@FindBy(xpath = "//div/div/div/div[3]/table/tbody/tr/td[2]/span/span/span[2]/span/input[1]")
	WebElement CourseSaveButton;
	
	@FindBy(xpath = "//*[text()='Test']")
	WebElement verifyCourseTitle;
	
	@FindBy(xpath = "//*[text()='Made Easy']")
	WebElement verifyCourseProvider;
	
	@FindBy(xpath = "//*[text()='Park Street']")
	WebElement verifyCourseLocation;

	@FindBy(xpath = "//*[text()='5']")
	WebElement verifyCourseDuration;
	

	@FindBy(xpath = "//*[text()='Months']")
	WebElement verifyCoursePeriod;
	

	@FindBy(xpath = "//*[text()='Completed']")
	WebElement verifyCourseStatus;
	

	@FindBy(xpath = "//*[text()='29/03/2018']")
	WebElement verifyCourseDate;
	
	@FindBy(xpath = "//*[text()='Pass']")
	WebElement verifyCourseResult;

	
	public SetupAddressNextOfKinAndQualificationForHREmployee(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);

	}
	
	public void loginToApplicationForEmployee(String username, String password) throws InterruptedException {

		enterUserName.sendKeys(username);
		log.info("Entere user name = " + username + " and object is"
				+ enterUserName.toString());
		Thread.sleep(3000);
		enterPassword.sendKeys(password);
		Thread.sleep(3000);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		Thread.sleep(3000);
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}
/*	public void loginToApplicationForManager(String username, String password) {

		enterUserName.sendKeys(username);
		log.info("Entere user name = " + username + " and object is"
				+ enterUserName.toString());
		enterPassword.sendKeys(password);
		log.info("Enter Passord = " + password + " and object is"
				+ enterPassword.toString());
		clickLogin.click();
		log.info("Click on Login button and objet is" + clickLogin.toString());

	}

	*/
	
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
	
	public boolean verifyPersonalTab() {
		try {

			personalSubTab.isDisplayed();
			log.info("Personal  tab is displayed and object is"
					+ personalSubTab.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickPersonalTab(){
		personalSubTab.click();
		log.info("Personal Tab ic clicked");
	}

	
	//Personal address started//
	public boolean verifyNewAddressButton() {
		try {

			newAddressButton.isDisplayed();
			log.info("New address button is displayed"
					+ newAddressButton.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickNewAddressButton(){
		newAddressButton.click();
		log.info("New address button is clicked");
	}
	public boolean verifyAddressPage(){
		try {
			;
			verifyAddressPage.isDisplayed();
			log.info("Control is on new Address page"
					+ verifyAddressPage.toString());

			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public void setupPersonalAddress(String fromdate,String address1,String address2,String city ,String postCode,String country,String addressType) throws InterruptedException{
		Thread.sleep(5000);
		log.info("address from date value is"+fromdate);
		fromDateAddress.sendKeys(fromdate);
		Thread.sleep(2000);
		address1Address.sendKeys(address1);
		Thread.sleep(2000);
		address2Address.sendKeys(address2);
		Thread.sleep(2000);
		cityAddress.sendKeys(city);
		Thread.sleep(2000);
		postcodeAddress.sendKeys(postCode);
		Thread.sleep(2000);
		Select selectCountry = new Select(countryAddress);
		log.info("+++++++" + selectCountry);
		selectCountry.selectByValue(country);
		Thread.sleep(2000);
		Select selectAddressType = new Select(addressTypeAddress);
		log.info("+++++++" + selectAddressType);
		selectAddressType.selectByValue(addressType);
		Thread.sleep(3000);
		addressSaveButton.click();	
		Thread.sleep(8000);
	}
	 public String getAddressType(){
		 String addressType;
		 addressType = verifyAddressType.getText();
		 log.info("value of address type is "+addressType);
		 return addressType;
	}
	
	 public String getAddress1(){
		 String address1;
		 address1 = verifyAddress1.getText();
		 log.info("value of address 1 is "+address1);
		 return address1;
	}
	 public String getCity(){
		 String city;
		 city = verifyCity.getText();
		 log.info("value of city is "+city);
		 return city;
	} 

	 
	 public String getPostCode(){
		 String postcode;
		 postcode = verifyPostcode.getText();
		 log.info("value of post code is "+postcode);
		 return postcode;
	} 
	 //Personal address ended//
	 
	 
	 //Next of Kin Started
	 
	 public boolean verifyNewNextOfKinButton() {
			try {

				newNokButton.isDisplayed();
				log.info("New Next of kin button is displayed"
						+ newNokButton.toString());

				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public void clickNewNOkButton(){
			newNokButton.click();
			log.info("New NOK button is clicked");
		}
		public boolean verifyNoKPage(){
			try {
				;
				verifyNoKPage.isDisplayed();
				log.info("Control is on new next of kin page"
						+ verifyNoKPage.toString());

				return true;
			} catch (Exception e) {
				return false;
			}

		}
	 
		public void setupNOK(String nextOfKinName,String relationshipWithEmp,String contactOfEmergency) throws InterruptedException{
			Thread.sleep(5000);
			NokName.sendKeys(nextOfKinName);
			Thread.sleep(2000);
			relationShipWithEmp.sendKeys(relationshipWithEmp);
			Thread.sleep(2000);
			Select selectAddressType = new Select(emergencyContact);
			selectAddressType.selectByValue(contactOfEmergency);
		
		
			Thread.sleep(3000);
			NokSaveButton.click();	
			Thread.sleep(8000);
		}
		 public String getNokName(){
			 String nokName;
			 nokName = verifyNokName.getText();
			 log.info("value of NOK Name "+nokName);
			 return nokName;
		}
		
		 public String getNokRelationhip(){
			 String nokRelationship;
			 nokRelationship = verifyNokRelationship.getText();
			 log.info("Relationship is "+nokRelationship);
			 return nokRelationship;
		}
		 public String getNokEmergencyContact(){
			 String emergencyContact;
			 emergencyContact = verifyNokEmergencyContact.getText();
			 log.info("value of emergency contact "+emergencyContact);
			 return emergencyContact;
		} 

		 public String getNokMobile(){
			 String mobileNumber;
			 mobileNumber = verifyNokMobile.getText();
			 log.info("value of mobile no "+mobileNumber);
			 return mobileNumber;
		} 
	 
		 //Qualification started 
		 
		 public boolean verifyNewQualificationButton() {
				try {

					newQualificationButton.isDisplayed();
					log.info("New Qualification button is"
							+ newQualificationButton.toString());

					return true;
				} catch (Exception e) {
					return false;
				}
			}
			
			public void clickQualificationButton(){
				newQualificationButton.click();
				log.info("New Qualification button is clicked");
			}
			public boolean verifyQualificationPage(){
				try {
					;
					verifyQualificationPage.isDisplayed();
					log.info("Control is on new Qualification page"
							+ verifyQualificationPage.toString());

					return true;
				} catch (Exception e) {
					return false;
				}

			}
		 
			public void setupQualification(String title,String type,String provider,String date,String location,String duration,String period,String result,String status ) throws InterruptedException{
				Thread.sleep(2000);
				courseTitle.sendKeys(title);
				Thread.sleep(2000);
				
				Select selectType = new Select(courseType);
				selectType.selectByValue(type);
				
				courseProvider.sendKeys(provider);
				Thread.sleep(2000);
				courseDate.sendKeys(date);
				
				courseLocaion.sendKeys(location);
				Thread.sleep(2000);
				courseDuration.sendKeys(duration);
				Thread.sleep(2000);
			
				Select selectedPeriod = new Select(coursePeriod);
				selectedPeriod.selectByValue(period);
				
				courseResult.sendKeys(result);
				Thread.sleep(2000);
				Select selectStatus = new Select(courseStatus);
				selectStatus.selectByValue(status);
			
			
				Thread.sleep(3000);
				CourseSaveButton.click();	
				Thread.sleep(4000);
				employmentSubTab.click();
				Thread.sleep(8000);
			
			
			}
			 public String getCourseTitle(){
				 String coursetitle;
				 coursetitle = verifyCourseTitle.getText();
				 log.info("value of Title "+coursetitle);
				 return coursetitle;
			}
			
			 public String getCourseDate(){
				 String coursedate;
				 coursedate = verifyCourseDate.getText();
				 log.info("course date is "+coursedate);
				 return coursedate;
			}
			 public String getCourseProvider(){
				 String courseprovider;
				 courseprovider = verifyCourseProvider.getText();
				 log.info("value of course provider "+courseprovider);
				 return courseprovider;
			} 

			 public String getCourseResult(){
				 String result;
				 result = verifyCourseResult.getText();
				 log.info("value of result "+result);
				 return result;
			} 
		 
			 public String getCourseStatus(){
				 String status;
				 status = verifyCourseStatus.getText();
				 log.info("value of statuss "+status);
				 return status;
			} 
		 
			
	 
}
