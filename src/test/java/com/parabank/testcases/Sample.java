package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.utilities.RetryTest;

public class Sample {
	
	
	@Test(retryAnalyzer = RetryTest.class)
	void sampleTest() {
		Assert.assertTrue(false);
	}
}
