package com.hybridframework.base;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.hybridframework.config.ConfigLoader;
import com.hybridframework.utils.BaseUtil;
import com.hybridframework.utils.TempDataStore;
import com.hybridframework.utils.getTestDataExcel;
import com.hybridframework.utils.reports.ExtentManager;



public class BaseTest{
	// BeforeMethod: Setup WebDriver and perform setup operations
	
	
    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        // Initialize the WebDriver 
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            
           //  Enable headless mode
  //          options.addArguments("--headless");
            options.addArguments("--no-sandbox"); // Ensure it runs in restricted mode
            options.addArguments("--disable-extensions"); // Disable browser extensions
            options.addArguments("--disable-notifications"); // Disable browser notifications
            options.addArguments("--ignore-certificate-errors"); // Ignore SSL certificate errors
            options.addArguments("--incognito"); // Open in incognito mode

            // Initialize ChromeDriver with options
            driver = new ChromeDriver(options);
            
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            
            // Enable headless mode
//            options.addArguments("-headless");
            options.addArguments("-private"); // Open in private/incognito mode
            options.addArguments("--disable-notifications"); // Disable notifications
            options.addArguments("--ignore-certificate-errors"); // Ignore SSL certificate errors

            // Initialize FirefoxDriver with options
            driver = new FirefoxDriver(options);
            
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        // Set the driver in the DriverManager
        DriverManager.setDriver(driver);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait globally 
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(BaseUtil.PAGE_LOAD_TIME));

        // Open the URL
        driver.get(ConfigLoader.getProperty("url"));
    }

    // AfterMethod
    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver after tests are finished
        DriverManager.getDriver().quit();
    }
    
    @AfterSuite
    public void cleanupData() {
        TempDataStore.clear(); // Delete the file after suite completes
    }
    
    public void setMetadata(String author, String description, String testName) {
        ExtentManager.assignTestMetadata(author, description, testName);
    }
    
    @DataProvider(name = "excelDataProvider")
    public Object[][] excelDataProvider(Method method) {
        String sheetName = method.getName();
        System.out.println("Loading data from sheet: " + sheetName);
        return getTestDataExcel.getTestData(ConfigLoader.getProperty("FILE_PATH"), sheetName);
    }
    

    
  
	

}
