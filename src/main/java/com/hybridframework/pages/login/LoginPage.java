package com.hybridframework.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.base.DriverManager;
import com.hybridframework.utils.BaseUtil;


public class LoginPage extends BaseUtil {

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;

    @FindBy(linkText = "Edit your account information")
    private WebElement accountEditLink;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isAccountEditLinkDisplayed() {
        return isDisplayed(accountEditLink);
    }

    public String getWarningMessage() {
        return getText(warningMessage);
    }
    
}
