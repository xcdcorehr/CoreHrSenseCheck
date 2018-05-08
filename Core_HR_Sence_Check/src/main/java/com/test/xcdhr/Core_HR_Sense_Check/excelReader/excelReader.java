package com.test.xcdhr.Core_HR_Sense_Check.excelReader;

import java.io.File;
import java.io.FileInputStream;







import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.xcdhr.Core_HR_Sense_Check.testBase.TestBase;

public class excelReader extends TestBase{

public static final Logger log = Logger.getLogger(excelReader.class.getName());

public String path ;
public FileInputStream fis ;
public XSSFWorkbook workbook ;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell ;




public excelReader(String path) {
	this.path = path ;
	try{
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	}
	catch(Exception e){
		e.printStackTrace();
	}
		 
}

@SuppressWarnings("deprecation")
public String [][] getDataFromSheet (String sheetName,String excelName){
	String dataSets[][] = null;
	 //Get sheet from excel workbook 
	try {
	XSSFSheet sheet = workbook.getSheet(sheetName);
	 //Count number of active rows 
	 int totalRow = sheet.getLastRowNum() + 1 ;
	 //Count total number of columns 
	 int totalColumn = sheet.getRow(0).getLastCellNum();
	 //Create array of rows and column 
	 dataSets = new String [totalRow-1][totalColumn];
	 //Run for loop and store data in 2D array
	 //This for loop will run on rows 
	 	for (int i=1;i< totalRow ;i++){
	 		//get row method will get row
	 		XSSFRow row = sheet.getRow(i);
	 	//This for loop will run on column 
	 		for(int j=0; j<totalColumn;j++){
	 			//get cell method will get cell 
	 			XSSFCell cell = row.getCell(j);
	 			// If cell type is String then below If condition will work 
	 			log.info("whats wgoing here"+dataSets[i-1][j]);
	 			log.info("123456"+cell.getCellType() +"and "+"654321"+Cell.CELL_TYPE_STRING);
	 			if (cell.getCellType()==Cell.CELL_TYPE_STRING){
	 				log.info("123456"+cell.getCellType() +"and "+"654321"+Cell.CELL_TYPE_STRING);
	 				dataSets[i-1][j]=cell.getStringCellValue();
	 				log.info("whats wgoing here"+dataSets[i-1][j]);
	 			}
	 			//if cell type is number then below If condition will work 
	 			else if (cell.getCellType()== Cell.CELL_TYPE_NUMERIC){
	 				String cellText = String.valueOf(cell.getNumericCellValue());
	 				dataSets[i-1][j] =cellText;
	 			}
	 			
	 			else {
	 				//if cell type is boolean then below if condition wll work 
	 				dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
	 			}
	 		
	 			
	 		}
	 	
	 	
	 	}
	 log.info("lets see here"+dataSets);
	 return dataSets;
	 
	}	
catch (Exception e){
	
	e.printStackTrace();
}
	return dataSets;
}
	
	public  String getCellData(String sheetName,String colName, int rowNum){
		try{
		int col_Num = 0;
		int index =workbook.getSheetIndex(sheetName);
		
		sheet = workbook.getSheetAt(index);
		System.out.println("6666666"+sheet);
		XSSFRow row = sheet.getRow(0);
		System.out.println("777777"+row);	
		for (int i=0 ;i<row.getLastCellNum();i++){ 
				if (row.getCell(i).getStringCellValue().equals(colName)){
					System.out.println("0000000000000000000000000"+row.getCell(i).getStringCellValue() +"and"+colName);
					//col_Num =1 ;
					col_Num = i ;
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
	
	public static void updateResult(String excelLocation,String sheetName,String testCaseName,String actualResult/*,String testStatus*/)
	throws Exception 
	
	{
		try{
			FileInputStream file = new FileInputStream(new File(excelLocation)); 
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			System.out.println("6666"+workbook);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println("7777"+sheet);
		    int totalRow = sheet.getLastRowNum()+1 ;
		    for (int i=1 ;i<totalRow;i++){
		    	XSSFRow r = sheet.getRow(i);
		    	String ce = r.getCell(1).getStringCellValue();
		    	if(ce.contains(testCaseName)){
		    		r.createCell(3).setCellValue(actualResult);
		    		file.close();
		    		System.out.println("result updated");
		    		FileOutputStream outFile = new FileOutputStream (new File (excelLocation));
		    		workbook.write(outFile);
		    		outFile.close();
		    		break ;
		    	}
		    }
		}
		catch (Exception e){
			}
		}
	public static void updateTestStatus(String excelLocation,String sheetName,String testCaseName/*,String expectedResult*/,String testStatus)
			throws Exception 
			
			{
				try{
					FileInputStream file = new FileInputStream(new File(excelLocation)); 
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					System.out.println("6666"+workbook);
					XSSFSheet sheet = workbook.getSheet(sheetName);
					System.out.println("7777"+sheet);
				    int totalRow = sheet.getLastRowNum()+1 ;
				    for (int i=1 ;i<totalRow;i++){
				    	XSSFRow r = sheet.getRow(i);
				    	String tc = r.getCell(1).getStringCellValue();
				    	String ce = r.getCell(2).getStringCellValue();
				    	String ec = r.getCell(3).getStringCellValue();
				    	if(tc.contains(testCaseName)){
				    		r.createCell(4).setCellValue(testStatus);
				    		file.close();
				    		System.out.println("result updated");
				    		FileOutputStream outFile = new FileOutputStream (new File (excelLocation));
				    		workbook.write(outFile);
				    		outFile.close();
				    		break ;
				    	}
				    	
				    }
				}
				catch (Exception e){
					}
				}







}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

	


