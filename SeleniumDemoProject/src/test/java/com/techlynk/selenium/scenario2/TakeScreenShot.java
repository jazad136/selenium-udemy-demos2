/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class TakeScreenShot extends ExTestBase {
   
    @Factory(dataProvider="dataProviderScenario2TestsNormalSpd", dataProviderClass = TestDataProvider.class)
    public TakeScreenShot(String testPrepend) {
        super(testPrepend);
        setTestUrl("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html");
    }
    @Test 
    public void capturePartialScreenShot() { 
        i("Verify Login Title appears");
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
        WebElement usernameField =  driver.findElement(By.id("username")); 
        WebElement form =  driver.findElement(By.id("form")); 
        usernameField.sendKeys("MyUsername");
        takeScreenshotOfSpecificArea(form);
        
        i("Find the footer section");
        WebElement footerSection = driver.findElement(By.tagName("footer"));
        takeScreenshotOfSpecificArea(footerSection);
        
        i("Find the header section");
        WebElement headerSection = driver.findElement(By.tagName("header"));
        takeScreenshotOfSpecificArea(headerSection);
    }
    
    // Capture Specific area of web page
    public void takeScreenshotOfSpecificArea(WebElement element) { 
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg;
        try { 
            fullImg = ImageIO.read(screenshot);
            Point point = element.getLocation();
            int elemWidth = element.getSize().getWidth();
            int elemHeight = element.getSize().getHeight();
            BufferedImage elemScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elemWidth, elemHeight);
            ImageIO.write(elemScreenshot, "png", screenshot);
            String filepath = "src/test/resources/Screenshots/" + generateFileName();
            FileUtils.copyFile(screenshot, new File(filepath));
        } catch(IOException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }
    public String generateFileName() { 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-sss");
        String date = dateFormat.format(new Date());
        String filename = date + ".png";
        return filename;
    }
    @Test
    public void captureScreenshot() throws IOException { 
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        takeScreenShot();
    }
    public void takeScreenShot() throws IOException { 
        String filepath = "src/test/resources/Screenshots/" + generateFileName();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(filepath));
    }
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
}
