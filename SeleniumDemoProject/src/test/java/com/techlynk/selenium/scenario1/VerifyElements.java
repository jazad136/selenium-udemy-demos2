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
public class VerifyElements extends TestBase {

    public VerifyElements(String testName) { 
        super(testName);
    }
//    @Test
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
    @Test
    public void verifyElementEnabledTest() { 
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        // Click "Spinner" link
        driver.findElement(By.linkText("Spinner")).click();
        Assert.assertEquals(driver.getTitle(), "Spinner | jQuery UI");
        // Switch to frame
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        // find the spinner and disable button
        WebElement targetElement = driver.findElement(By.id("spinner"));
        WebElement disableBtn = driver.findElement(By.id("disable"));
        // Verify initial status
        Assert.assertTrue(targetElement.isEnabled());
        System.out.println("Element Initial Status :: isEnabled: " + targetElement.isEnabled());
        
        // click "Toggle disable/enable" button
        disableBtn.click();        
        // Verify element is disabled
        Assert.assertFalse(targetElement.isEnabled());
        System.out.println("Element Status, After 1st Click :: isEnabled: " + targetElement.isEnabled());
        
        // click "Toggle disable/enable" button
        disableBtn.click();        
        // Verify element is enabled
        Assert.assertTrue(targetElement.isEnabled());
        System.out.println("Element Status, After 2nd Click :: isEnabled: " + targetElement.isEnabled());
    }
}
