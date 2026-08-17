/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class HandleMultipleTabs extends SlowExTestBase {
    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleMultipleTabs(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        setTestUrl("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html");
    }

    @Test
    public void getMultipleWindowHandleTest() { 
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
//        WebElement coursesLink = driver.findElement(By.linkText("Courses"));
        WebElement forgot = driver.findElement(By.id("forgot"));
        i("click link which opens in different browser tab");
        forgot.click();
        
        WebElement identifyEmail = driver.findElement(By.id("username"));
        identifyEmail.sendKeys("testemail123@gmail.com");
        
        
        // Browser Window GUID
        String mainPageID = driver.getWindowHandle();
        Set<String> windowIds = driver.getWindowHandles();
        iFormat("Main Page Window ID : %s", mainPageID);
        
        i("Click \"Forgot Password\" Link");
        driver.findElement(By.id("forgot")).click();
        
        i("Wait to find new window...");
        Iterator<String> itr = windowIds.iterator();
        String homePageId = itr.next();
        String newOpenPageId = itr.next();
        
        driver.switchTo().window(newOpenPageId);

        i("Find banner");
        Assert.assertEquals(driver.getTitle(), "Test Forgot Password | Practice Test Automation");
        String bannerText = driver.findElement(By.className("banner-class")).getText();
        iFormat("bannerText: %s", bannerText);
        
        driver.close();
        i("Closed new window");
        
        driver.switchTo().window(homePageId);
        
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
        driver.findElement(By.id("username")).sendKeys("testemail123@gmail.com");
        i("Entered username in old window.");
    }
    @Test
    public void getWindowIDTest() { 
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
        WebElement coursesLink = driver.findElement(By.linkText("Courses"));
        i("click link which opens in same browser tab");
        coursesLink.click();
        
        // Browser Window GUID
        String mainPageID = driver.getWindowHandle();
        iFormat("Main Page Window ID : %s", mainPageID);
        
        WebElement identifyEmail = driver.findElement(By.id("identify_email"));
        identifyEmail.sendKeys("testemail123@gmail.com");
        
        String forgotPasswordPageID = driver.getWindowHandle();
        iFormat("Forgotten Password Page Window ID : %s", forgotPasswordPageID);
        
    }
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
    
}
