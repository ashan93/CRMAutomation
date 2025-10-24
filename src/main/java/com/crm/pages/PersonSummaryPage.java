package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class PersonSummaryPage extends TestBase {

    @FindBy (xpath = "//a[@class = 'TOPHEADING']")
    WebElement topContentPersonName;

    public PersonSummaryPage(){
        PageFactory.initElements(driver, this);
    }

    public String getTopContentPersonName(){
        return topContentPersonName.getText();
    }
    
}
