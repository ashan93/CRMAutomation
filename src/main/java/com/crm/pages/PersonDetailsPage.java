package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class PersonDetailsPage extends TestBase {

    @FindBy (name = "pers_salutation")
    WebElement salutation;

    @FindBy (name = "pers_firstname")
    WebElement firstName;

    @FindBy (name = "pers_lastname")
    WebElement lastName;

    @FindBy (name = "pers_secterr")
    WebElement site;

    @FindBy (id = "SearchSmallAdvaddr_enaaddressmappingIMG")
    WebElement stateLkp;
    
    @FindBy(xpath = "//td[@class='ui-crmPopup-trigger' and normalize-space(text())='AARONS PASS']")
    WebElement state;

    @FindBy(id = "Button_Save")
    WebElement saveBtn;

    public PersonDetailsPage(){
        PageFactory.initElements(driver, this);
    }

    public PersonSummaryPage EnterPersonDetails(){
        
        Select sal = new Select(salutation);
        sal.selectByVisibleText("Mr");

        Select st = new Select(site);
        st.selectByValue("-1923641717");

        stateLkp.click();
        state.click();
        saveBtn.click();

        return new PersonSummaryPage();

    }

}
