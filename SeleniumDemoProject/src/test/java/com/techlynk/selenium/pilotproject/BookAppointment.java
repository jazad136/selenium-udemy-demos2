package com.techlynk.selenium.pilotproject;

import java.text.SimpleDateFormat;
import org.testng.annotations.Test;

public class BookAppointment extends TestBaseClass {
    
    @Test
    public void bookAppointment() throws Exception { 
        driver.get(prop.getProperty("url"));
        waitForWebPageToLoad();
    }
}
