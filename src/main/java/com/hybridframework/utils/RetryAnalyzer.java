package com.hybridframework.utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.hybridframework.utils.reports.ExtentManager;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	
	private int retryCount = 0;
    private final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        Throwable cause = result.getThrowable();

        if (cause instanceof StaleElementReferenceException ||
            cause instanceof ElementClickInterceptedException) {

            if (retryCount < maxRetryCount) {
                retryCount++;

                // Log to ExtentReports
                ExtentTest test = ExtentManager.getTest();
                if (test != null) {
                    test.warning("Retrying test '" + result.getMethod().getMethodName() +
                                 "' due to exception: " + cause.getClass().getSimpleName() +
                                 " (Retry " + retryCount + "/" + maxRetryCount + ")");
                }

                return true;
            }
        }

        return false;
    }
	

}
