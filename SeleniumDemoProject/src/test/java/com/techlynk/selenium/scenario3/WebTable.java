package com.techlynk.selenium.scenario3;

import com.techlynk.selenium.scenario2.*;
import com.techlynk.selenium.test.provider.TestDataProvider;
import java.util.List;
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
public class WebTable extends SlowExTestBase {

    @Factory(dataProvider="dataProviderScenario3Tests", dataProviderClass = TestDataProvider.class)
    public WebTable(String testPrepend, int slowMoSeconds) { 
        super(testPrepend, slowMoSeconds);
        setTestUrl("file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-table/index.html");
    }
    
    @Test(dataProvider="dataProviderTable", dataProviderClass = TestDataProvider.class)
    public void webTableOperationsTest(
            int specificRowNum, int specificColumnNum, 
            int specificCellX, int specificCellY) { 
        i("Verifying we are on the jQuery UI home page");
        Assert.assertEquals(driver.getTitle(), "Test Table | Practice Test Automation");
        // Display number of rows
        
        i("******** Display Number of Rows ********");
        List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='courses_table']/tbody/tr"));
        i("Total Number of rows -- " + tableRows.size());
        
        i( "******** Display Number of Columns ********");
        List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='courses_table']/thead/tr/th"));
        i("Total Number of colums -- " + tableColumns.size());
        
        iFormat("******** Get Data of Specific Row (%d) ********", specificRowNum);
        List<WebElement> fifthRow = driver.findElements(By.xpath("//*[@id='courses_table']/tbody/tr[5]/td"));
        for(WebElement rowItem : fifthRow) { 
            iWait(0, rowItem.getText());
        }
        iFormat("******** Get Data of Specific Column (%d) ********", specificColumnNum);
        List<WebElement> column = driver.findElements(By.xpath("//*[@id='courses_table']/tbody/tr/td[1]"));
        for(WebElement colItem : column) { 
            iWait(0, colItem.getText());
        }
        
        iFormat("******** Get the Complete Data (for every row) ******** ");
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='courses_table']/tbody/tr"));
        String rowText = "";
        for(WebElement row : allRows) { 
            System.out.println(row.getText());
            rowText += (rowText.isEmpty() ? "" : "\n") + row.getText();
        }
        i(rowText);
        
        iFormat("******* Get Data from specific Cell (%d,%d) *******", specificCellX, specificCellY);
        String cellValue = driver.findElement(By.xpath("//*[@id='courses_table']/tbody/tr[%d]/td[%d]".formatted(specificCellX, specificCellY))).getText();
        i(cellValue);
    }
    
    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return TestDataProvider.getTestNameScenario3Suite(res.getMethod().getMethodName());
    }
}
