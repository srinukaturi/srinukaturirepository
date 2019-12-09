package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.Loginpage;

public class Loginpagetest extends Testbase {
	Loginpage loginpage;
	Homepage homepage;

	public Loginpagetest() throws IOException {
		super();
		
	}
	
	@BeforeMethod()
	public void setup() throws IOException
	{
		initialilzation();
		loginpage=new Loginpage();
		homepage=new Homepage();
		
	}
	
	@Test(priority=1)
	public void loginpagetitletest()
	{
		String pagetitle=loginpage.validatepagetitle();
		Assert.assertEquals(pagetitle, "");
	}
	
	@Test(priority=2)
	public void logintest() throws IOException
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
