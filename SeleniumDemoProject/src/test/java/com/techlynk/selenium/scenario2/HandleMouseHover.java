/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class HandleMouseHover extends SlowExTestBase {
    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleMouseHover(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        // I'm ok opening this on my personal laptop
        setTestUrl("https://americangolf.eu");
    }
    
    @Test
    public void performMouseHoverTest() {
        i("Accepting cookies");
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[text()='Accept']"));
        acceptCookiesButton.click();
        i("Checking menu items...");
//        List<WebElement> menu = driver.findElements(By.xpath("//nav[@data-qa='ag-nav-header']/ul/li"));
//        List<WebElement> menu = nav.findElements(By.tagName("li"));
//        List<WebElement> menu = nav.findElements(By.xpath("//*[@class='ag-nav-header-link']"));
        List<WebElement> menu = driver.findElements(By.xpath("//li[@data-qa='ag-nav-header-link']"));
        int counter = 0;
        for(WebElement link : menu) { 
            iWait(0, "Link number : " + counter + " Menu Title : " + link.getText());
            counter++;
        }   
        iWait(5, "Done printing menu items. Moving to blue flag");
        
        // old: 
        // waterproof 
        // golf clubs 
        // golf clothing
        // golf shoes
        
        // new: 
        // blue flag
        WebElement blueFlag = menu.get(1);
        // clubs
        WebElement clubs = menu.get(2);
        // clothing
        WebElement clothing = menu.get(3);
        // shoes
        WebElement shoes = menu.get(4);
        
        i("Moving mouse along the menu items...");
        Actions action = new Actions(driver);
        action.moveToElement(blueFlag).build().perform();
        iWaitFormat(5,"Moved to %s. Moving to %s ... ", "blue flag", "clubs");
        action.moveToElement(clubs).build().perform();
        iWaitFormat(5,"Moved to %s. Moving to %s ... ", "clubs", "clothing");
        action.moveToElement(clothing).build().perform();
        iWaitFormat(5,"Moved to %s. Moving to %s ... ", "clothing", "shoes");
        action.moveToElement(shoes).build().perform();
        iWait(5,"Moved to shoes. Clicking on \"Men's Shoes\" link");
        WebElement mensShoesLink = driver.findElement(By.xpath("//*[@id=\"header-container\"]/div[2]/header/div[3]/nav/ul/li[5]/div/div/div/div/div[3]/ul/li[2]/a"));
        mensShoesLink.click();
        iWait(5, "Clicked the \"Men's Shoes\" link. Verifying Title is Men's Golf Shoes | Men's Golf Trainers | American Golf");
        Assert.assertEquals(driver.getTitle(), "Men's Golf Shoes | Men's Golf Trainers | American Golf");
        i("Title was verified.");
    }
        
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
    
}
