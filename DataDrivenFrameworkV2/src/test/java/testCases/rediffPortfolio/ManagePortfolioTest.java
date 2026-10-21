package testCases.rediffPortfolio;


import org.testng.ITestContext;
import org.testng.annotations.Test;


/**
 *
 * @author JonathanSaddler
 */
public class ManagePortfolioTest extends BaseTest{
    @Test
    public void createPortfolio(ITestContext con) { 
        app.i("Creating portfolio...");
//        app.reportFailure("Unable to create portfolio....");
//        app.openBrowser("browser_name");
//        app.openURL("URL");
    }
    @Test
    public void deletePortfolio() { 
        app.i("Deleting portfolio...");
    }
}
