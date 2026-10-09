package com.parabank.testcases;

import java.io.File;
import java.io.FileInputStream;


import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.parabank.utilities.ReadProp;

public class BaseClass {
	
	
	WebDriver driver;
	ReadProp prop;
	
	
	Logger logger = LogManager.getLogger(BaseClass.class);
	
	
	@BeforeSuite
	void setUpData(){
		prop=new ReadProp();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			logger.info("Launching Chrome Browser");
			ChromeOptions opt=new ChromeOptions();	
			driver=new ChromeDriver(opt);
		}else if(browser.equalsIgnoreCase("Firefox")) {
			logger.info("Launching Firefox Browser");
			FirefoxOptions opt=new FirefoxOptions();
			driver=new FirefoxDriver(opt);	
		}else {
			logger.info("Launching Edge Browser");
			EdgeOptions opt=new EdgeOptions(); 
			driver=new EdgeDriver(opt);
		}
		
		
		logger.info("Maximizing the window and navigating to the URL");
		driver.manage().window().maximize();
		logger.info("Navigating to the URL: " + prop.getUrl());
		driver.navigate().to(prop.getUrl());
	}
	
	
	public void takeScreenshot(WebDriver driver,String methodName) {
		logger.info("Taking screenshot for the failed test case: " + methodName);
		try {
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
			
			File Sspath=new File(".//Screenshots/"+methodName+".png");
			
			FileUtils.copyFile(screenShot, Sspath); 
			logger.info("Screenshot taken successfully for the failed test case: " + methodName);
			logger.info("Screenshot saved at: " + Sspath.getAbsolutePath());
			
		}catch(Exception e) {
			System.out.println("Failed to take screenShot");
			logger.error("Failed to take screenshot");
			e.printStackTrace(); 
		}
		

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		logger.info("Closing the browser");
		if(driver!=null) {
			driver.quit();
		}
		logger.info("===================================================");
	}
	

	
	@AfterSuite
	void windUpData(){
		
	}
	
	
}
