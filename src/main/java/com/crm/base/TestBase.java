package com.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        try {
            prop= new Properties();
            FileInputStream fi = new FileInputStream("/Users/ashanhettiarachchi/JavaSelenium/seleniumautomation/src/main/java/com/crm/config/config.properties");
            prop.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browsername = prop.getProperty("browser");
        if(browsername.equals("chrome")){
         System.setProperty("webdriver.chrome.driver", "/Users/ashanhettiarachchi/chromedriver-mac-x64/chromedriver");
         driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
     }
}

