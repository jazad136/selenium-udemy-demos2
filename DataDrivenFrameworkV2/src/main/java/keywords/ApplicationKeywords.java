package keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author JonathanSaddler
 */
public class ApplicationKeywords extends ValidationKeywords {
    public static String propsFilename = "src/test/resources/Properties/Project.properties";
    public ApplicationKeywords() { 
        prop = new Properties();
        try(FileInputStream fis = new FileInputStream(propsFilename)) { 
            prop.load(fis);
        } catch(IOException e) {
            throw new RuntimeException("Unexpected problem reading file %s properties file".formatted(propsFilename));
        }
        softAssert = new SoftAssert();
    }
    public int findCurrentStockQuantity(String companyName) { 
        int rowNum = getRowNumWithCellData("stockTable_id", companyName);
        if(rowNum == -1) { 
            i("Stock Quantity is 0 as given Stock - " + companyName + " is not present in Stock List");            
            return 0;
        }
        String quantity = driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") > td:nth-child(4)")).getText();
        i(companyName + " :: Stock quantity is -- " + quantity);
        return Integer.parseInt(quantity);
    }
    public void openTransactionHistory(String companyName) { 
        int rowNum = getRowNumWithCellData("stockTable_id", companyName);
        if(rowNum == -1) 
            logError("Stock not present in list");
        
        WebElement firstTD = driver.findElement(By.cssSelector(("table#stock > tbody > tr:nth-child(" + rowNum + ") >td:nth-child(1)")));
        firstTD.click();
        // rediff specific
        // WebElement nextLineTD = driver.findElement(By.cssSelector("table#stock > tbody > tr:nth-child(" + rowNum + ") input.equityTransaction"));
        driver.findElement(By.id("btnTransactionHistory"));
    }
    public int getRowNumWithCellData(String locatorKey, String data) { 
        WebElement table = getElement(locatorKey);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(int rNum = 0; rNum < rows.size(); rNum++) { 
            WebElement row = rows.get(rNum);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(int cNum = 0; cNum < cells.size(); cNum++) { 
                WebElement cell = cells.get(cNum);
                if(!cell.getText().trim().equals("")) {
                    System.out.println("Cell Data :: " + cell.getText());
                    if(cell.getText().contains(data))
                        return (rNum);
                }
            }
        }
        return -1; // data is not found
    }
    public void login() {
        
    }
    
    public void selectDate() { 
        
    }
    public void quitDriver() {
        if(driver != null)
            driver.quit();
    }

    
}
