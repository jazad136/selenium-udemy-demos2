/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario3;

import com.techlynk.selenium.test.provider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FileUpload extends SlowExTestBase{
    @Factory(dataProvider="dataProviderScenario3Tests", dataProviderClass = TestDataProvider.class)
    public FileUpload(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        setTestUrl("https://the-internet.herokuapp.com/upload");
    }
    
    @Test
    public void uploadFileTest() { 
        Assert.assertEquals(driver.getTitle(), "The Internet");
        String fileName = "C:\\Users\\JonathanSaddler\\Documents\\Learning\\Testing\\2026July23_5 Star Review - TechLynk_SelAutoTesting_wJava+AI Course.txt";
        
        i("Upload a file");
        WebElement fileUploadBtn = driver.findElement(By.id("file-upload"));
        fileUploadBtn.sendKeys(fileName);
        
        i("Added uploaded file to \'file\' web element. Clicking File Submit button...");
        WebElement fileSubmitBtn = driver.findElement(By.id("file-submit"));
        fileSubmitBtn.click();
        
        i("Verify that file confirmation shows");
        WebElement fileConfirmation = driver.findElement(By.className("example"));
        Assert.assertEquals(fileConfirmation.getText(), "File Uploaded!");
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario3Suite(res.getMethod().getMethodName());
    }
}
