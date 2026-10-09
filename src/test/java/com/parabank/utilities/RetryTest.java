package com.parabank.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
	
	
	private int maxCount=3;
	private int count=0;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxCount) {
			count++;
			System.out.println(
		            "Retrying test: "
		            + result.getMethod().getMethodName()
		            + " - Retry "
		            + count
		            + "/"
		            + maxCount
		        );
			return true;
		}
		
		return false;
	}

}


