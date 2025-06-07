package com.hybridframework.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.base.DriverManager;
import com.hybridframework.utils.BaseUtil;


public class HomePage extends BaseUtil {

    // Using @FindBy annotation to locate elements
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountButton;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    // Constructor to initialize the elements
    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickMyAccountButton() {
        click(myAccountButton);
    }

    public void clickLoginLink() {
        click(loginLink);
    }
}