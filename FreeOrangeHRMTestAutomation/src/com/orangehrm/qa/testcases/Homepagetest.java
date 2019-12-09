package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.Loginpage;
import com.orangehrm.qa.utilities.Testutil;

public class Homepagetest extends Testbase

{
	Loginpage loginpage;
	Homepage homepage;
	Testutil testutil;
	
	
	
	
	
	

	public Homepagetest() throws IOException 
	{
		super();
		
		
		// It will intialize the properties file
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialilzation();
		loginpage=new Loginpage();
		homepage=new Homepage();
		testutil=new Testutil();
		
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void verifyhomepage(ITestResult result) throws IOException
	{
		testutil.initilizeextentreportsclasscobjects("verifyhomepage");
		ExtentTest logger=testutil.reports.createTest("verifyhomepage");
		
		boolean adminpagegridheader=homepage.clickonadmintab();
		if(adminpagegridheader)
		{
		logger.log(Status.PASS, "Clicked on admin tab and navigated to admin page successfully");
		}
		else
		{
			 
		String screenshotpath=testutil.capturescreenshotmethod();
		logger.fail("Something went wrong while navigating to admin page", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		
		boolean pimpagegridheader=homepage.clickonpimtab();
		if(pimpagegridheader)
		{
		logger.log(Status.PASS, "Clicked on pim tab and navigated to pim page successfully");
		}
		else
		{
			String screenshotpath=testutil.capturescreenshotmethod();
		logger.fail("Something went wrong while navigating to pim page", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		boolean leavepagegridheader=homepage.clickonleavetab();
		if(leavepagegridheader)
		{
			
		logger.log(Status.PASS, "Clicked on leave tab and navigated to leave page successfully");
		}
		else
		{
			String screenshotpath=testutil.capturescreenshotmethod();
		logger.fail("Something went wrong while navigating to leave page", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		boolean bool=homepage.verifyhomepagelogo();
		if(bool)
		{
		logger.log(Status.PASS, "Logo for the homepage has been displayed successfully");
		}
		
		
		
		//testutil.reports.flush();
	}
	
	@Test
	public void verifyhomepagesecond()
	{
		//testutil.initilizeextentreportsclasscobjects();
		ExtentTest logger1=testutil.reports.createTest("verifyhomepagesecond");
		homepage.clickonTimetab();
		logger1.log(Status.PASS, "Clicked on time tab and navigated to time page successfully");
		homepage.clickonrecruitmenttab();
		logger1.log(Status.PASS, "Clicked on recruitment tab and navigated to recruitment page successfully");
		homepage.clickonperformancetab();
		logger1.log(Status.PASS, "Clicked on performance tab and navigated to performance page successfully");
		homepage.clickonhelptab();
		logger1.log(Status.PASS, "Clicked on help tab and navigated to help page successfully");
		
		//testutil.reports.flush();
		
		
	}
	
	 
	
	 
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
