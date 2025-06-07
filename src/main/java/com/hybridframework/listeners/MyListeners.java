package com.hybridframework.listeners;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hybridframework.base.DriverManager;
import com.hybridframework.utils.ScreenshotUtil;
import com.hybridframework.utils.reports.ExtentManager;

public class MyListeners implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(MyListeners.class);

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.startReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        logger.info("Test started: {}", methodName);

        ExtentManager.startTestCase(className);
        ExtentManager.setNode(methodName, className);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test passed");

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String path = ScreenshotUtil.captureScreenshot(driver, ExtentManager.getTestName());
            ExtentManager.getTest().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: {}", result.getMethod().getMethodName(), result.getThrowable());
        ExtentManager.getTest().fail(result.getThrowable());

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String path = ScreenshotUtil.captureScreenshot(driver, ExtentManager.getTestName());
            ExtentManager.getTest().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: {}", result.getMethod().getMethodName());
        ExtentManager.getTest().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }
}
