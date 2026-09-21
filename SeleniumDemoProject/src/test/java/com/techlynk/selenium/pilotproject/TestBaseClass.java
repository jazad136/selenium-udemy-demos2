package com.techlynk.selenium.pilotproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

/**
 *
 * @author JonathanSaddler
 */
public class TestBaseClass {
    protected WebDriver driver = null;
    protected Properties prop = null;
    
    public void datePickerFromSlidingCalendar(String suppliedDate) { 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try { 
            Date dateYear = dateFormat.parse(suppliedDate);
            Date currentDate = new Date();
            driver.findElement(By.id(prop.getProperty("calendarPreferDate1_id"))).click();
            String year = new SimpleDateFormat("yyyy").format(dateYear);
            String month = new SimpleDateFormat("MMMM").format(dateYear);
            
            String appDate = month + " " + year;
            System.out.println("Supplied Calendar Month and Year : " + appDate);
            
            String monthYearDisplayed = driver.findElement(By.xpath(prop.getProperty("calendarPrederDate1Title_xpath"))).getText();
            System.err.println("Getting Calendar Month and Year : " + monthYearDisplayed);
            
            while(!appDate.equals(monthYearDisplayed)) { 
                if(dateYear.compareTo(currentDate) == 1)  
                    driver.findElement(By.xpath(prop.getProperty("backwardCalendarClick_xpath"))).click();
                else if(dateYear.compareTo(currentDate) == -1) 
                    driver.findElement(By.xpath(prop.getProperty("forwardCalendarClick_xpath"))).click();     
                monthYearDisplayed = driver.findElement(By.xpath(prop.getProperty("calendarPrederDate1Title_xpath"))).getText();
            }
        
            // Select Day
            String day = new SimpleDateFormat("d").format(dateYear);
            System.err.println("Supplied Date Day : " + day);
            WebElement calendarDay = driver.findElement(By.xpath("//a[text()='"+day+"']"));
            calendarDay.click();
        } 
        catch(ParseException e) { 
            e.printStackTrace();
        }
    }
    public void datePickerFromDropDownCalendar(String suppliedDate) { 
        SimpleDateFormat datFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dob_year = datFormat.parse(suppliedDate);
            driver.findElement(By.id(prop.getProperty("dobCalendar_id"))).click();
            
            // Select Year
            String year = new SimpleDateFormat("yyyy").format(dob_year);
            System.out.println("Supplied Date Year : " + year);
            WebElement calendarYear = driver.findElement(By.xpath(prop.getProperty("dobCalendarYear_xpath")));
            selectFromDropDown(calendarYear, year);
            // Select Month
            
            String month = new SimpleDateFormat("MMM").format(dob_year);
            System.out.println("Supplied Date Month : " + month);
            WebElement calendarMonth = driver.findElement(By.xpath(prop.getProperty("dobCalendarMonth_xpath")));
            selectFromDropDown(calendarMonth, month);
            
            // Select Day
            String day = new SimpleDateFormat("d").format(dob_year);
            System.out.println("Supplied Date Day : " + day);
            WebElement calendarDay = driver.findElement(By.xpath("//a[text()='"+day+"']"));
            calendarDay.click();
            
        } catch(ParseException e) { 
            e.printStackTrace();
        }
    }
    
    public static void selectFromDropDown(WebElement element, String selectable) { 
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(selectable);
    }
    public void init() { 
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        prop = new Properties();
        try(FileInputStream fis = new FileInputStream("src/main/resources/sakrahospital_bookAppointment.properties")) { 
            prop.load(fis);
        } catch(IOException e) {
//            throw new RuntimeException("Unexpected problem reading file sakrahospital_bookAppointment.properties file in src/main/resources");
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void finish() {
            driver.quit();
    }
    public void waitForWebPageToLoad() throws InterruptedException { 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int i = 0;
        while(i != 10) { 
            String state = (String) js.executeScript("return document.readyState;");
//            System.out.println(state);
            if(state.equals("complete"))
                break;
            else
                wait(2);
            i++;
        }
        i = 0; 
        while(i != 10) { 
            Long d = (Long) js.executeScript("return jQuery.active;");
            System.out.println(d);
            if(d.longValue() == 0)
                break;
            else
                wait(2);
            i++;
        }
    }
    public void wait(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
