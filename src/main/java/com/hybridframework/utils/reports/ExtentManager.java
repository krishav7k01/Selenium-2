package com.hybridframework.utils.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static ConcurrentHashMap<String, ExtentTest> parentMap = new ConcurrentHashMap<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<String> testName = new ThreadLocal<>();

    public static void startReport() {
        String timestamp = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/" + timestamp;
        new File(reportPath).mkdirs();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath + "/TestResults.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Project Dashboard");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Author", "Automation Team");
    }

    // Create or get parent test for the given class name
    public static void startTestCase(String className) {
        parentMap.computeIfAbsent(className, cls -> extent.createTest(cls));
    }

    // Create a child node under the given class name
    public static void setNode(String methodName, String className) {
        ExtentTest parent = parentMap.get(className);
        if (parent != null) {
            ExtentTest child = parent.createNode(methodName);
            test.set(child);
            testName.set(methodName);
        }
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String getTestName() {
        return testName.get();
    }

    public static void logInfo(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            currentTest.info(message);
        }
    }

    public static void logPass(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            currentTest.pass(message);
        }
    }

    public static void assignTestMetadata(String author, String description, String testName) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            currentTest.assignAuthor(author);
            currentTest.assignCategory(description);
            currentTest.info("Starting test: " + testName);
        }
    }
}
