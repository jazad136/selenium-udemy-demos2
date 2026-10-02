package com.techlynk.selenium.pilotproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookAppointmentOnDemand extends TestBaseClass {
    
    @Test
    public void selectAppointmentDate() { 
//        String displayDate = driver.findElement(By.className(prop.getProperty("displayDate_class"))).getText();
        driver.get("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-alertcal/index.html");
        String displayDate = driver.findElement(By.id(prop.getProperty("displayDate_id"))).getText();
        System.err.println("Display Date : " + displayDate);
        
        // Add 4 days ahead date in displayDate
        addInDisplayDate(displayDate);
    }
    
    public void addInDisplayDate(String displayDate) { 
//                                                     3 letters of date
//                                                              day     
//                                                           3 letters of month
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(displayDate));
            // Add 4 days
            calendar.add(Calendar.MONTH, 2);
            SimpleDateFormat dateFormatNew = new SimpleDateFormat("d");
            String newDate = dateFormat.format(calendar.getTime());
            System.out.println("New Date : " + newDate);
        } 
        catch(ParseException e) {
            e.printStackTrace(); 
        }
        
        
    }
    
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
