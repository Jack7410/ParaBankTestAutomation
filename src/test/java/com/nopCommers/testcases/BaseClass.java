package com.nopCommers.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameter;

public class BaseClass {
	WebDriver driver;
	
	
	@Parameter(names = "Browser")
	@BeforeTest
	public void setUp( @Optional("Chrome") String browser) {
		
	}
	
	
}
