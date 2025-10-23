package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.CreatePersonPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.PersonDetailsPage;
import com.crm.pages.PersonSummaryPage;

public class PersonSummaryTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;
    CreatePersonPage createPersonPage;
    PersonDetailsPage personDetailsPage;
    PersonSummaryPage personSummaryPage;

    public PersonSummaryTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        homePage.AddNewRecord();
        createPersonPage = homePage.ClickNewPersonLink();
        personDetailsPage = createPersonPage.AddPersondetails("Daniel", "Wright");
        personSummaryPage = personDetailsPage.EnterPersonDetails();

    }
    
    @Test(priority = 1)
    public void VerifyPersonTopContent(){
        Assert.assertEquals(personSummaryPage.getTopContentPersonName(), "Daniel Wright","Person name mismatch!");
    }

     @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
