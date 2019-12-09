package com.orangehrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.Testbase;


public class Loginpage extends Testbase {
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	public Loginpage() throws IOException
	{
		PageFactory.initElements(driver, this);
		
	}

	public String validatepagetitle()
	{
		return driver.getTitle();
	}
	
	public Homepage login(String un, String pw) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		return new Homepage();
	}
	
	
	
}
