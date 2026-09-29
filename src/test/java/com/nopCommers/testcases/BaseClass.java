package com.nopCommers.testcases;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.nopCommers.utilities.ReadProp;

public class BaseClass {
	WebDriver driver;
	ReadProp prop;
	
	@Parameters("Browser")
	@BeforeTest
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions opt=new ChromeOptions();	
			driver=new ChromeDriver(opt);
		}else if(browser.equalsIgnoreCase("Firefox")) {
			FirefoxOptions opt=new FirefoxOptions();
			driver=new FirefoxDriver(opt);	
		}else {
			EdgeOptions opt=new EdgeOptions(); 
			driver=new EdgeDriver();
		}
		
		prop=new ReadProp();
		driver.manage().window().maximize();
		driver.navigate().to(prop.getUrl());
	}
	
	
	// @AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	public void takeScreenshot(WebDriver driver,String methodName) {
		
		try {
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileInputStream SsPath=new FileInputStream(".//Screenshots/"+methodName+".png");
			FileUtils.copyFile(screenShot, screenShot);
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		

	}
	
	
}
