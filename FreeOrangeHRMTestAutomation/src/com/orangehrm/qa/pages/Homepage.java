package com.orangehrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.utilities.Testutil;

public class Homepage extends Testbase  {
	
	Adminpage adminpage;
	Testutil testutil;
	
	@FindBy(xpath="//span[contains(text(),'Admin')]")
	@CacheLookup
	WebElement tabadmin;
	
	
	@FindBy(xpath="//span[contains(text(),'PIM')]")
	@CacheLookup
	WebElement tabpim;
	
	
	@FindBy(xpath="//div[@id='companyLogoHeader']")
	@CacheLookup
	WebElement homepagelogo;
	
	
	@FindBy(xpath="//span[contains(text(),'Leave')]")
	@CacheLookup
	WebElement tableave;
	
	
	@FindBy(xpath="//span[contains(text(),'Time')]")
	@CacheLookup
	WebElement tabtime;
	
	
	@FindBy(xpath="//span[contains(text(),'Recruitment')]")
	@CacheLookup
	WebElement tabrecruitment;
	
	
	@FindBy(xpath="//span[contains(text(),'Performance')]")
	@CacheLookup
	WebElement tabperformance;
	
	
	@FindBy(xpath="//span[contains(text(),'Help')]")
	@CacheLookup
	WebElement tabhelp;

	
	
	

	public Homepage() throws IOException {
		
		PageFactory.initElements(driver, this);
		adminpage=new Adminpage();
		testutil=new Testutil();
		
		
	}
	
	//class methods
	public boolean clickonadmintab() throws IOException
	{
		tabadmin.click();
		return adminpage.verifyadminpagegridheader();
		
	}
	public boolean verifyhomepagelogo()
	{
		return homepagelogo.isDisplayed();
	}
	public boolean clickonpimtab()
	{
		
	    tabpim.click();
	    return adminpage.verifypimpagegridheader();
	    
	}
	public void clickonTimetab()
	{
		tabtime.click();
		
	}
	public void clickonrecruitmenttab()
	{
		tabrecruitment.click();
		
	}
	public void clickonperformancetab()
	{
		tabperformance.click();
		
	}
	public boolean clickonleavetab()
	{
		tableave.click();
		return adminpage.verifyleavepagegridheader();
	}
	public void clickonhelptab()
	{
		tabhelp.click();
		
	}

}
