package com.techlynk.selenium.test.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SeleniumMultipleBrowsers  {
    public void openInChrome() throws InterruptedException { 
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chrome-win64/chrome.exe");
        WebDriver chromeDriver = new ChromeDriver();
        
        // Open FaceBook webpage
        chromeDriver.get("https://www.facebook.com/");
        
        // Verify the Title
        String title = chromeDriver.getTitle();
        
        Assert.assertEquals(title, "Facebook - log in or sign up");
        
        // Maximize Browser Window
        
        Thread.sleep(2000);
    }
    public void openInFirefox() throws InterruptedException { 
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/chrome-win64/chrome.exe");
        WebDriver chromeDriver = new FirefoxDriver();
        
        // Open FaceBook webpage
        chromeDriver.get("https://www.facebook.com/");
        
        // Verify the Title
        String title = chromeDriver.getTitle();
        
        Assert.assertEquals(title, "Facebook - log in or sign up");
        
        // Maximize Browser Window
        
        Thread.sleep(2000);
    }

}
