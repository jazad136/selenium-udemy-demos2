/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class HandleRadioButton extends SlowExTestBase {

    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleRadioButton(String testName, int slowMoSeconds) {
        super(testName, slowMoSeconds);
        setTestUrl("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-table/index.html");
    }

    @Test
    public void verifyRadioButton() {
        Assert.assertEquals(driver.getTitle(), "Test Table | Practice Test Automation");
        // no need to click create account button
        List<WebElement> radioButtons = driver.findElements(By.name("sex"));
        i("Get information on all the radio buttons");
        for(WebElement button : radioButtons) 
            iWait(0, "Is radio button selected : " + button.isSelected());
        i("Click one radio button");
        radioButtons.get(1).click();
        
        for(WebElement button : radioButtons) 
            iWait(0, "Is radio button selected : " + button.isSelected());
    }
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
}
