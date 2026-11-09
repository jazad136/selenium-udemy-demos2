/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testCases.rediffPortfolio;

import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class ManageStocksTest extends BaseTest{
    
    @Test
    public void verifyStockQuantity() { 
        String companyName = "YES Bank Ltd.";
        app.i("Verify Stock Quantity After Add Stock");
        int quantity = app.findCurrentStockQuantity(companyName);
        app.i(companyName + " :: New Stock Quantity is -- " + quantity);
    }
    @Test
    public void verifyTransactionHistory() { 
        String companyName = "YES Bank Ltd.";
        app.i("Verify Stock Transaction History After Add Stock.");
        String quantityDisplayed = app.getText("transactionTable_xpath");
        app.i("Got Stock : " + companyName + " - Available Quantity = " + quantityDisplayed);
    }
    
    @Test
    public void addStockTest() throws InterruptedException{ 
        app.i("Adding Stocks in Portfolio...");
        String companyName = "YES Bank";
        String selectionDate = "10-07-2022";
        String stockQuantity = "200";
        String stockPrice = "100";
        
        app.i("Selecting Stocks in Portfolio");
        app.click("addStock_id");
        app.type("addstockname_id", companyName);
        app.wait(2);
        app.clickEnterKey("addstockname_id");
        app.click("stockPurchaseDate_id");
        app.selectDateFromCalendar(selectionDate);
        app.type("addstockqty_id", stockPrice);
        app.click("addStockButton_id");
        app.waitForWebPageToLoad();
        app.i("Stock Added Successfully...");
    }
    @Test
    public void verifyStockIsPresent() { 
        String companyName = "YES Bank Ltd.";
        app.i("Verifying Added Stock in Portfolio...");
        int rowNum = app.getRowNumWithCellData("stockTable_id", companyName);
        if(rowNum == -1) { 
            app.reportFailure(companyName + " is not present in Stock List!!! ", true);
        }
        
    }
    public void modifyStockTest() { 
        app.i("Modifying Stocks in Portfolio...");
    }
}
