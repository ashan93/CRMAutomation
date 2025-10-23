package com.crm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {
    //Page objects
    @FindBy(name = "EWARE_USERID")
    WebElement username;

    @FindBy(name = "PASSWORD")
    WebElement password;

    @FindBy(xpath = "//td[@class='Logonbutton' and contains(., 'Log On')]")
    WebElement loginBtn;

    @FindBy(className = "version-info")
    WebElement versionNo;

    //Initialize elements
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    //Actions
    public String verifyVersion(){
        return versionNo.getText();
    }
 
    public HomePage login(String uname, String pwd){
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();

        AlreadyLoggedOnPage alreadyLoggedOnPage = new AlreadyLoggedOnPage();

        try {
            System.out.println("AAA");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.className("Logonbutton"))
        ));
        System.out.println("BBB");
        // If one of those elements is visible, handle it
        if (alreadyLoggedOnPage.isDisplayed()) {
            return alreadyLoggedOnPage.takeOverSession();
        }
        } catch (TimeoutException e) {
        // no "already logged on" page appeared, continue as normal
        }
        return new HomePage();
    }

}
