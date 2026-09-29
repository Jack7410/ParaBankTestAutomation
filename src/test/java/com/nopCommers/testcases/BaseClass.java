package com.nopCommers.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameter;
import com.nopCommers.utilities.ReadProp;

public class BaseClass {
	WebDriver driver;
	ReadProp prop;
	
	@Parameter(names = "Browser")
	@BeforeTest
	public void setUp( @Optional("Chrome") String browser) {
		if(browser.equalsIgnoreCase(browser)) {
			ChromeOptions opt=new ChromeOptions();	
			driver=new ChromeDriver(opt);
		}else if(browser.equalsIgnoreCase(browser)) {
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
	
	
}
