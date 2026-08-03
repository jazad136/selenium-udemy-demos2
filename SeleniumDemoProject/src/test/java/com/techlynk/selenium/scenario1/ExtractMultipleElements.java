/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario1;

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
public class ExtractMultipleElements {
    WebDriver driver = null;

    /** Better idea, use an actual test website */
    @Test
    public void findNumberOfLinksOnWebPageTest() { 
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links :: " + allLinks.size());
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
