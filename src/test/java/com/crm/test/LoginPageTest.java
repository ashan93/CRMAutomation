package com.crm.test;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }

    /*@Test(priority = 1)
    public void versionNoTest(){
        String version = loginPage.verifyVersion();
        System.out.println(version);
        Assert.assertEquals(version, "Version 6.2.0.27384","Version no mismatched");
    }*/

    @Test(priority = 1)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
