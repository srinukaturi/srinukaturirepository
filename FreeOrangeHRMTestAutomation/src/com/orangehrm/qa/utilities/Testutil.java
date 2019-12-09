package com.orangehrm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangehrm.qa.base.Testbase;

public class Testutil extends Testbase {
	
	
	public static Workbook workbook;
	public static Sheet sheet;
	public static long Page_Load_Timeout=20;
	public static long Implicit_Wait=30;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	public static String path="/Users/srkaturi/eclipse-workspace/FreeOrangeHRMTestAutomation/src/com/orangehrm/qa/testdata/sampletestdata.xlsx";
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
   
	
	public Testutil() throws IOException 
	{
	
	}
	
	public void initilizeextentreportsclasscobjects(String methodname)
	{
		reporter=new ExtentHtmlReporter("C:\\Users\\srkaturi\\eclipse-workspace\\FreeOrangeHRMTestAutomation\\src\\com\\orangehrm\\qa\\reports\\"+methodname+".html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
	}
	
	public void swithchtoframemethod(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public String capturescreenshotmethod() throws IOException
	{
		String dateandtime=LocalDateTime.now().toString();
		dateandtime=dateandtime.replaceAll("[^a-zA-Z0-9]", "");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\srkaturi\\eclipse-workspace\\FreeOrangeHRMTestAutomation\\src\\com\\orangehrm\\qa\\screenshots\\learnautomation"+dateandtime+".png";
		File destination=new File(path);
		org.openqa.selenium.io.FileHandler.copy(source, destination);
		return path;
	}
	public void switchtodefaultcontent()
	{
		driver.switchTo().defaultContent();
	}
	
	public void clickonelementusingjavascriptexecutor(WebElement element)
	{
		js.executeScript("arguments[0].click();", element);
	}
	
	public static Object[][] getexceldata(String sheetname) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(path);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
				
			
			
		
	}

	
	
	

}
