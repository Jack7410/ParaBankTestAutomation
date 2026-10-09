package com.parabank.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.core.Filter.Result;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.parabank.testcases.BaseClass;

public class GenerateReports extends BaseClass implements ITestListener {
	
	ExtentHtmlReporter htmlReporter; 
	ExtentReports reports; 
	ExtentTest test;
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName()," Test Passed");
		test.log(Status.PASS, MarkupHelper.createLabel("Test Passed ", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName()," Test Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel("Test failed",ExtentColor.RED));

		String path = new File("Screenshots/" + result.getName() + ".png").getAbsolutePath();
		
			try {
				test.addScreenCaptureFromPath(path);
			}catch(Exception e) {
				System.out.println("Screenshot not found");
				e.printStackTrace();
			}
		}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName()," Test Skipped");
		test.log(Status.SKIP, MarkupHelper.createLabel(" Test skipped", ExtentColor.ORANGE));
	}

	@Override
	public void onStart(ITestContext context) {
		String dateTime=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		String reportName="Reports/"+dateTime+".html";
		File htmlReport=new File(reportName);
		
		htmlReporter=new ExtentHtmlReporter(htmlReport);
		htmlReporter.config().setDocumentTitle("ParaBankAutomation");
		htmlReporter.config().setReportName(context.getName());
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("TesterId", "TS1001");
		reports.setSystemInfo("TesterName", "Jack");
		reports.setSystemInfo("TestEnv", "SIT");
		reports.setSystemInfo("ReportGeneration dateTime", dateTime);
		reports.setSystemInfo("OS", "Windows 11");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
	

}
