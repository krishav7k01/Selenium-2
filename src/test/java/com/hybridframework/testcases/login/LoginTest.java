package com.hybridframework.testcases.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.hybridframework.base.BaseTest;
import com.hybridframework.pages.home.HomePage;
import com.hybridframework.pages.login.LoginPage;
import com.hybridframework.utils.AssertionUtil;
import com.hybridframework.utils.FakeDataFactory;
import com.hybridframework.utils.TempDataStore;
import com.hybridframework.utils.getTestDataExcel;
import com.hybridframework.utils.reports.ExtentManager;

public class LoginTest extends BaseTest {

    
    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod
    // @BeforeMethod is used for setting up the page objects so that each test has its own clean, 
    //fresh, and isolated instance of the page objects. This helps maintain test independence, avoids shared states, 
    //and ensures that tests are reliable and easy to debug.
    public void initializePageObjects() {
        homePage = new HomePage();
        loginPage = new LoginPage();   
    }
    
    Faker faker = new Faker();

    @Test(dataProvider = "excelDataProvider", priority = 1)
    public void verifyLoginWithValidCredential(String username, String password, String expectedResult) {
        // Navigate to the login page
    	setMetadata("Karishiv", "Valid login scenario test for test Users", "TestValidLoginForTestUsers");
        homePage.clickMyAccountButton();
        homePage.clickLoginLink();

        // Enter credentials and submit
        loginPage.enterEmail(username);
        ExtentManager.logInfo("Entered Email Successfully");
        loginPage.enterPassword(password);
        ExtentManager.logInfo("Entered Email Password");
        loginPage.clickLoginButton();
        TempDataStore.set("registeredEmail", "krishavsharma@gmail.com");
        

        // Validate the result
        if (expectedResult.equalsIgnoreCase("Success")) {
            assert loginPage.isAccountEditLinkDisplayed() : "Login failed - Account edit link not displayed.";
        } else {
            String warningMessage = loginPage.getWarningMessage();
            AssertionUtil.hardAssertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.","Matched:Test Passes");      
        }
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredential() {
    	setMetadata("Karishiv", "Valid login With Wrong Email Id and Password", "TestInvalidUser&Pass");
        // Navigate to the login page
        homePage.clickMyAccountButton();
        homePage.clickLoginLink();
        System.out.print(TempDataStore.get("registeredEmail"));
        
        // Enter invalid credentials and submit
        loginPage.enterEmail(FakeDataFactory.getRandomEmail());
        loginPage.enterPassword(FakeDataFactory.getRandomPassword());
        loginPage.clickLoginButton();

        // Validate the invalid login warning message
        String warningMessage = loginPage.getWarningMessage();
        AssertionUtil.hardAssertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.","Matched:Test Passes");
    }
}
