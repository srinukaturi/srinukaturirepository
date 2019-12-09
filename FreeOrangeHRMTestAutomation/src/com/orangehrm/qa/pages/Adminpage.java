package com.orangehrm.qa.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.utilities.Testutil;

public class Adminpage extends Testbase {
	
	
	String organizationnanme;
	String taxid; String registrationnumber; String phonenumber; String emailid; String addressstreet1; String addressstreet2; String city; String note; String state; String postalcode;
	Testutil testutil;
	boolean mybool;
	
	
	@FindBy(name="btnSaveGenInfo")
	WebElement btnedit;
	
	@FindBy(xpath="//iframe[@id='rightMenu']")
	public WebElement eleframe;
	
	@FindBy(xpath="//h2[contains(text(),'General Information')]")
	WebElement adminpagegridheader;
	
	@FindBy(xpath="//h2[contains(text(),'Employee Information')]")
	WebElement pimpagegridheader;
	
	@FindBy(xpath="//h2[contains(text(),'Leave Period')]")
	WebElement leavepagegridheader;
	
	@FindBy(xpath="//input[@name=\"organization[name]\"]")
	WebElement txtorganizationname;
	
	@FindBy(xpath="//input[@name=\"organization[taxId]\"]")
	WebElement txttaxid;
	
	@FindBy(xpath="//input[@name=\"organization[registraionNumber]\"]")
	WebElement txtregistrationid;
	
	@FindBy(xpath="//input[@name=\"organization[phone]\"]")
	WebElement txtphonenumber;
	
	@FindBy(xpath="//input[@name=\"organization[email]\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name=\"organization[street1]\"]")
	WebElement txtastreet1;
	
	@FindBy(xpath="//input[@name=\"organization[street2]\"]")
	WebElement txtastreet2;
	
	@FindBy(xpath="//input[@name=\"organization[city]\"]")
	WebElement txtcity;
	
	@FindBy(xpath="//textarea[@name=\"organization[note]\"]")
	WebElement txttextarea;
	
	@FindBy(xpath="//input[@name=\"organization[province]\"]")
	WebElement txtprovince;
	
	@FindBy(xpath="//input[@name=\"organization[zipCode]\"]")
	WebElement txtzipcode;
	
	
	public Adminpage() throws IOException
	{
		PageFactory.initElements(driver, this);
		testutil=new Testutil();
	}
	
	public boolean verifyorganizationnamefield()
	{
		testutil.swithchtoframemethod(eleframe);
		mybool=btnedit.isDisplayed();
		return mybool;
		
	}
	public boolean verifyadminpagegridheader()
	{
		testutil.swithchtoframemethod(eleframe);
		boolean mybool1= adminpagegridheader.isDisplayed();
		testutil.switchtodefaultcontent();
		return mybool1;
		
	}
	
	public String clickoneditlink()
	{
		testutil.swithchtoframemethod(eleframe);
		btnedit.click();
		String btneditchangetext=btnedit.getText();
		return btneditchangetext;
	}
	public boolean verifypimpagegridheader()
	{
		testutil.swithchtoframemethod(eleframe);
		boolean mybool2= pimpagegridheader.isDisplayed();
		testutil.switchtodefaultcontent();
		return mybool2;
		
	}
	
	public boolean verifyleavepagegridheader()
	{
		testutil.swithchtoframemethod(eleframe);
		boolean mybool3= leavepagegridheader.isDisplayed();
		testutil.switchtodefaultcontent();
		return mybool3;
	}
	
	
	@Parameters({"organizationnanme","taxid","registrationnumber","phonenumber","emailid","addressstreet1","addressstreet2","city","note","state","postalcode"})
	public void savegeneralinformation(String organizationnanme, String taxid, String registrationnumber, String phonenumber, String emailid, String addressstreet1, String addressstreet2, String city, String note, String state, String postalcode)
	
	{
		txtorganizationname.sendKeys(organizationnanme);
		txttaxid.sendKeys(taxid);
		txtregistrationid.sendKeys(registrationnumber);
		txtphonenumber.sendKeys(phonenumber);
		txtemail.sendKeys(emailid);
		txtastreet1.sendKeys(addressstreet1);
		txtastreet2.sendKeys(addressstreet2);
		txtcity.sendKeys(city);
		txttextarea.sendKeys(note);
		txtprovince.sendKeys(state);
		txtzipcode.sendKeys(postalcode);
		btnedit.click();
		
		
	}
	
	public void savegeneralinformationnew(String organizationnanme, String taxid, String registrationnumber, String phonenumber, String emailid, String addressstreet1, String addressstreet2, String city, String note, String state, String postalcode)
	{
		txtorganizationname.sendKeys(organizationnanme);
		txttaxid.sendKeys(taxid);
		txtregistrationid.sendKeys(registrationnumber);
		txtphonenumber.sendKeys(phonenumber);
		txtemail.sendKeys(emailid);
		txtastreet1.sendKeys(addressstreet1);
		txtastreet2.sendKeys(addressstreet2);
		txtcity.sendKeys(city);
		txttextarea.sendKeys(note);
		txtprovince.sendKeys(state);
		txtzipcode.sendKeys(postalcode);
		btnedit.click();
	}
	
	
	

}
