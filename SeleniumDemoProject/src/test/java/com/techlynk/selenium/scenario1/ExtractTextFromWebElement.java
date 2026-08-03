package com.techlynk.selenium.scenario1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Source code for ExtractTextFromWebElement class
 * @author JonathanSaddler
 */
public class ExtractTextFromWebElement {
    WebDriver driver = null;

    /** Better idea, use a real test website */
    @Test
    public void extractTextFromWebsite() { 
        WebElement heading = driver.findElement(By.tagName("h2"));
//        WebElement link = driver.findElement(By.xpath("//a[contains(@class,'x1i10hfl xjbqb8w x1ejq31n x18oe1m7 x1sy0etr xstzfhl x972fbf x10w94by x1qhh985 x14e42zd x9f619 x1ypdohk xt0psk2 x3ct3a4 xdj266r x14z9mp xat24cr x1lziwak xexx8yu xyri2b x18d9i69 x1c1uobl x16tdsg8 xggy1nq x1a2a7pz x1lku1pv xi81zsa xo1l8bm')]"));
        WebElement link = driver.findElement(By.xpath("//li[@id='menu-item-20']/a"));
        String headingText = heading.getText();
        String linkText = link.getText();
        Assert.assertEquals(headingText, "Test login"); // Test login
        Assert.assertEquals(linkText, "PRACTICE"); // PRACTICE
    }
    @BeforeMethod
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    
    @AfterMethod
    public void finish() { 
        driver.quit();
    }
}
