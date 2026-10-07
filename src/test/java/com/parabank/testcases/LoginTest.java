package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageobject.LoginPageObject;

public class LoginTest extends BaseClass {
	
	
	LoginPageObject login;
	@Test(groups = {"Sanity","Regression"})
	void userLogin() {
		logger.info("Starting Login Test");
		login=new LoginPageObject(driver);
		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
		login.setUserName(prop.getUserName());
		logger.info("Entering Username: " + prop.getUserName());
		login.setUserPass(prop.getUserPass());
		//this password should be encrypted in the future, but for now, we are using plain text for testing purposes
		logger.info("Entering Password: " + "*****");
		login.clickLoginBtn();
		logger.info("Clicking on Login Button");
		
		
		
		takeScreenshot(driver,"userLogin");
		//this assertion is for the validating if user logged in successfully if driver find logout btn it will return true
		if(login.loginStatus()) {
			logger.info("User logged in successfully");
		}else {
			logger.error("Invalid username or password");
			takeScreenshot(driver,"userLogin");
			Assert.assertTrue(false);
			
		}
		
		
		
	}

}
