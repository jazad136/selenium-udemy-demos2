/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;

/**
 *
 * @author JonathanSaddler
 */
public class TestBase {
    WebDriver driver;
    String testName;
    String testUrl;
    @Factory(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderScenario1Tests")
    public TestBase(String testName) {
        this.testName = testName;
        this.testUrl = "https://jqueryui.com"; // default is jQueryUI.com
    }
    
    public void setTestUrl(String testUrl) { this.testUrl = testUrl; } 
    
    @BeforeMethod
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(testUrl);
    }
    
    @AfterMethod
    public void finish() { 
        driver.quit();
    }

}
