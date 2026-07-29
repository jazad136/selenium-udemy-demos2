/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.example.selenium.test.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class InvokeDynamicBrowser {
    public WebDriver driver = null;
    private String yahooTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports &amp; Videos";
    private String mavenTitle = "Maven Repository: Search/Browse/Explore";
    private String seleniumTitle = "Selenium";
    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) {
        driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> new ChromeDriver();
        };
//        driver.manage().window().maximize();
    }
    
    @AfterMethod
    public void quitBrowser() { driver.quit(); }
    
    @Test
    public void verifySeleniumSite() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        Assert.assertEquals(title, seleniumTitle);
        Thread.sleep(3000);
    }
    
    @Test
    public void verifyMavenRepositorySite() throws InterruptedException {
        driver.get("https://www.mvnrepository.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, mavenTitle);
        Thread.sleep(3000);
    }
//    @Test
    public void verifyYahooSite() throws InterruptedException {
        driver.get("https://www.yahoo.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, yahooTitle);
        Thread.sleep(3000);
    }
}
