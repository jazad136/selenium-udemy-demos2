/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    @Test
    public void OpenSiteInChrome() { 
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chrome-win64/chrome.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.quit();
    }
    @Test
    public void OpenSiteInFirefox() { 
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/firefoxdriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.cnn.com");
        driver.quit();
    }
}
