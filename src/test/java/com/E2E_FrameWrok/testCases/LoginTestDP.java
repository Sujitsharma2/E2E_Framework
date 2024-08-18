package com.E2E_FrameWrok.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.E2E_FrameWrok.pageObjects.LoginPage;
import com.E2E_FrameWrok.utiities.ReadExcel;

public class LoginTestDP extends BaseClass {
	

	
	@DataProvider(name="TestDataP", parallel = true)
	 String[][] getData() throws IOException {
		int rowcount;
		int colcount;
		colcount=ReadExcel.getColCount(ExcelPath,sheetName);
		rowcount=ReadExcel.getRowCount(ExcelPath,sheetName);
		
		String loginData[][] = new String[rowcount][colcount];
		
		for(int i =1;i<rowcount;i++) {
			for(int j =0;j<colcount;j++ ) {
				loginData[i-1][j]=ReadExcel.getData(ExcelPath, sheetName, i, j);
			}
		}
	
		return loginData;
				
	}

	@Test(dataProvider="TestDataP")
	public void LoginDP(String userdp, String passworddp) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userdp);
		lp.setPassword(passworddp);
		Thread.sleep(3000);
		lp.clickSubmit();
		Thread.sleep(5000);
        
	
	}
	
	
	

}
