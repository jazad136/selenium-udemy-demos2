package com.techlynk.selenium.pilotproject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookAppointmentOnDemand extends TestBaseClass {
    
    @Test
    public void bookAppointmentTest() throws Exception { 
        // Open Webpage
        driver.get(prop.getProperty("url"));
        waitForWebPageToLoad();
        
        // Open Doctor Appointment Page
        driver.findElement(By.linkText(prop.getProperty("OnDemandDoctor"))).click();
        // Handle New Tab Windows
        
        Set<String > windowIds = driver.getWindowHandles();
        Iterator<String> itr = windowIds.iterator();
        String homePageID = itr.next();
        String bookAppointmentPageID = itr.next();
        
        driver.switchTo().window(bookAppointmentPageID);
        
        Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("doctorverification_xpath"))).getText(), prop.getProperty("OnDemandDoctor"));
    }
    
}
