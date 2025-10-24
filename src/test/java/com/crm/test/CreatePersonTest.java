package com.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.CreatePersonPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.PersonDetailsPage;
import com.crm.pages.PersonSummaryPage;
import com.crm.util.ExcelUtil;

public class CreatePersonTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    CreatePersonPage createPersonPage;
    PersonDetailsPage personDetailsPage;
    PersonSummaryPage personSummaryPage;

    public CreatePersonTest(){
        super();
    }

    @DataProvider
    public Object[][] getPersonData() {
        return ExcelUtil.getTestData("Persons");
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    
    @Test (dataProvider = "getPersonData")
    public void CreateNewPersonRecordTest(String fname, String lname){
        homePage.AddNewRecord();
        createPersonPage = homePage.ClickNewPersonLink();
        personDetailsPage =  createPersonPage.AddPersondetails(fname,lname);
        personSummaryPage = personDetailsPage.EnterPersonDetails();
        personSummaryPage.getTopContentPersonName();
    }

     @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
