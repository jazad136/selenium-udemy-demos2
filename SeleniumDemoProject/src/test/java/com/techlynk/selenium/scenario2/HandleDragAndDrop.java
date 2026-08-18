package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class HandleDragAndDrop extends SlowExTestBase {

    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleDragAndDrop(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        // I'm ok opening this on my personal laptop
        setTestUrl("https://jqueryui.com");
    }
    
    @Test(dataProvider = "dataProviderDraggable", dataProviderClass=TestDataProvider.class)
    public void draggableTest(int xOffset, int yOffset) { 
        driver.manage().window().maximize();
        i("Navigate to jQuery UI home page");
        Assert.assertEquals(driver.getTitle(), "jQuery UI");
        driver.findElement(By.linkText("Draggable")).click();
        
        i("Open Draggable page.");
        Assert.assertEquals(driver.getTitle(), "Draggable | jQuery UI");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        iFormat("Switch to demo-frame, Moving the draggable element to position (%d, %d)...", xOffset, yOffset);
        WebElement draggableEle = driver.findElement(By.id("draggable"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggableEle, xOffset, yOffset).build().perform();
        iWaitFormat(4, "Moved the element to position (%d, %d)", xOffset, yOffset);
    }
    
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario2Suite(res.getMethod().getMethodName());
    }
}
