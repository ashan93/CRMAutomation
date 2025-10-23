package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

    }
    @Test(priority = 1)
    public void verifyHomeLogoTest(){
        Assert.assertTrue(homePage.isLogoDisplayed());
    }
    
    @Test(priority = 2)
    public void clickNewButtonTest(){
        homePage.AddNewRecord();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
