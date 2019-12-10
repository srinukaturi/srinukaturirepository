package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.Adminpage;
import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.Loginpage;
import com.orangehrm.qa.utilities.Testutil;

public class Adminpagetest extends Testbase {
	
	boolean mybool1;
	public static String sheetname="Testdatasheet";
	
	
	
	Loginpage loginpage;
	Homepage homepage;
	Adminpage adminpage;
	Testutil testutil;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	public  String path="/Users/srkaturi/eclipse-workspace/FreeOrangeHRMTestAutomation/src/com/orangehrm/qa/testdata/sampletestdata.xlsx";
	
	

	public Adminpagetest() throws IOException 
	{
		super();
		reporter=new ExtentHtmlReporter("C:\\Users\\srkaturi\\eclipse-workspace\\FreeOrangeHRMTestAutomation\\src\\com\\orangehrm\\qa\\reports\\methodname.html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialilzation();
		loginpage=new Loginpage();
		homepage=new Homepage();
		adminpage=new Adminpage();
		testutil=new Testutil();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickonadmintab();
	}
	
	@Test(priority=1)
	public void verifyorganizationnamefieldtest()
	{
	    //testutil.initilizeextentreportsclasscobjects("verifyadminpage");
	    ExtentTest logger=reports.createTest("verifyorganizationnamefieldtest");
		mybool1=adminpage.verifyorganizationnamefield();
		if(mybool1)
		{
		 logger.log(Status.PASS, "Field Organization Name is displayed in Admin tab");	
		}
		else
		{
			logger.log(Status.FAIL, "Something went wrong while displaying Organization Name Filed");
		}
		
	}
	
	@Test(priority=2)
	@Parameters({"organizationnanme","taxid","registrationnumber","phonenumber","emailid","addressstreet1","addressstreet2","city","note","state","postalcode"})
	public void savegeneralinformationtest(String organizationnanme, String taxid, String registrationnumber, String phonenumber, String emailid, String addressstreet1, String addressstreet2, String city, String note, String state, String postalcode)
	{
	ExtentTest logger1=reports.createTest("Addingorganizationdetailstest");
	String btneditchangetext=adminpage.clickoneditlink();
	if(btneditchangetext.equalsIgnoreCase("Save"))
	{
		logger1.log(Status.PASS, "After click on edit button, button text has been changed to save successfully");
	}
	else
	{
		logger1.log(Status.FAIL, "Something went wrong while clicking on button edit");
	}
	adminpage.savegeneralinformation(organizationnanme, taxid, registrationnumber, phonenumber, emailid, addressstreet1, addressstreet2, city, note, state, postalcode);
	logger1.log(Status.PASS, "Organization details have been saved successfully");
	reports.flush();
	}
	
	@DataProvider
	public Object[][] savegeneralinformation() throws EncryptedDocumentException, IOException 
	{
		 Object mydata[][]=testutil.getexceldata(sheetname);
		 return mydata;
		
	}
	
	@Test(priority=3, dataProvider="savegeneralinformation")
	public void savegeneralinformationtestnew(String organizationnanme, String taxid, String registrationnumber, String phonenumber, String emailid, String addressstreet1, String addressstreet2, String city, String note, String state, String postalcode) throws IOException
	{
		
		adminpage.clickoneditlink();
		adminpage.savegeneralinformationnew(organizationnanme, taxid, registrationnumber, phonenumber, emailid, addressstreet1, addressstreet2, city, note, state, postalcode);
		
	}
	
	
	
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
	}*/
	
	
}
