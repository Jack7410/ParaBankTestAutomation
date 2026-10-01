package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageobject.LoginPageObject;

public class LoginTest extends BaseClass {
	
	
	LoginPageObject login;
	@Test
	void userLogin() {
		logger.info("Starting Login Test");
		login=new LoginPageObject(driver);
		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
		login.setUserName(prop.getUserName());
		logger.info("Entering Username: " + prop.getUserName());
		login.setUserPass(prop.getUserPass());
		//this password should be encrypted in the future, but for now, we are using plain text for testing purposes
		logger.info("Entering Password: " + "**********************");
		login.clickLoginBtn();
		logger.info("Clicking on Login Button");
	}

}
