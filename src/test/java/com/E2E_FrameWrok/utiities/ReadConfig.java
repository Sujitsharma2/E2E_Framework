package com.E2E_FrameWrok.utiities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public FileInputStream fis ;
	public File file ;
	public Properties prop ;
	
	public ReadConfig() {
	
       file = new File ("./Configuration/config.properties");
	try {
		 fis = new FileInputStream(file);
		 prop = new Properties();
		try {
			prop.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
	public String GetURL() {
		return(prop.getProperty("URL"));
	}
	
	public String getUsername() {
		return(prop.getProperty("username"));
	}
	
	public String getPassword() {
		return(prop.getProperty("password"));
	}
	
	public String getExcelPath() {
		
		return(prop.getProperty("ExcelPath"));
	}
	
	public String getSheetName() {
		return(prop.getProperty("sheetName"));
	}
	
}
