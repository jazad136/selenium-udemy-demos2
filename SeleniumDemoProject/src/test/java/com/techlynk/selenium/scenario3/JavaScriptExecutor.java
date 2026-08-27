/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario3;

import com.techlynk.selenium.test.provider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends SlowExTestBase{
    @Factory(dataProvider="dataProviderScenario3Tests", dataProviderClass = TestDataProvider.class)
    public JavaScriptExecutor(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        setTestUrl("");
        setOpenTestUrl(false);
    }
    
    @Test(dataProviderClass = TestDataProvider.class, 
            dataProvider = "dataProviderJavaScript")
    public void handleJSTest(int scrollY) { 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.practicetestautomation.com/practice-test-login/'");
        i("Verify page title...");
        String pageTitle = (String) js.executeScript("return document.title");
        Assert.assertEquals(pageTitle, "Test Login | Practice Test Automation");
        i("Perform click operation");
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", btnSubmit);
        i("Done clicking");
        i("Type text 'test@123' in text box");
        WebElement textBox = driver.findElement(By.id("username"));
        js.executeScript("arguments[0].value='test@123'", textBox);
//        iWait(0,"Done typing.");
        iFormat("Scroll %d pixel units down in the page", scrollY);
        js.executeScript("window.scrollBy(1,arguments[0])", scrollY);
        i("Scroll to fit the Privacy Policy element into the view");
        WebElement privacyPolicyBtn = driver.findElement(By.linkText("Privacy Policy"));
        Actions action = new Actions(driver);
        action.scrollToElement(privacyPolicyBtn).build().perform();
//        js.executeScript("arguments[0].scrollIntoView(true)", privacyPolicyBtn);
        i("Done scrolling. Clicking the element.");
        privacyPolicyBtn.click();
        softAssert.assertAll();
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario3Suite(res.getMethod().getMethodName());
    }
}
