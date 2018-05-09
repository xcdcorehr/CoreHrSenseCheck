package com.test.xcdhr.Core_HR_Sense_Check.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.xcdhr.Core_HR_Sense_Check.excelReader.excelReader;
//import com.test.xcdhr.Core_Sense_Check.uiActions.LoginPage;

public class TestBase {
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public String path ;
	public FileInputStream fis ;
	public XSSFWorkbook workbook ;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell ;
	public WebDriver driver;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "//src//main//java//com//test//xcdhr//Core_HR_Sense_Check//report" + formater.format(calendar.getTime()) + ".html", false);
	}
	
	excelReader excel;
//LoginPage login;

	public void init() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+ "//src//main//java//com//test//xcdhr//Core_HR_Sense_Check//report//test.html",false);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void loadPropertiesFile() throws IOException {
		f = new File(
				System.getProperty("user.dir")
						+ "//src//main//java//com//test//xcdhr//Core_HR_Sense_Check//config//config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
	
	}
	public void selectBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					System.getProperty("user.dir")
							+ "//drivers//geckodriver.exe");
			log.info("creating object of " + browser);
			driver = new FirefoxDriver();
		}
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\data\\HrAdminInputSheet.xlsx";
		log.info("the path is " + path);
		excel = new excelReader(path);
		log.info("see the path is " + path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		log.info("see the sheet name " + sheetName);
		log.info("see the excel name " + excelName);
		return data;
	}
	
	public String[][] getDataForHREmployee(String excelName, String sheetName) {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\data\\HrEmployeeInputSheet.xlsx";
		log.info("the path is " + path);
		excel = new excelReader(path);
		log.info("see the path is " + path);
		String[][] data = excel.getDataFromSheet(sheetName,excelName);
		log.info("see the data value " + data);
		log.info("see the sheet name " + sheetName);
		log.info("see the excel name " + excelName);
		return data;
	}
	
	public String[][] getDataForHRManagerTL(String excelName, String sheetName) {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\data\\HrManagerInputSheet.xlsx";
		excel = new excelReader(path);
		log.info("see the path is " + path);
		String[][] data = excel.getDataFromSheet(sheetName,excelName);
		log.info("see the sheet name " + sheetName);
		log.info("see the excel name " + excelName);
		return data;
	}
	
	
	public void waitForElement(int timeOutInSeconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void getScreenShot(String name){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			
		String reportDirectory =new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\ScreenShots\\";	
		File dstFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime())+".png");
		FileUtils.copyFile(srcFile, dstFile);
		Reporter.log("<a href='" +  dstFile.getAbsolutePath()+"'> <img src = '" + dstFile.getAbsolutePath()+"'height ='75 width ='75'/> </a>");
		} catch (IOException e){
		e.printStackTrace();
		}
	}
	
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\test\\xcdhr\\Core_HR_Sense_Check\\ScreenShots\\";
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
			String screen1 = captureScreen("");
			test.log(LogStatus.PASS, test.addScreenCapture(screen1));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	
	/*@AfterMethod()
	public void afterMethod(ITestResult result) {
		getresult(result);
	}*/

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest1() {
		closeBrowser();
	}
	public void closeBrowser() {
		//driver.quit();
		log.info("browser closed");
		extent.endTest(test);
		extent.flush();
	}
	
	

	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true ;
		}catch (Exception e){
	return false;
	}
		
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
	
	//test
	
	
	/*
	public void clickOKAfterCompleteLeaver() throws InterruptedException{
		
		driver.findElement(By.xpath("//*[@id='thepage:frm:pgB2:j_id102:j_id103']")).click();
		Thread.sleep(5000);
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
		
	}*/ 
	public void endTest(){
		driver.close();
	}
	
	
	
	
	public void alertHandelAccept(){
		Alert alt = driver.switchTo().alert();
		String confirmationAlert = alt.getText();
 		System.out.println("the 99999actual text"+confirmationAlert);
		alt.accept();
		
		
	}
	public void alertHandelDissmiss(){
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		
	}
	
	
	
	
	public  String getCellData(String sheetName,String colName,int rowNum){
		try{
		int col_Num = 0;
		int index =workbook.getSheetIndex(sheetName);
		
		sheet = workbook.getSheetAt(index);
		XSSFRow row = sheet.getRow(0);
			for (int i=0 ;i<row.getLastCellNum();i++){
				if (row.getCell(i).getStringCellValue().equals(colName)){
					col_Num =1 ;
					break;
				}	
				}
				row = sheet.getRow(rowNum-1);
				XSSFCell cell =row.getCell(col_Num);
					if(cell.getCellType()==Cell.CELL_TYPE_STRING){
						return cell.getStringCellValue();
					}
					else if (cell.getCellType()==Cell.CELL_TYPE_BLANK){
						return "";
							
						
					}
						
				
			}
		catch (Exception e ){
			e.printStackTrace();
		}
		
		
		return null ;
}
	
		public void gitHub(){
			
		}
//test

//test by firoz
}
	
	
	
	/*public void readLookupText (String lookupText )
	{
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
			}
			
			
			
		}
		
		*Testing GitHub by Firoz
		*Testing GitHub by Firoz
		*
		*
		*/
		
		
		
		
		
	


