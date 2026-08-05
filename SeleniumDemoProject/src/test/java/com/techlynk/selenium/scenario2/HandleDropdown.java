package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class HandleDropdown extends SlowExTestBase {
    
    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleDropdown(String testName, int slowMoSeconds) {
        super(testName, slowMoSeconds);
        setTestUrl("https://practicetestautomation.com/practice-test-table/");
    }
    
    @Test
    public void useDropDownTest() { 
        WebElement selSortBy = driver.findElement(By.id("sortBy"));
        Select dropdown = new Select(selSortBy);
        i("Selecting index 1: 'Course Name'");
        dropdown.selectByIndex(1);
        i("Selecting 'Language':");
        dropdown.selectByValue("col_lang");
        i("Selecting 'Enrollments':");
        dropdown.selectByVisibleText("Enrollments");
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "DropdownTest";
    }
}
