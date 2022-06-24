package com.crm.comcast.genericutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ItestListenerImplmnt implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		test=report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
	    try {
	    	String screenShotName=WebDriverUtility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
	    	test.addScreenCaptureFromPath(screenShotName);
	    	} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		String testName = result.getMethod().getMethodName();
//		System.out.println(testName+"====Executing====");
//		
//		EventFiringWebDriver edrDriver = new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edrDriver.getScreenshotAs(OutputType.FILE);
//		
//		try {
//			FileUtils.copyFile(src, new File("./screenshots/"+testName+".PNG"));
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}

	public void onTestSkipped(ITestResult result) {


		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent Reports/report.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("sanjay's document");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Lohith");
		report.setSystemInfo("ReviwedBy", "Deepak");
		report.setSystemInfo("platform", "windows7");
		report.setSystemInfo("ServerName","ApacheTomcat");
		
	}

	public void onFinish(ITestContext context) {


		report.flush();
		
	}

}
