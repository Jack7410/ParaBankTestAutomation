package com.parabank.testcases;

import org.testng.annotations.Test;

public class MakePayment extends BaseClass{
	
	@Test(dependsOnMethods = "com.parabank.testcases.LoginTest.userLogin")
	void makePay() {
		System.out.print(driver.getTitle());
	}

}
