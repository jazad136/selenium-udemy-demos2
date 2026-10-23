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
        app.openBrowser("browser_name");
        app.openURL("URL");
        app.click("signIn_linkText");
        app.type("username_id", "student");
        app.type("password_id", "Password123");
        app.click("submitBtn_id");
        app.reportAll();
    }
    @Test
    public void deletePortfolio() { 
        app.i("Deleting portfolio...");
    }
}
