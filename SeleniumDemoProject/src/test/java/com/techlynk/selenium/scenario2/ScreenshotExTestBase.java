package com.techlynk.selenium.scenario2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.techlynk.selenium.config.ExtentReportManager;
import com.techlynk.selenium.test.provider.TestDataProvider;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author JonathanSaddler
 */
public abstract class ScreenshotExTestBase extends ExTestBase{
 
    public ScreenshotExTestBase(String testPrepend) {
        super(testPrepend);
    }
    
    
}
