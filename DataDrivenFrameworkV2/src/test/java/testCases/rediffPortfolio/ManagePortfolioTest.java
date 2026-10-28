package testCases.rediffPortfolio;


import org.testng.annotations.Test;


/**
 *
 * @author JonathanSaddler
 */
public class ManagePortfolioTest extends BaseTest{
    @Test
    public void createPortfolio() throws Exception { 
    	String portfolioName = "MyPortfolio9999";
        app.i("Creating portfolio...");
        app.click("createPortfolio_id");
        app.clear("portfolioname_id");
        app.type("portfolioname_id", portfolioName);
        app.click("confirmCreatePortfolio_id");
        app.waitForWebPageToLoad();
        app.validateSelectedValueInDropdown(portfolioName, "portfolio_dropdown_id");
        app.reportAll();
    }
    @Test
    public void deletePortfolio() throws Exception{ 
        String portfolioName = "MyPortfolio9999";
        app.waitForWebPageToLoad();
        app.i("Deleting portfolio...");
        app.selectByVisibleText("portfolio_dropdown_id", portfolioName);
        app.click("deletePortfolio_id");
        app.acceptAlert();
        app.waitForWebPageToLoad();
        app.validateSelectedValueNotInDropdown(portfolioName, "portfolio_dropdown_id");
    }
    
    public void selectPortfolio() throws Exception { 
        String portfolioName = "Portfolio50";
        app.i("Selecting Portfolio :: " + portfolioName);
        app.selectByVisibleText("portfolio_dropdown_id", portfolioName);
        app.waitForWebPageToLoad();
    }
}
