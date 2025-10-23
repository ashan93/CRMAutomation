package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{

    @FindBy (id = "Home")
    WebElement homeLogo;

    @FindBy (id= "new-list")
    WebElement addNew;

    @FindBy (xpath = "//span[text()='New Person']")
    WebElement newPersonLink;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoDisplayed(){
        return homeLogo.isDisplayed();
    }

    public void AddNewRecord(){
        addNew.click();
    }

    public CreatePersonPage ClickNewPersonLink(){
        newPersonLink.click();
        return new CreatePersonPage();
    }



}
