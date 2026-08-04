/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario1;

import com.techlynk.example.selenium.seleniumproject.SeleniumProject;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SeleniumProject.class)
//public class FindBrokenLinksTests extends AbstractTestNGSpringContextTests
public class FindBrokenLinksTests
{
    WebDriver driver = null;

    /** Better idea, use a real test website */
    @Test
    public void findBrokenLinksTest() throws IOException {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of Links :: " + allLinks.size());
        
        // Click each link to verify link Status. 200 - Success, 404 - Broken Link
        for(WebElement link : allLinks) { 
            String linkURL = link.getAttribute("href");
            VerifyLinkStatus.verifyLink(linkURL);
        }
        System.out.println("Total Number of Invalid Links");
        VerifyLinkStatus.getInvalidLinkCount();
        
    }
    @BeforeMethod
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
}
