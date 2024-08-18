package com.E2E_FrameWrok.utiities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.E2E_FrameWrok.testCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extent = Reporting.getReporterObjec();
	
	  public  void onTestStart(ITestResult result) {
		    // not implemented
		 test= extent.createTest(result.getMethod().getMethodName());
		  }

		
		  public  void onTestSuccess(ITestResult result) {
		    test.log(Status.PASS,"TEST PASSED");
		    String Filepath = "";
	          
	         WebDriver driver=null;
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
				                      .get(result.getInstance());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	          try {
				 Filepath= getScreenShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  test.addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());
			    
			  
		  }

		  public void onTestFailure(ITestResult result){
          test.log(Status.FAIL, result.getThrowable());
          String Filepath = "";
          
         WebDriver driver=null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
			                      .get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          try {
			 Filepath= getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  test.addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());
		  
		  }

		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		  public void onFinish(ITestContext context) {
		   extent.flush();
		  }
	
}
