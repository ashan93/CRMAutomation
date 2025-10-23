package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class CreatePersonPage extends TestBase {

    @FindBy(id = "pers_lastname")
    WebElement lastName;

    @FindBy(id= "pers_firstname")
    WebElement firstName;

    @FindBy(xpath = "//a[@id = 'Button_EnterIndividualDetails']")
    WebElement enterBtn;

    public CreatePersonPage(){
        PageFactory.initElements(driver, this);
    }

    public PersonDetailsPage AddPersondetails(String fname, String lname){
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        enterBtn.click();
        return new PersonDetailsPage();
    }

}
