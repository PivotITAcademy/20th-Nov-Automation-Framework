package com.automationPractise.retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automationPractise.BasePackage.TestBase;

public class RetryFailedTestCases extends TestBase implements IRetryAnalyzer {

	
	int counter=1; // Intial value
	int maxCount=3; //maximum retry count
	
	@Override
	public boolean retry(ITestResult result) {
		
		logger.info("Trying failed Test Case " + counter +" times");
		
		if(counter<maxCount) {
			counter++;
			return true;
		}
		
		
		return false;
	}

}
