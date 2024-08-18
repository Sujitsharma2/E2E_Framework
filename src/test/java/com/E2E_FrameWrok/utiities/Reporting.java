package com.E2E_FrameWrok.utiities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {

	
	public static ExtentReports getReporterObjec() {
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("AUTOMATION REPORT");
	reporter.config().setDocumentTitle("Test Reselts");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("TESTER", "SUJIT SHARMA");
	return extent;
	}
}
