package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class AlreadyLoggedOnPage extends TestBase{

    @FindBy(id = "LB") 
    WebElement continueButton;

    @FindBy(xpath = "//div[@id='LOGONBUTTON']") 
    WebElement loginMsg;

    public AlreadyLoggedOnPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return loginMsg.isDisplayed();
    }

    public HomePage takeOverSession() {
        continueButton.click();
        return new HomePage();
    }

}
