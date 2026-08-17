package com.techlynk.selenium.scenario2;

import com.techlynk.selenium.test.provider.TestDataProvider;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class HandleDropdown extends SlowExTestBase {
    
    @Factory(dataProvider="dataProviderScenario2Tests", dataProviderClass = TestDataProvider.class)
    public HandleDropdown(String testName, int slowMoSeconds) {
        super(testName, slowMoSeconds);
        setTestUrl("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-table/index.html");
    }
    @Test
    public void dropDownMultiSelectTest() { 
        WebElement dropDown = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(dropDown);
        i("Verify isDropdown MultiSelect");
        Assert.assertTrue(multiSelect.isMultiple());
        i("Select any element");
        multiSelect.selectByValue("volvo");
        multiSelect.selectByValue("opel");
        
        i("Verify selected options");
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        for(WebElement option : selectedOptions)  
            iFormat("Selected values: %s", option.getText());
        
        i("Deselect all");
        multiSelect.deselectAll();
        
        i("Select again: saab");
        multiSelect.selectByValue("saab");
        i("Select again: audi");
        multiSelect.selectByValue("saab");
        i("Select first element");
        String value = multiSelect.getFirstSelectedOption().getText();
        iFormat("First Selected Text is : %s", value);
        
        multiSelect.deselectByVisibleText("Audi");
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
        
        List<WebElement> allOptions = dropdown.getOptions();
        for(WebElement option : allOptions) { 
            option.click();
            i("Option Selected : " + option.getText());
        }
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "DropdownTest";
    }
    
    
}
