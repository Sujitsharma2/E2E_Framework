package com.E2E_FrameWrok.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.E2E_FrameWrok.utiities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
	public String URL;
	public String username;
	public String password;
	public String ExcelPath;
	public String sheetName;
	public static Logger logger;
	public String browserName;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		
		browserName=browser;

		logger =  Logger.getLogger("E2E_FrameWork");
		PropertyConfigurator.configure("log4j.properties");
			
		ReadConfig readconfig = new ReadConfig();
		URL=readconfig.GetURL();
		username =readconfig.getUsername();
		password =readconfig.getPassword();
		ExcelPath = readconfig.getExcelPath();
		sheetName= readconfig.getSheetName();
		
		
		
		if (browser.equalsIgnoreCase("Chrome")){
			
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")){
			
			driver =new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")){
			
			driver =new FirefoxDriver();
		}
		
		
		
	driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@AfterTest
		public void tearDown() {
		driver.quit();
	}
	


	public String getScreenShot(String testName,WebDriver driver) throws IOException {
	
		TakesScreenshot ts = (TakesScreenshot)(driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testName+".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testName+".png";
	
	}


}
