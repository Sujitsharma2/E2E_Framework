package com.E2E_FrameWrok.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.E2E_FrameWrok.pageObjects.HomePage;
import com.E2E_FrameWrok.pageObjects.LoginPage;

public class LoginReplicaTestTwo extends BaseClass{
	
	@Test (priority=0)
	public void loginTest() throws InterruptedException {
		logger.info("Entering Test Case 1");
	
		logger.info("Openingn URL");
		Thread.sleep(3000);
		LoginPage login = new LoginPage(driver);
		login.setUsername(username);
		logger.info("Entered Username"+username);
		login.setPassword(password);
		logger.info("Entered Password"+password);
		login.clickSubmit();
		logger.info("Clicked SUBMIT");
		
		
		
		logger.info("Exiting Test Case 1");
//		System.out.println(driver.getTitle());
	}
	

	@Test (priority=1, dependsOnMethods="loginTest")
	public void testtwo() {
		logger.info("Entering Test Case 2");
		System.out.println(driver.getTitle());
		logger.info("Entered Username");
		Assert.assertEquals("Logged In Successfully | Practice Test Automation",driver.getTitle());
		
		logger.info("Asserting Page Title");
	}
	
	
	@Test (priority=2 , dependsOnMethods="testtwo")
	public void testthree() {
		
		logger.info("Entering Test Case 3");
		logger.info("Performing Logout Operation");
		
		HomePage hp=new HomePage(driver);
		hp.clickLogoutButton(driver);
         
		logger.info("Logged Out");
		
		Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
        
		logger.info("Assertion Completed");
	
	
	}
	

	
	
}
