package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.orangehrm.qa.utilities.Testutil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase() throws IOException
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Users/srkaturi/eclipse-workspace/FreeOrangeHRMTestAutomation/src/com/orangehrm/qa/config/config.properties");
			prop.load(fis);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static void initialilzation()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\srkaturi\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\srkaturi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Testutil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
			
	}

}
