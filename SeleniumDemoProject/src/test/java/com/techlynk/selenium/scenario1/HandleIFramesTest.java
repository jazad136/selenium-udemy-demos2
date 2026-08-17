/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario1;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
public class HandleIFramesTest
{
    WebDriver driver = null;

    /** Better idea, use a real test website */
    @Test
    public void handleIFrameTest() throws IOException {
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        // click checkboxradio button link
        driver.findElement(By.linkText("Checkboxradio")).click();
        Assert.assertEquals(driver.getTitle(), "Checkboxradio | jQuery UI");
        // Verify page heading
        String heading = driver.findElement(By.className("entry-title")).getText();
        Assert.assertEquals(heading, "Checkboxradio");
        
        // switch to iFrame before interacting with iFrame elements
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        
        // click radio button
        List<WebElement> radioBtns = driver.findElements(By.xpath("//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget ui-checkboxradio-radio-label']"));
        radioBtns.get(1).click();
        
        // switch back to main page
        driver.switchTo().parentFrame();
        // click the button
        driver.findElement(By.linkText("Button")).click();
        Assert.assertEquals(driver.getTitle(), "Button | jQuery UI");
//        Assert.assertEquals(driver.getTitle(), "Practice | Practice Test Automation");
//        driver.findElement(By.linkText("Test Table")).click();
//        Assert.assertEquals(driver.getTitle(), "Test Table | Practice Test Automation");
    }
    @BeforeMethod
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://jqueryui.com");
//        driver.get("https://practicetestautomation.com/practice/");
//        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    
    @AfterMethod
    public void finish() { 
        driver.quit();
    }
}
