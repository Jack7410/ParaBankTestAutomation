package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageobject.RegisterUserPageObject;

public class RegisterUser extends BaseClass{
	
	RegisterUserPageObject reg;
	
	
	@Test(groups= {"Sanity,Regression"})
	void testRegisterUser(){
		logger.info("Starting register user test");
		reg=new RegisterUserPageObject(driver);

		reg.clickRegisterBtn();
		logger.info("Clicked on register user btn");
		Assert.assertEquals(driver.getTitle(), "ParaBank | Register for Free Online Account Access");
		logger.info("Verified page title for register user");
		reg.setFirstName(prop.getFirstName());
		logger.info("Entered first name as: "+prop.getFirstName());
		reg.setLastName(prop.getLastName());
		logger.info("Entered last name as: "+prop.getLastName());
		reg.setAddress(prop.getAddress());
		logger.info("Entered address as: "+prop.getAddress());
		reg.setCity(prop.getCity());
		logger.info("Entered city as: "+prop.getCity());
		reg.setState(prop.getState());
		logger.info("Entered state as: "+prop.getState());
		reg.setZipCode(prop.getZipCode());
		logger.info("Entered zipCode as: "+prop.getZipCode());
		reg.setPhoneNo(prop.getPhoneNo());
		logger.info("Entered phoneNo as: "+prop.getPhoneNo());
		reg.setSnn(prop.getSnn());
		logger.info("Entered Snn as: "+prop.getSnn());
		reg.setUserName(prop.getUserName());
		logger.info("Entered Username as: "+prop.getUserName());
		reg.setPass(prop.getUserPass());
		logger.info("Entered Userpass as: "+"*****");
		reg.confPass(prop.getUserPass());
		logger.info("Confirmed user pass: ");
		reg.registerBtn();
		logger.info("Clicked to register btn");
		
		if(reg.getRegistretionStatus().contains("Your account was created successfully.")) {
			logger.info(reg.getRegistretionStatus());
			System.out.println(reg.getRegistretionStatus());
		}else {
			logger.error(reg.getRegistretionStatus());
			System.out.println(reg.getRegistretionStatus());
		}
		
	}

}
