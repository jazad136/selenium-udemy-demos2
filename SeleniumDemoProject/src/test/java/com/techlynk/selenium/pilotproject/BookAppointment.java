package com.techlynk.selenium.pilotproject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookAppointment extends TestBaseClass {
    
    @Test
    public void bookAppointment() throws Exception { 
        driver.get(prop.getProperty("url"));
        waitForWebPageToLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2)); 
        // Validate the presence and visibility of Preferred Visiting Field 1
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(prop.getProperty("calendarPreferDate1_id"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("caledarPreferDate1_id"))));
        // Select Preferred Visiting Date
        datePickerFromSlidingCalendar(prop.getProperty("appointment1_date"));
        Thread.sleep(8000);
        
        // Validate the presence and visibility of the Preferred Visiting Field 2
        // Select Preferred Visiting Date - Day after Tomorrow
        
        // Verify the Visibility of UHID
        Assert.assertFalse(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());
        
        // Check Yes Radio Button
        driver.findElement(By.id(prop.getProperty("radioBtnYes_id")));
        
        // Enter UHID
        driver.findElement(By.id(prop.getProperty("uhid_id")));
        // Check No Radio Button and check UHID
        Assert.assertFalse(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());
        
        // Click Yes, Verify UHID Field and Compare the existing UHID 
        driver.findElement(By.id(prop.getProperty("radioBtnYes_id")));
        Assert.assertTrue(driver.findElement(By.id(prop.getProperty("uhid_id"))).isDisplayed());
        String actualUHID = driver.findElement(By.id(prop.getProperty("uhid_id"))).getAttribute("value");
        String expectedUHID = prop.getProperty("uhid_id");
        Thread.sleep(5000);
        Assert.assertEquals(actualUHID, expectedUHID);
    }
}
