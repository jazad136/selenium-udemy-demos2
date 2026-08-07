/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class TakeScreenShot extends ExTestBase {
   
    @Factory(dataProvider="dataProviderScenario2TestsNormalSpd", dataProviderClass = TestDataProvider.class)
    public TakeScreenShot(String testPrepend) {
        super(testPrepend);
    }
    @Test
    public void captureScreenshot() throws IOException { 
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        takeScreenShot();
    }
    public void takeScreenShot() throws IOException { 
        String filepath = "src/test/resources/Screenshots/screenshot.png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(filepath));
    }
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
}
