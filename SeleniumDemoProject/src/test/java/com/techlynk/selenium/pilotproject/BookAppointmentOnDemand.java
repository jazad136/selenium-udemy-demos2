package com.techlynk.selenium.pilotproject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BookAppointmentOnDemand extends TestBaseClass {
    
    
    @Test
    public void bookAppointmentTest() throws Exception { 
        driver.get(prop.getProperty("url"));
        waitForWebPageToLoad();
//        driver.findElement(By.id(prop.getProperty("OnDemandDoctor")));
        selectAppointmentDate();
//        driver.findElement(By.id("gotoAppointment_id")).click();
        dismissAlert();
//        driver.findElement(By.xpath(prop.getProperty("mobilenumber_xpath"))).sendKeys("5555555555");
//        driver.findElement(By.xpath(prop.getProperty("continue_xpath")));
        String nameTitle = prop.getProperty("nameTitle");
        String firstName = prop.getProperty("firstName");
        String lastName = prop.getProperty("lastName");
        String email = prop.getProperty("patient_email");
        String dob = prop.getProperty("dob");
        // Select title
        selectValueFromDropdown(driver.findElement(By.id(prop.getProperty("title_id"))), nameTitle);
        // Enter first name
        driver.findElement(By.id(prop.getProperty("firstName_id"))).sendKeys(firstName);
        // Enter last name
        driver.findElement(By.id(prop.getProperty("lastName_id"))).sendKeys(lastName);
        // Select DOB
        
    }
    
}
