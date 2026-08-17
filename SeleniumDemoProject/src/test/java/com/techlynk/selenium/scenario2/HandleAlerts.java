package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * @author JonathanSaddler
 */
public class HandleAlerts extends SlowExTestBase {

    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleAlerts(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        // I'm ok opening this on my personal laptop
        setTestUrl("https://rediff.com");
    }
    
    @Test
    public void handleAlertsTest() { 
//        Assert.assertEquals(driver.getTitle(), "Test Alerts | Practice Test Automation");
        Assert.assertEquals(driver.getTitle(), "Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");

        driver.findElement(By.linkText("Mail")).click();
        Assert.assertEquals(driver.getTitle(), "Rediffmail - Free Email for Login with Secure Access");

        WebElement usernameField = driver.findElement(By.id("login1"));
        usernameField.sendKeys("testemail123@gmail.com");
        i("Click sign in button");
        WebElement signInBtn = driver.findElement(By.className("signin-btn"));
        signInBtn.click();

        i("Verify the text is \"Please enter your password\"");
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter your password");

        iWait(5, "Clear the alert");
        alert.accept();
        i("Enter the password and clear the username text");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        usernameField.clear();
        
        i("Verify the text is \"Please enter a valid user name\"");
        signInBtn.click();
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(), "Please enter a valid user name");
        
        iWait(5, "Clear the alert");
        alert2.accept();
    }
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
    
}
