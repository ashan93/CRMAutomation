package com.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.CreatePersonPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.PersonDetailsPage;

public class CreatePersonTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    CreatePersonPage createPersonPage;
    PersonDetailsPage personDetailsPage;

    public CreatePersonTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test
    public void CreateNewPersonRecordTest(){
        homePage.AddNewRecord();
        createPersonPage = homePage.ClickNewPersonLink();
        personDetailsPage =  createPersonPage.AddPersondetails("Russel","Brackett");
        personDetailsPage.EnterPersonDetails();

    }
     @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
