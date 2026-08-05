package com.techlynk.selenium.scenario1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class VerifyElements {
    WebDriver driver = null;

    @Test
    public void verifyElementDisplayedTest() throws IOException {
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        
        // Click on show link
        driver.findElement(By.linkText("Show")).click();
        Assert.assertEquals(driver.getTitle(), "Show | jQuery UI");
        // Switch to frame
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        // Verify WebElement is displayed
        WebElement elementToVerify = driver.findElement(By.xpath("//div[@id='effect']/h3"));
        Assert.assertFalse(elementToVerify.isDisplayed());
        System.out.println("Element initial state: " + elementToVerify.isDisplayed());
        // Click the button
        driver.findElement(By.id("button")).click();
        Assert.assertTrue(elementToVerify.isDisplayed());
        
    }
    @BeforeMethod
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://jqueryui.com");
    }
    
    @AfterMethod
    public void finish() { 
        driver.quit();
    }
}
